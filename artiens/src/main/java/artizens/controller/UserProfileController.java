package artizens.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import artizens.controller.dto.user.JoinForm;
import artizens.controller.dto.user.LoginForm;
import artizens.domain.UserProfile;
import artizens.service.UserProfileService;
import artizens.web.interceptor.LoginCheckInterceptor;
import artizens.web.session.SessionConst;

@Controller
public class UserProfileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired private UserProfileService userProfileService;
	
	@GetMapping("/login")
    public String userLogin(@ModelAttribute LoginForm loginForm,
                            @ModelAttribute JoinForm joinForm,
                            @RequestParam(value = "redirectURL", required = false, defaultValue = "") String redirectURL,
                            Model model) {
        model.addAttribute("redirectPath",redirectURL);
        return "thymeleaf/login/loginForm";
    }

    @PostMapping("/login")
    public String loginOk(@Validated LoginForm loginForm,
                          BindingResult bindingResult,
                          HttpServletRequest request,
                          @RequestParam(value = "redirectURL", required = false, defaultValue = "") String redirectURL,
                          RedirectAttributes redirectAttributes,
                          Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("loginCheck", false);
            model.addAttribute("joinForm", new JoinForm());
            return "thymeleaf/login/loginForm";
        }

        UserProfile loginUser = userProfileService.login(loginForm.getEmail(), loginForm.getPassword());
        if (loginUser == null) {
            model.addAttribute("loginCheck", false);
            model.addAttribute("joinForm", new JoinForm());
            return "thymeleaf/login/loginForm";
        }

        //로그인 성공 처리

        //세션이 있는 경우, 세션 변환, 아닐 시 신규 세션 생성
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        session.setMaxInactiveInterval(3600);
        if (redirectURL.equals("null")){
        	return "redirect:/";
        }
        LOGGER.info("redirectURL={}", redirectURL);
        return "redirect:/" + redirectURL;
    }

    @PostMapping("/join")
    public String joinOk(@Validated JoinForm joinForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
    	
        if (!joinForm.getPassword().isEmpty()&&!joinForm.getPassword().equals(joinForm.getRepassword())){
            bindingResult.rejectValue("repassword", "NotCoincide.JoinForm.repassword");
        }
        
        if (bindingResult.hasErrors()){
            model.addAttribute("joinCheck", false);
            model.addAttribute("loginForm", new LoginForm());
            return "thymeleaf/login/loginForm";
        }
        String joinOk = userProfileService.join(joinForm.getEmail(), joinForm.getPassword(), joinForm.getUsername());
        if (joinOk.equals("alreadyEmail")) {
            bindingResult.rejectValue("email", "AlreadyExist.JoinForm.email");
            model.addAttribute("joinCheck", false);
            model.addAttribute("loginForm", new LoginForm());
            return "thymeleaf/login/loginForm";
        }
        else if (joinOk.equals("alreadyName")) {
        	bindingResult.rejectValue("username", "AlreadyExist.JoinForm.username");
            model.addAttribute("joinCheck", false);
            model.addAttribute("loginForm", new LoginForm());
            return "thymeleaf/login/loginForm";
		}
        else if (joinOk.equals("alreadyEmailName")) {
        	bindingResult.rejectValue("username", "AlreadyExist.JoinForm.alreadyEmailName");
            model.addAttribute("joinCheck", false);
            model.addAttribute("loginForm", new LoginForm());
            return "thymeleaf/login/loginForm";
		}
        redirectAttributes.addAttribute("joinCheck", true);
        return "redirect:/login";

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate(); // 세션 제거
        }
        return "redirect:/";
    }
	
} 
