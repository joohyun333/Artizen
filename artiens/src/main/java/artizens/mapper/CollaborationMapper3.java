package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import artizens.mapper.dto.collaboration.CollaborationCollaboratorDto;
import artizens.mapper.dto.collaboration.CollaborationWinnerDto;

@Mapper
public interface CollaborationMapper3 {

	// 작품선정 리스트
	@Select("SELECT artwork.collaboration_artwork_storefilename, "
			+ "		artwork.collaboration_artwork_id, " 
			+ "		artwork.collaboration_artwork_title, "
			+ "		artwork.creator_id, "
			+ "		creator.creator_nickname " 
			+ "	FROM collaboration_artwork AS artwork " 
			+ "		JOIN creator "
			+ "			ON artwork.creator_id = creator.creator_id"
			+ "	WHERE artwork.collaboration_id = ${collaboration_id}")
	@Results({ @Result(property = "collaborationId", column = "collaboration_id", id = true),
			   @Result(property = "image", column = "collaboration_artwork_storefilename"),
			   @Result(property = "title", column = "collaboration_artwork_title"),
			   @Result(property = "colArtworkId", column = "collaboration_artwork_id"),
			   @Result(property = "nickname", column = "creator_nickname") })
	List<CollaborationWinnerDto> findAllCollaborationWinner(Long collaboration_id);

	
	  @Select("SELECT creator.creator_profile_storefilename, " 
			+ "		  creator.creator_nickname, " 
			+ "		  collaboration.collaboration_title, "
			+ "		  collaboration.collaboration_id, "
			+ "		  creator.creator_id, " 
			+ "		  collaboration.collaboration_register_date " 
			+ "	 FROM creator " 
			+ "	 JOIN collaboration " 
			+ "	   ON creator.creator_id = collaboration.creator_id " 
			+ "	WHERE collaboration.collaboration_id = ${collaboId}")
	  @Results({
	  @Result(property = "title", column = "collaboration_title"),
	  @Result(property = "collaborationId", column = "collaboration_id"),
	  @Result(property = "onenickname", column = "creator_nickname"),
	  @Result(property = "creatorId", column = "creator_id"),
	  @Result(property = "creatorimage", column = "creator_profile_storefilename"),
	  @Result(property = "registerdate", column = "collaboration_register_date") })
	  CollaborationCollaboratorDto findcollaborator(Long collaboId);


	  @Update("UPDATE collaboration_artwork artwork "
			  + "		JOIN collaboration "
			  + "		ON artwork.collaboration_id = collaboration.collaboration_id "
			  + "		SET artwork.collaboration_artwork_winner = true , collaboration.collaboration_evaluate = true "
			  + "		WHERE collaboration_artwork_id = ${value}")
	  int winnerUpdate(Integer value);
	  
	  

	  

}
