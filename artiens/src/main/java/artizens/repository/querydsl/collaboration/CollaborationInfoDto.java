package artizens.repository.querydsl.collaboration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CollaborationInfoDto {
	private Long collaborationId;
	private String collaborationTitle;
	private Long collaborationCreatorId;
	private String collaborationCreatorName;
	private String collaborationCreatorImage;
	private LocalDateTime colRegisterDateTime;
	private LocalDateTime colDeadlineDateTime;
	private Boolean colEvaluate;
	private Page<CollaborationArtWorkDto> artWorks;
	
	public CollaborationInfoDto(
			Long collaborationId, 
			String collaborationTitle, 
			Long collaborationCreatorId,
			String collaborationCreatorName,
			String collaborationCreatorImage, 
			LocalDateTime colRegisterDateTime, 
			LocalDateTime colDeadlineDateTime,
			Boolean colEvaluate) {
		
		this.collaborationId = collaborationId;
		this.collaborationTitle = collaborationTitle;
		this.collaborationCreatorId = collaborationCreatorId;
		this.collaborationCreatorName = collaborationCreatorName;
		this.collaborationCreatorImage = collaborationCreatorImage;
		this.colRegisterDateTime = colRegisterDateTime;
		this.colDeadlineDateTime = colDeadlineDateTime;
		this.colEvaluate = colEvaluate;
	}
	public Long getCollaborationId() {
		return collaborationId;
	}
	public String getCollaborationTitle() {
		return collaborationTitle;
	}
	public Long getCollaborationCreatorId() {
		return collaborationCreatorId;
	}
	public String getCollaborationCreatorName() {
		return collaborationCreatorName;
	}
	public String getCollaborationCreatorImage() {
		return collaborationCreatorImage;
	}
	public String getColRegisterDateTime() {
		return colRegisterDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	public String getColDeadlineDateTime() {
		return colDeadlineDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	public Boolean getColEvaluate() {
		return colEvaluate;
	}
	public Page<CollaborationArtWorkDto> getArtWorks() {
		return artWorks;
	}
	public void setArtWorks(Page<CollaborationArtWorkDto> artWorks) {
		this.artWorks = artWorks;
	}
	
	
}
