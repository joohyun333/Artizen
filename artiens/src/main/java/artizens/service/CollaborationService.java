package artizens.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.Collaboration;
import artizens.domain.UploadFile;
import artizens.mapper.CollaborationMapper;
import artizens.mapper.dto.collaboration.CollaborationDto;
import artizens.repository.CollaborationRepository;
import artizens.web.aws.FileUploadService;


@Service
@Transactional
public class CollaborationService {
	
	
	@Autowired CollaborationMapper collaborationMapper;
	@Autowired CollaborationRepository collaborationRepository;
	@Autowired FileUploadService fileUploadService;
	
	
	// collaboration insert service method
	public CollaborationDto insertCollaboration(CollaborationDto dto) {
		// collaboration insert
		collaborationMapper.insertCollaboration(dto);
		
		// mutipartfile -> aws -> uploadfile객체로 loadW
		UploadFile image = fileUploadService.uploadImage(dto.getCollaborationImage());
		CollaborationDto imageDto = new CollaborationDto(dto.getCollaborationId(), image.getStoreFileName());
		collaborationMapper.insertCollaborationImage(imageDto);
		return dto;
	}
	
	public List<CollaborationDto> findAllByCollaboration(){
//		return collaborationRepository.findAll();
		return collaborationMapper.findAllCollaboration();
	}
}
