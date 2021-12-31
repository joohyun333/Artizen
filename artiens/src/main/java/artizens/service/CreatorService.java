package artizens.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.Creator;
import artizens.repository.CreatorRepository;

@Service
@Transactional(readOnly = true)
public class CreatorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreatorService.class);
	
	@Autowired CreatorRepository creatorRepository;
	
	public Optional<Creator> findCreatorById(Long creatorId){
		return creatorRepository.findById(creatorId);
	}
	
	public List<Creator> findCreatorByuserProfileId(Long userProfileId){
		return creatorRepository.findAllByUserProfileId(userProfileId);
	}
}
