package artizens.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.controller.dto.artwork.ArtCategoryDTO;
import artizens.controller.dto.artwork.ArtCommentDTO;
import artizens.controller.dto.artwork.ArtDetailDTO;
import artizens.controller.dto.artwork.CommentDTO;
import artizens.controller.dto.artwork.BlogInfoDTO;
import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.mapper.ArtMapper;
import artizens.mapper.ArtWorkImagesMapper;
import artizens.web.aws.FileUploadService;

@Service
public class ArtService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkService.class);
	
	@Autowired ArtMapper artMapper;
	@Autowired ArtWorkImagesMapper artWorkImagesMapper;
	@Autowired FileUploadService fileUploadService;
	@Autowired ArtService artService;
	
	public int findByCateoryTotal(String Category) {
		String cate = "";
		if ( Category.equals("ink") ) {
			cate ="수묵화";
		}else if ( Category.equals("color") ) {
			cate ="채색화";
		}else if ( Category.equals("landscape") ) {
			cate ="풍경화";
		}else if ( Category.equals("figure") ) {
			cate ="인물화";
		}else if ( Category.equals("abstract") ) {
			cate ="추상화";
		}else if ( Category.equals("still") ) {
			cate ="정물화";
		}else if ( Category.equals("pop") ) {
			cate ="팝아트";
		}
		return artMapper.findByCateoryTotal(cate);
	}
	
	public int findByTotal() {
		return artMapper.findByTotal();
	}
	
	public String insertImageUpload( UploadFileDTO uploadfiledto ) {
		
		UploadFileDTO upload = new UploadFileDTO();
		Long creator_id = artMapper.findByCreator(uploadfiledto.getNickname());		
		
		LOGGER.info("크리에이터아이디입니다={}",creator_id);
		upload.setTalk(uploadfiledto.getTalk());
		upload.setSubject(uploadfiledto.getSubject());
		upload.setTitle(uploadfiledto.getTitle());
		upload.setCreatorId(creator_id);
		artMapper.insertArtWork( upload );
		
		upload.setFile( uploadfiledto.getFile() );
		UploadFile uploadFile = fileUploadService.uploadImage( upload.getFile() );
		artWorkImagesMapper.insertArtWork( uploadFile.getStoreFileName(), uploadFile.getUploadFileName(), upload.getArtworkId());
		
		return "success";
	}
	
	public String noneCreatorUpload( UploadFileDTO uploadfiledto ) {
		
		UploadFileDTO upload = new UploadFileDTO();
		
		upload.setNickname(uploadfiledto.getNickname());
		upload.setUserProfileId(uploadfiledto.getUserProfileId());
		artMapper.insertCreatorNickname( upload );
		
		upload.setTalk(uploadfiledto.getTalk());
		upload.setSubject(uploadfiledto.getSubject());
		upload.setTitle(uploadfiledto.getTitle());
		upload.setCreatorId(upload.getCreatorId());
		artMapper.insertArtWork( upload );
		
		upload.setFile( uploadfiledto.getFile() );
		UploadFile uploadFile = fileUploadService.uploadImage( upload.getFile() );
		LOGGER.info("업로드이미지파일={}",uploadFile.getStoreFileName());
		artWorkImagesMapper.insertArtWork( uploadFile.getStoreFileName(), uploadFile.getUploadFileName(), upload.getArtworkId());
		
		return "success";
	}
	
	public List<StoreFileDTO> findByAll( Long creator ) {
		return artMapper.findByImageURL( creator );
	}
	
	public List<StoreFileDTO> findByProfile( Long creator ) {
		List<StoreFileDTO> store = artMapper.findByCreatorImage( creator );
		return store;
	}
	
	public List<StoreFileDTO> findByRecent( Long creator ) {
		List<StoreFileDTO> store = artMapper.findByRecent( creator );
		return store;
	}
	
	public String findByCreatorImage(Long creatorId ) {
		String profileImage = artMapper.findByCreatorProfileImage(creatorId);
		return profileImage;
	}
	
	public String findByCreatorName( Long creator ) {
		String nickname = artMapper.findByCreatorName(creator);
		return nickname;
	}
	
	public Long findByCreator(String nickname) {
		Long creatorId = artMapper.findByCreator(nickname);
		return creatorId;
	}
	
	public List<BlogInfoDTO> findByCreatorForBlogAll(Long creatorid ) {
		List<BlogInfoDTO> store = artMapper.findByCreatorBlogAll( creatorid );
		return store;
	}
	
	public ArtDetailDTO clickImageAction( Long imageId ) {
		
		List<ArtDetailDTO> store = artMapper.clickImageAction(imageId);
		ArtDetailDTO detail = new ArtDetailDTO();
		for( ArtDetailDTO a : store) {
			detail.setTitle(a.getTitle());
			detail.setTalk(a.getTalk());
			detail.setProfile(a.getProfile());
			detail.setNickname(a.getNickname());
			detail.setContent(a.getContent());
			detail.setImages(a.getImages());
			detail.setDate(a.getDate());
			detail.setArtworkId(a.getArtworkId());
		}
		LOGGER.info("detail={}",detail.toString());
		return detail;
	}
	
	public int findByCommentTotal(Long artworkid) {
		return artMapper.findByCommentTotal(artworkid);
	}
	
	public String InsertComment( CommentDTO commentDto ) {
		artMapper.insertComment( commentDto );
		return "success";
	}
	
	public List<ArtCategoryDTO> findByCategory(String page,int startno, int unit) {
		if ( startno == 1 ) {
			startno = 0;
		}
		return artMapper.findByCategory(page,startno,unit);
	}
	
	public Long findByArtworkId(Long imageId) {
		return artMapper.findByArtWorkId(imageId);
	}
	
	public List<ArtCommentDTO> findByCommentAll( Long artwork_id ) {
		List<ArtCommentDTO> result = artMapper.findByCommentAll( artwork_id );
		return result; 
	}
}