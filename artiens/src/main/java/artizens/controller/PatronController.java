package artizens.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.controller.dto.patron.PatronRegisterDto;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.UserProfile;
import artizens.repository.querydsl.patron.PatronCreatorDto;
import artizens.repository.querydsl.patron.PatronCreatorRewardDto;
import artizens.service.CreatorService;
import artizens.service.PatronService;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/patron")
public class PatronController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatronController.class);
	
	@Autowired PatronService patronService;
	@Autowired CreatorService creatorService;
	
	@GetMapping
    public String patronMain(
    		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
    		Model model){
		LOGGER.info("user={}",user);
        model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
        return "thymeleaf/patron/patronMain/patronForm";
    }

    @GetMapping("/creator")
    public String patronCreator(
    		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
    		Model model, 
    		@PageableDefault(size = 15) Pageable pageable){
    	
        model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
        
        // 페이징 쿼리 -> Dto
        Page<PatronCreatorDto> pageResult = patronService.totalPatronView(pageable);
        LOGGER.info("msg={}", pageResult.getContent());
        model.addAttribute("results",pageResult);
        return "thymeleaf/patron/creator/creator";
    }

    @GetMapping("/register")
    public String patronRegisterForm(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model){
    	// 세션 없을때 
    	if (user == null) {
    		// 로그인안했을때 로그인페이지 -> register로 이동
    		model.addAttribute("alertActive","noUser");
    		model.addAttribute("redirectURL", "?redirectURL=patron/register");
    		return "thymeleaf/patron/patronAlert";
    	}
    	// 유저가 patron에 등록할 조건을 체크
    	model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
    	String patronAuthority = patronService.patronRegisterCondition(user.getId());
    	if (patronAuthority.equals("noCreator") || patronAuthority.equals("alreadyPatorn")) {
    		model.addAttribute("alertActive",patronAuthority);
    		return "thymeleaf/patron/patronAlert";
    	}
    	// creator에 등록이 된 유저인지 체크
    	List<Creator> creator = creatorService.findCreatorByuserProfileId(user.getId());
    	model.addAttribute("creatorId", creator.get(0).getId());
    	model.addAttribute("creatorName", creator.get(0).getNickName());
        return "thymeleaf/patron/patronRegister/rewardRegisterForm";
    }
    
    @PostMapping("/register")
    public String patronRegister(@ModelAttribute PatronRegisterDto patronRegisterDto, Model model) {
    	String saved = patronService.registerPatronAndReward(patronRegisterDto);
    	model.addAttribute("alertActive", saved);
    	return "thymeleaf/patron/patronAlert";
    }
    
 // patron 개인 폼
    @GetMapping("/{patronId}")
    public String patronForm(
    		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
    		@PathVariable("patronId") Long patronId,
    		Model model) {
    	PatronCreatorRewardDto result = patronService.personalPatronView(patronId);
    	if (result == null) {
    		model.addAttribute("alertActive", "noExistPatron");
    		return "thymeleaf/patron/patronAlert";
    	}
    	LOGGER.info("msg={}",result.toString());
    	model.addAttribute("result", result);
    	return "thymeleaf/patron/patronForm";
    }
    
    @GetMapping("/ok")
    public String patronOk(
    		@RequestParam(name="patron") String condition,
    		@RequestParam(name="id") String patronId,
    		Model model) {
    	if(condition.equals("ok")) {
    		model.addAttribute("alertActive", "patronOK");
    		model.addAttribute("patronId", patronId);
        	return "thymeleaf/patron/patronAlert";
    	}
    	model.addAttribute("alertActive", "noExistPatron");
    	return "thymeleaf/patron/patronAlert";
    }
}
