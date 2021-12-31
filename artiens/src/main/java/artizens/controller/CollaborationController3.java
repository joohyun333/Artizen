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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.domain.UserProfile;
import artizens.mapper.dto.collaboration.CollaborationCollaboratorDto;
import artizens.mapper.dto.collaboration.CollaborationWinnerDto;
import artizens.service.CollaborationService3;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/collaboration")
public class CollaborationController3 {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController3.class);

	@Autowired CollaborationService3 collaborationService3;
	
	/**
	 * 당선작을 선택하는 화면
	 * @return
	 */
	@GetMapping("/winner/{collaboId}")
	public String winnerSelect(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@PathVariable Long collaboId, Model model) {
		List<CollaborationWinnerDto> result = collaborationService3.findAllCollaborationWinner( collaboId);
		CollaborationCollaboratorDto collaborator = collaborationService3.findCollaborator(collaboId);
		model.addAttribute("result", result);
		model.addAttribute("collaborator", collaborator);
		// 세션에 따른 헤더 설정 
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_Winner";
	}
	
	/**
	 * 당선작을 처리하는 화면
	 * @return
	 */
	@PostMapping("/choice")
	public String winnerUpdate(@RequestParam(name = "checkeds") List<Integer> value, Model model ) {
		LOGGER.info("msg={}", value);
		if (value == null || value.size() == 0 ) {
			model.addAttribute("msg","winnerNotSelect");
			return "col/col_Redirect";
		}
		String result = collaborationService3.winnerUpdate(value); 
		if( result.equals("success") ) {
			model.addAttribute("msg","winnerComplete");
			return "col/col_Redirect";
		}else {
			model.addAttribute("msg","winnerFail");
			return "col/col_Redirect";
		}
			
	}
	
}
