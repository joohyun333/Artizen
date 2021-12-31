package artizens.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.domain.UserProfile;
import artizens.web.session.SessionConst;
import lombok.Data;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
//	@GetMapping("/artizen")
//    public String home(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model, HttpServletRequest request){
//        //세션 없으면 main.html
//        if (user == null){
//            return "redirect:/";
//        }
//
//        //세션 유지되면 로그인이 된 loginMain.html 으로 이동
//        LoginUser loginUser = new LoginUser(user.getId(), user.getName());
////        model.addAttribute("member",loginUser);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
//        model.addAttribute("creationTime", simpleDateFormat.format(request.getSession().getCreationTime()));
//        return "/artizen/artwork/main";
//    }
	
	@GetMapping("/developing")
    public String developing(Model model){
    	model.addAttribute("alertActive", "developing");
    	return "thymeleaf/alert";
    }
}

class LoginUser {
    private Long id;
    private String username;

    public LoginUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + "]";
	}
    
}

