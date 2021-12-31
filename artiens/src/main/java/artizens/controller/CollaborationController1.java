package artizens.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.domain.UserProfile;
import artizens.mapper.dto.collaboration.CollaborationMainDto;
import artizens.mapper.dto.collaboration.CollaborationPlanningDto;
import artizens.service.CollaborationService1;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/collaboration")
public class CollaborationController1 {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController1.class);

	@Autowired CollaborationService1 collaborationService1;
	
	/**
	 *  공모전 메인 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/main")
	public String collaborationMain(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
			Model model) {
		List<CollaborationMainDto> result = collaborationService1.findAllByCollaboration();
		LOGGER.info("msg2={}", result);
		model.addAttribute("result", result);
		
		if(user != null) {
			model.addAttribute("userId",user.getId());
			Long creatorId = collaborationService1.findCreatorId(user.getId());
			
			if(creatorId != null) {
			model.addAttribute("creatorId",creatorId);
			}
			
		}
		// 세션에 따른 헤더 설정 
					model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_Main";
	}
	
	/**
	 *  공모전 등록 화면
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping("/planning/{creatorId}")
	public String insertCollaboration(
		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
		@PathVariable Long creatorId,
		Model model) throws Exception {
		model.addAttribute("creatorId",creatorId);
		
		// 세션에 따른 헤더 설정 
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_Planning";
	}
	
	/**
	 *  공모전 등록 처리
	 * @param collaborationDto
	 * @return
	 */
	@PostMapping("/planning")
	public String viewCollaborationResult(@ModelAttribute CollaborationPlanningDto collaborationDto, Model model) {
		String dto = collaborationService1.insertCollaboration(collaborationDto);
		LOGGER.info("msg2={}", dto.toString());
		
		if( dto.equals("success") ) {
			model.addAttribute("msg","colRegister");
			return "col/col_Redirect";
		}else {
			model.addAttribute("msg","colFail");
			return "col/col_Redirect";
		}
	}
	
	/**
	 * 공모전 정보를 수정하는 화면
	 * @return
	 */
	@GetMapping("/planning/modify")
	public String colplanningModify() {
		return "col/col_planningModify";
	}
}
