package artizens.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.controller.dto.artwork.CreatorDTO;
import artizens.domain.ArtWork;
import artizens.domain.Creator;
import artizens.domain.UserProfile;
import artizens.mapper.ArtWorkImagesMapper;
import artizens.mapper.ArtWorkMapper;
import artizens.mapper.dto.ArtWorkMainDto;

@Service
public class ArtWorkService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkService.class);
	
	@Autowired ArtWorkMapper artWorkMapper;
	@Autowired ArtWorkImagesMapper artWorkImagesMapper; 
	
	public List<ArtWorkMainDto> selectAll( int s_page, int e_page ){
		if ( s_page == 1) {
			s_page = 0;
		}
		List<ArtWorkMainDto> result = artWorkMapper.findArtWorkMainAll( s_page, e_page );
		return result; 
	}
	
	public Long findByUserId( UserProfile user ) {
		
		Long UserId = user.getId();
		List<UserProfile> result = artWorkMapper.findByUserId( user );
		if ( result == null ) UserId = 0L;
		for( UserProfile id : result ) {
			UserId = id.getId();
		}
		LOGGER.info("userId={}",UserId);
		return UserId;
	}
	
	public Long findByCreatorId( String name ) {
		
		Long creatorId = 0L;
		List<Creator> creator = artWorkMapper.findByCreatorName( name );
		for( Creator info : creator ) {
			creatorId = info.getId();
		}
		LOGGER.info("creatorId={}",creatorId);
		
		return creatorId;
	}
	
	public Long findByCreator( Long userid ) {
		
		Long creatorId = 0L;
		List<Creator> creator = artWorkMapper.findByCreatorId( userid );
		for( Creator info : creator ) {
			creatorId = info.getId();
		}
		LOGGER.info("creatorId={}",creatorId);
		return creatorId;
	}
	
	public String findByAll( Long creatorId ) {
		List<CreatorDTO> creator = artWorkMapper.findByCreator( creatorId );
		String nickname = "";
		Long creatorid = creator.get(0).getCreatorid();
		for ( CreatorDTO infomation : creator ) {
			nickname = infomation.getNickname();
			creatorid = infomation.getCreatorid();
		}
		String result = nickname + "/" + creatorid;
		return result;
	}
}
