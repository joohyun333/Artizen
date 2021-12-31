package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.collaboration.CollaborationArtWorkInsertDto;
import artizens.mapper.dto.collaboration.CollaborationArtworkDetailDto;
import artizens.mapper.dto.collaboration.CollaborationDetailDto;

@Mapper
public interface CollaborationMapper2 {
	
	/**
	 * Collaboration 공모전 상세 페이지 query
	 * @param collaborationId
	 * @return
	 */
	@Results(id = "collaboratonResult", value = {
		@Result(property = "id", column = "collaboration_id", id =true),
		@Result(property = "title", column = "collaboration_title"),
		@Result(property = "registerDate", column = "collaboration_register_date"),
		@Result(property = "deadlineTime", column = "collaboration_deadline_date"),
		@Result(property = "evaluate", column = "collaboration_evaluate"),
		@Result(property = "creatorId", column = "creator_id"),
		@Result(property = "creatorNickname", column = "creator_nickname"),
		@Result(property = "creatorImgName", column = "creator_profile_storefilename"),
		@Result(property = "contentImgName", column = "collaboration_storefilename"),
		@Result(property = "content", column = "collaboration_content")
	})
	@Select("select * from collaboration"
			+ " left join creator"
			+ " on collaboration.creator_id = creator.creator_id"
			+ " where collaboration.collaboration_id=${collaborationId}")
	CollaborationDetailDto findCollaborationById(Long collaborationId);
	
	/** 
	 * 공모전의 참가작품 상세 페이지 query
	 * @param collaborationArtWorkId
	 * @return
	 */
	@Results(id = "collaboratonArtWorkResult", value = {
			@Result(property = "id", column = "collaboration_artwork_id", id =true),
			@Result(property = "title", column = "collaboration_artwork_title"),
			@Result(property = "registerDate", column = "collaboration_artwork_register_date"),
			@Result(property = "creatorId", column = "creator_id"),
			@Result(property = "winner", column = "collaboration_artwork_winner"),
			@Result(property = "creatorNickname", column = "creator_nickname"),
			@Result(property = "creatorImgName", column = "creator_profile_storefilename"),
			@Result(property = "contentImgName", column = "collaboration_artwork_storefilename"),
			@Result(property = "content", column = "collaboration_artwork_content"),
			@Result(property = "collaborationTitle", column = "collaboration_title"),
			@Result(property = "collaborationId", column = "collaboration_id")
		})
	@Select("select * from collaboration_artwork"
			+ " left join creator"
			+ " on collaboration_artwork.creator_id = creator.creator_id"
			+ " left join collaboration"
			+ " on collaboration_artwork.collaboration_id = collaboration.collaboration_id" 
			+ " where collaboration_artwork.collaboration_artwork_id=${collaborationArtWorkId}")
	CollaborationArtworkDetailDto findaCollaboArtWorkById(Long collaborationArtWorkId);
	
	/**
	 * 공모전 참가작품 insert query
	 * @param collaborationArtWorkInsertDto
	 */
	@Insert("insert into collaboration_artwork("
			+ "collaboration_artwork_title,"
			+ "collaboration_artwork_content,"
			+ "collaboration_artwork_register_date,"
			+ "collaboration_artwork_storefilename,"
			+ "collaboration_artwork_winner,"
			+ "collaboration_id,"
			+ "creator_id) values(#{title}, #{content}, now() ,#{fileName}, false, ${collaborationId}, ${creatorId})")
	@Options(useGeneratedKeys = true, keyProperty = "collaborationArtWorkId", keyColumn = "collaboration_artwork_id")
	void insertCollaborationArtWork(CollaborationArtWorkInsertDto collaborationArtWorkInsertDto);
	
	/**
	 * 공모전에 참가할 자격 확인(creator인지 확인)
	 * @param userId
	 * @return creator_id
	 */
	@Select("select creator_id from creator where user_profile_id = ${userId}")
	Long findCreaotrByUserId(Long userId);
	
	/**
	 * 해당 creator가 주최한 collaboration 확인 
	 * @param creatorId
	 * @return collaboration_id
	 */
	@Select("select collaboration_id from collaboration where creator_id = ${creatorId}")
	List<Long> findCollaborationByCreatorId(Long creatorId);
	
	/**
	 * 공모전에 참여한 creator의 수
	 * @param collaborationId
	 * @param creatorId
	 * @return
	 */
	@Select("select count(*) from collaboration_artwork where collaboration_id = ${collaborationId} and creator_id = ${creatorId}")
	int countCollaborationByCreatorId(Long collaborationId, Long creatorId);
}
