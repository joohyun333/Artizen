package artizens.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import artizens.mapper.CollaborationMapper3;
import artizens.mapper.dto.collaboration.CollaborationCollaboratorDto;
import artizens.mapper.dto.collaboration.CollaborationWinnerDto;

@Service
public class CollaborationService3 {
	@Autowired CollaborationMapper3 collaborationMapper3;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationService3.class);
	
	public List<CollaborationWinnerDto> findAllCollaborationWinner( Long collaboId){
		List<CollaborationWinnerDto> result = collaborationMapper3.findAllCollaborationWinner(collaboId);
		return result;
	}

	public CollaborationCollaboratorDto findCollaborator(Long collaboId) {
		
		return collaborationMapper3.findcollaborator(collaboId);
	}

	public String winnerUpdate(List<Integer> value) {
		for( Integer a: value ) {
			collaborationMapper3.winnerUpdate(a);			
		}
		return "success";
	}
	
}
