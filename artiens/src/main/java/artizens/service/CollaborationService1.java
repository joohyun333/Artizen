package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.mapper.CollaborationMapper;
import artizens.mapper.CollaborationMapper1;
import artizens.mapper.dto.collaboration.CollaborationDto;
import artizens.mapper.dto.collaboration.CollaborationMainDto;
import artizens.mapper.dto.collaboration.CollaborationPlanningDto;
import artizens.repository.CollaborationRepository;
import artizens.web.aws.FileUploadService;

@Service
@Transactional
public class CollaborationService1 {
	
	@Autowired CollaborationMapper1 collaborationMapper1;
	@Autowired CollaborationRepository collaborationRepository;
	@Autowired FileUploadService fileUploadService;
	
	
	// collaboration insert service method
	public String insertCollaboration(CollaborationPlanningDto dto) {
		// mutipartfile -> aws -> uploadfile객체로 loadW
		// collaboration insert
		UploadFile image = fileUploadService.uploadImage(dto.getCollaborationImage());
		dto.setStoredFileName(image.getStoreFileName());
		collaborationMapper1.insertCollaboration(dto);
		return "success";
	}
	
	public List<CollaborationMainDto> findAllByCollaboration(){
//		return collaborationRepository.findAll();
		return collaborationMapper1.findAllCollaboration();
	}
	
	public Long findCreatorId(Long userid) {
		return collaborationMapper1.findCreatorId(userid);
	}

}
