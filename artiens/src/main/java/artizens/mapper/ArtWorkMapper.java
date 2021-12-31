package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import artizens.controller.dto.artwork.CreatorDTO;
import artizens.domain.ArtWork;
import artizens.domain.Creator;
import artizens.domain.UserProfile;
import artizens.mapper.dto.AbstractDto;
import artizens.mapper.dto.ArtWorkMainDto;
import artizens.mapper.dto.ColoringDto;
import artizens.mapper.dto.FigureDto;
import artizens.mapper.dto.InkpaintingDto;
import artizens.mapper.dto.LandscapeDto;
import artizens.mapper.dto.PopartDto;
import artizens.mapper.dto.StillDto;

@Mapper
public interface ArtWorkMapper {
	
	@Select("Select creator_id as creatorId, "
			+ "		creator_nickname as nickname, "
			+ "		creator_one_intro as intro, "
			+ "     creator_other_uri as otheruri, "
			+ "		creator_profile_storefilename as storefile, "
			+ "		user_profile_id as userid "
			+ "		from creator where creator_id = ${creatorId} ")
	List<CreatorDTO> findByCreator( Long creatorId );
	
	@Select("Select * from artwork")
	List<ArtWork> findArtWorkAll();
	
	@Select("Select * from artwork where artwork_images_id = ${artwork_images_id}")
	List<ArtWork> findArtWork();
	
	@Select("Select user_profile_id as id from user_profile where user_profile_email=#{email}")
	List<UserProfile> findByUserId(UserProfile loginUser);
	
	@Select("Select creator_id as id from creator where creator_nickname = #{nickname}")
	List<Creator> findByCreatorName(String nickname);
	
	@Select("Select creator_id as id from creator where user_profile_id = ${userid}")
	List<Creator> findByCreatorId(Long userid);
	
	@Insert("Insert into artwork(artwork_category_name, artwork_content, artwork_register_date, artwork_title) values(#{subject},#{talk},now(),#{title})")
	void InsertUploadImg(String subject, String talk, String title);
	
	@Insert("Insert into artWork(artwork_id, artwork_title, artwork_content) values((select * from (select max(next_val)+1 from hibernate_sequence) next), #{title}, #{content})")
	void insertArtWork(String title, String content);
	
	// 작품 메인 페이지 최신순 출력 쿼리
	@Select("select creator.creator_id as id,"
			+ "		artwork_images.artwork_images_id as imageId,"
			+ "		artwork.artwork_register_date as registerday, "
			+ "     artwork_images.artwork_images_storefilename as artworkImgName, "
			+ "     creator.creator_profile_storefilename as creatorImgName,"
			+ "     artwork.artwork_title as title "
			+ "from artwork_images left join artwork "
			+ "on artwork_images.art_work_id = artwork.artwork_id left "
			+ "join creator on artwork.creator_id = creator.creator_id "
			+ "order by artwork_register_date desc limit ${epage } offset ${spage }")
	List<ArtWorkMainDto> findArtWorkMainAll(int spage, int epage );
	
	// 수묵화 상세페이지 출력 쿼리
	@Select("")
	List<InkpaintingDto> findInkpainting();
	
	// 채색화 상세페이지 출력 쿼리
	@Select("")
	List<ColoringDto> findColoring();
	
	// 풍경화 상세페이지 출력 쿼리
	@Select("")
	List<LandscapeDto> findLandscape();
	
	// 인물화 상세페이지 출력 쿼리
	@Select("")
	List<FigureDto> findFigure();
	
	// 추상화 상세페이지 출력 쿼리
	@Select("")
	List<AbstractDto> findAbstract();
	
	// 정물화 상세페이지 출력 쿼리
	@Select("")
	List<StillDto> findStill();
	
	// 팝아트 상세페이지 출력 쿼리
	@Select("")
	List<PopartDto> findPopart();
	
}
