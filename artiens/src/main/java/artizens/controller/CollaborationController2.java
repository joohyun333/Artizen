package artizens.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.domain.UserProfile;
import artizens.mapper.CollaborationMapper2;
import artizens.mapper.dto.collaboration.CollaborationArtWorkInsertDto;
import artizens.mapper.dto.collaboration.CollaborationArtworkDetailDto;
import artizens.mapper.dto.collaboration.CollaborationDetailDto;
import artizens.repository.querydsl.collaboration.CollaborationInfoDto;
import artizens.service.CollaborationService2;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/collaboration")
public class CollaborationController2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController2.class);

	@Autowired CollaborationService2 collaborationService;
	@Autowired CollaborationMapper2 collaborationMapper;
	
	/**
	 * 공모전 상세 화면
	 * @param collaborationId
	 * @param model
	 * @return
	 */
	@GetMapping("/{collaborationId}")
	public String collaborationDetail(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
			@PathVariable Long collaborationId, 
			Model model) {
		
		CollaborationDetailDto result = collaborationService.collaborationDetailForm(collaborationId);
		if (result == null) {
			model.addAttribute("condition", "invalidRequest");
			return "col/col_Redirect";
		}
		model.addAttribute("result", result);
		
		if (user != null) {
			Long creatorId = collaborationMapper.findCreaotrByUserId(user.getId());
			model.addAttribute("creatorId", (creatorId == null || creatorId == 0L)? null:creatorId);
		}else model.addAttribute("creatorId", null);
		
		
		// 세션에 따른 헤더 설정 
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_Detail";
	}
	
	/**
	 * 참여 작품 상세 화면
	 * @param colArtId
	 * @return
	 */
	@GetMapping("/art/{collaborationArtWorkId}")
	public String colArt(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@PathVariable(name="collaborationArtWorkId") Long colArtId,
			Model model){
		CollaborationArtworkDetailDto result = collaborationService.collaborationArtWotkDetailForm(colArtId);
		if (result == null) {
			model.addAttribute("condition", "invalidRequest");
			return "col/col_Redirect";
		}
		model.addAttribute("result", result);
		// 세션에 따른 헤더 설정 
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_ArtWorkDetail";
	}
	
	/**
	 * 참여 작품 목록
	 * @return
	 */
	@GetMapping("/{collaborationId}/art")
	public String colArtList(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@PathVariable(name = "collaborationId") Long collaborationId,
			@PageableDefault(size=20) Pageable pageable,
			Model model) {
		// 세션에 따른 헤더 설정 
		CollaborationInfoDto result = collaborationService.totalColArtWorkByColId(pageable, collaborationId);
		if (result == null) {
			model.addAttribute("condition", "InvalidRequest");
			return "col/col_Redirect";
		}
		model.addAttribute("result", result);
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_ArtList";
	}
	
	/**
	 * 당선 작품 목록
	 * @return
	 */
	@GetMapping("/{collaborationId}/art/winner")
	public String colWInnerArtList(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@PathVariable(name = "collaborationId") Long collaborationId,
			@PageableDefault(size=20) Pageable pageable,
			Model model) {
		// 세션에 따른 헤더 설정 
		CollaborationInfoDto result = collaborationService.totalColArtWorkWinnerByColId(pageable, collaborationId);
		if (result == null || result.getArtWorks().getTotalElements() == 0) {
			model.addAttribute("condition", "underway");
			model.addAttribute("artworkValue", collaborationId);
			return "col/col_Redirect";
		}
		model.addAttribute("result", result);
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		return "col/col_ArtList";
	}
	
	/**
	 * 참여작품을 접수하는 화면
	 * @return
	 */
	@GetMapping("/art/register/{collaborationId}")
	public String colArtRegister(
			@PathVariable(name = "collaborationId") Long collaborationId,
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			Model model) {
		
		// 콜라보레이션에 참여할 권한이 있는지 체크
		String checkResult = collaborationService.checkRegisterArtWork(user, collaborationId);
		if (!checkResult.equals("pass")) {
			model.addAttribute("condition", checkResult);
			return "col/col_Redirect";
		}
		
		// 콜라보레이션의 정보를 select 
		CollaborationDetailDto colInfo = collaborationService.collaborationDetailForm(collaborationId);
		if (colInfo == null) {
			model.addAttribute("condition", "InvalidRequest");
			return "col/col_Redirect";
		}
		
		// 세션에 따른 헤더 설정 
		model.addAttribute("userid", ((user == null) ? null : user.getId()));
		model.addAttribute("collaborationId", colInfo.getId());
		model.addAttribute("collaborationTitle", colInfo.getTitle());
		return "col/col_ArtWorkRegister";
	}
	
	/**
	 * 참여 작품을 접수하는  controller
	 * @return
	 */
	@PostMapping("/art/register")
	public String colartReceipt(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@ModelAttribute CollaborationArtWorkInsertDto dto, 
			Model model) {
		Long insertCondition = collaborationService.insertCollaborationArtWotk(user, dto);
		model.addAttribute("update", "success");
		model.addAttribute("updateValue", insertCondition);
		return "col/col_Redirect";
	}
	
	/**
	 * 참여 작품을 수정하는 화면
	 * @return
	 */
	@GetMapping("/art/modify")
	public String colartReceiptModify(Model model) {
		return "col/col_artReceiptModify";
	}
}
