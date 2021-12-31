package artizens.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import artizens.controller.dto.artwork.ArtCategoryDTO;
import artizens.controller.dto.artwork.ArtCommentDTO;
import artizens.controller.dto.artwork.ArtDetailDTO;
import artizens.controller.dto.artwork.CommentDTO;
import artizens.controller.dto.artwork.MainPageDTO;
import artizens.controller.dto.artwork.BlogInfoDTO;
import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.mapper.ArtMapper;
import artizens.mapper.ArtWorkMapper;
import artizens.mapper.UserMapper;
import artizens.mapper.dto.ArtWorkMainDto;
import artizens.service.ArtService;
import artizens.service.ArtWorkService;
import artizens.web.aws.FileUploadService;
import artizens.web.session.SessionConst;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;

@Controller
public class ArtController {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtController.class);
	
	@Autowired FileUploadService fileUploadService;
	@Autowired UserMapper userMapper;
	@Autowired ArtService artService;
	@Autowired ArtWorkService artWorkService;
	@Autowired ArtWorkMapper artWorkMapper;
	
	@GetMapping("/blog/my/{creator}")
	public String userBlog( @PathVariable Long creator, RedirectAttributes redirectAttribute,
							@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							String createId,
							Model model) throws Exception {
		
		if ( user == null ) return "redirect:/";
		Long userid = artWorkService.findByUserId(user);
		Long creator_id = artWorkService.findByCreator(userid);
		if ( creator_id == creator ) {
			List<StoreFileDTO> store = artService.findByAll( creator );
			model.addAttribute("store",store);
			List<StoreFileDTO> profile = artService.findByProfile( creator );
			List<StoreFileDTO> recent = artService.findByRecent( creator );
			model.addAttribute("recent",recent);
			BlogInfoDTO bloginfoDTO = new BlogInfoDTO();
			for( StoreFileDTO a : profile ) {
				bloginfoDTO.setNickname(a.getNickname());
				bloginfoDTO.setImages(a.getProfileImage());
				bloginfoDTO.setContent(a.getContent());
			}
			LOGGER.info("블로그프로필정보={}",bloginfoDTO);
			LOGGER.info("content={}",bloginfoDTO.getContent());
			model.addAttribute("profile",bloginfoDTO);
			model.addAttribute("creator",creator);
			return "artWork/ArtWorkMyBlog";
			
		}else {
			model.addAttribute("message","잘못된 접근입니다.");
		}
		return "artWork/ArtWorkMyBlog";
	}
	
	@GetMapping("/blog/{creatorid}")
	public String otherBlog(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
							@PathVariable Long creatorid, Model model ) throws Exception {
		
		if ( user == null ) {
			model.addAttribute("userid",0);
		}else {
			Long id = artWorkService.findByUserId(user);
			model.addAttribute("userid",id);
		}
		List<StoreFileDTO> profile = artService.findByProfile( creatorid );
		List<StoreFileDTO> recent = artService.findByRecent( creatorid );
		model.addAttribute("recent",recent);
		BlogInfoDTO bloginfo = new BlogInfoDTO();
		for( StoreFileDTO a : profile ) {
			bloginfo.setNickname(a.getNickname());
			bloginfo.setContent(a.getContent());
			bloginfo.setProfile(a.getProfileImage());
		}		
		model.addAttribute("profile",bloginfo);
		
		List<BlogInfoDTO> creatorinfo = artService.findByCreatorForBlogAll( creatorid );
		model.addAttribute("creatorinfo",creatorinfo);
		return "/artWork/ArtWorkOtherBlog";
	}
	
	@GetMapping("/upload")
	public String FileUpload(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							 Model model) {
		
		Long id = artWorkService.findByUserId(user);
		Long create_id = artWorkService.findByCreator(id);
		
		model.addAttribute("userid", id);
	
		if ( create_id == 0 || create_id == null ) {
			model.addAttribute("creatorNickname",null);
		}else {
			String nickname = "";
			List<StoreFileDTO> profile = artService.findByProfile( create_id );
			for( StoreFileDTO a : profile ) nickname = a.getNickname();
			
			model.addAttribute("Nickname",nickname);
			model.addAttribute("creator",create_id);
		}
		
		return "FileUpload/Upload";
	}
	
	@PostMapping("/upload")
	public String FileSave( @ModelAttribute UploadFileDTO uploadfiledto, Model model ) throws Exception {
		
		String message = "";
		Long creatorId = artService.findByCreator( uploadfiledto.getNickname() );
		if ( creatorId == null ) creatorId = 0L;
		// 새로운 크리에이터 등록 및 작품 등록
		if ( creatorId == 0 ) {
			String upload = artService.noneCreatorUpload(uploadfiledto);
			if ( upload.equals("success") ) {
				message = "Success insert creator";
				model.addAttribute("message",message);
				return "include/Alert";
			}else { 
				message = "fail";
				model.addAttribute("message",message);
				return "include/Alert";
			}
		// 기존 크리에이터 값은 존재하며 작품 등록	
		}else if( creatorId != 0 ) {
			String upload = artService.insertImageUpload(uploadfiledto);
			
			if (upload.equals("success")) {
				message = "Success image upload";
				model.addAttribute("message",message);
				return "include/Alert";
			}else {
				model.addAttribute("message","fail");
				return "include/Alert";
			}
		}
		return "FileUpload/Upload";
	}
	
	@GetMapping
	public String artworkMain(	@ModelAttribute ArtWorkMainDto artWorkMainDto,
								@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
								Model model) {
		
		int unit = artWorkMainDto.getUnit();
		int page = artWorkMainDto.getPage();
		int startno = artWorkMainDto.startno(page);
		int endno = startno + ( unit-1 );
		int total = artService.findByTotal();
		LOGGER.info("total={}",total);
		int totalpage = (int) Math.ceil( (double)total / unit );
		int startpage = ( ( page-1 ) / 5 ) * 5 + 1; // 
		int endpage = startpage + 4 ;
		if ( endpage >= totalpage ) { 
			endpage = totalpage;
		}

		model.addAttribute("page",page);
		model.addAttribute("total",total);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startno",startno);
		model.addAttribute("endno",endno);
		model.addAttribute("spage",startpage);
		model.addAttribute("endpage",endpage);
		
		if (user == null) { // 비회원일 경우
			List<ArtWorkMainDto> result = artWorkService.selectAll(startno,unit);
			total = artService.findByTotal();
			model.addAttribute("result", result);
			return "artWork/ArtWorkMain";
		}else if( user != null ) { // 로그인 상태일 경우,
			total = artService.findByTotal();

			Long id = artWorkService.findByUserId(user);
			model.addAttribute("userid",id);
			Long creator = artWorkService.findByCreator(id);
			
			List<ArtWorkMainDto> result2 = artWorkService.selectAll(startno,unit);
			model.addAttribute("result", result2);
			
			if ( creator == 0 || creator == null ) { // 크리에이터 아이디가 없는 경우,
				model.addAttribute("creator", null);
			}else if( creator > 0 || creator != null ){ // 크리에이터 아이디가 있는 경우,
				
				total = artService.findByTotal();

				// 크리에이터
				String info = artWorkService.findByAll( creator );
				String nick = info.split("/")[0];
				String cid = info.split("/")[1];
				
				// 아이디 값
				model.addAttribute("creatorId",cid);
				model.addAttribute("creator",creator);
				// 닉네임 값
				model.addAttribute("nickname",nick);
				
				// 모든 작품들 
				List<ArtWorkMainDto> result = artWorkService.selectAll(startno,unit);
				model.addAttribute("result", result);
			}
		}
		return "artWork/ArtWorkMain";
	}
	
	@GetMapping("/artwork/detail/{imageId}")
	public String ArtWorkDatail(@PathVariable Long imageId,
								@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user, Model model) {
		
		ArtDetailDTO detail = artService.clickImageAction(imageId);
		List<ArtCommentDTO> commentList = artService.findByCommentAll(detail.getArtworkId());
		int total = artService.findByCommentTotal(detail.getArtworkId());
		model.addAttribute("total",total);
		model.addAttribute("artwork",detail);
		model.addAttribute("comment",commentList);
		if ( user != null ) {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("userid",userid);
			Long creator = artWorkService.findByCreator(userid);
			model.addAttribute("creator",creator);
			model.addAttribute("imageId",imageId);
		}else {
			model.addAttribute("userid",null);
		}
		return "artWork/ArtWorkDetail";
	}
			
	@PostMapping("/artwork/detail/comment/save/{imageId}")
	public String commentSave( @PathVariable Long imageId,
							   @ModelAttribute CommentDTO commentDto, Model model ) {
		String message = artService.InsertComment(commentDto);
		LOGGER.info("message={}",message);
		if ( message == "success" ) {
			model.addAttribute("message","댓글등록성공");
			model.addAttribute("imageURL",imageId);
			return "include/Alert";
		}else {
			model.addAttribute("message","댓글등록실패");
			return "include/Alert";
		}
	}
	
	@GetMapping("/login/check/creator")
	public String loginCheckForm(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model){
		if ( user == null ) {
			model.addAttribute("message","잘못된 접근입니다");
			return "include/Alert";
		}else {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("userid",userid);
			Long creator = artWorkService.findByCreator(userid);
			if ( creator == null || creator == 0 ) {
				model.addAttribute("creator_id",null);
				model.addAttribute("message","크리에이터로 등록되지 않은 아이디 입니다");
				return "include/Alert";
			}else {
				model.addAttribute("creator_id",creator);
				model.addAttribute("message","크리에이터로 등록된 아이디입니다");
				return "include/Alert";
			}
		}
	}

	// 작품 카테고리별  상세 페이지
	@GetMapping("/artwork/{categorypage}")
	public String inkpainting(@PathVariable String categorypage, Model model, @ModelAttribute ArtWorkMainDto artWorkMainDto,
							  @SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user) {
		
		int unit = artWorkMainDto.getUnit();
		int nowpage = artWorkMainDto.getPage();
		int startno = artWorkMainDto.startno(nowpage);
		int endno = startno + ( unit-1 );
		int total = artService.findByCateoryTotal(categorypage);
		int totalpage = (int) Math.ceil( (double)total / unit );
		int startpage = ( ( nowpage-1 ) / 5 ) * 5 + 1; // 
		int endpage = startpage + 4 ;
		if ( endpage >= totalpage ) { 
			endpage = totalpage;
		}
		
		model.addAttribute("catepage",categorypage);
		model.addAttribute("nowpage",nowpage);
		model.addAttribute("total",total);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startno",startno);
		model.addAttribute("endno",endno);
		model.addAttribute("spage",startpage);
		model.addAttribute("endpage",endpage);
		
		
		if ( user == null ) {
			model.addAttribute("user",0);
		}else {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("user",userid);
		}
		String category = "";
		if (categorypage.equals("ink")) {
			category = "수묵화";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (categorypage.equals("color")) {
			category = "채색화";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (categorypage.equals("landscape")) {
			category = "풍경화";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (categorypage.equals("figure")) {
			category = "인물화";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (categorypage.equals("abstract")) {
			category = "추상화";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (categorypage.equals("still")) {
			category = "정물화";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (categorypage.equals("pop")) {
			category = "팝아트";
			List<ArtCategoryDTO> store = artService.findByCategory(category,startno,unit);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else {
			model.addAttribute("message","잘못된 접근입니다");
			return "include/Alert";
		}
	}
	
	@GetMapping("/mypage/{userid}")
	public String mypage(@PathVariable Long userid, Model model, 
						 @SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user) {
		
		return "";
	}

}
	