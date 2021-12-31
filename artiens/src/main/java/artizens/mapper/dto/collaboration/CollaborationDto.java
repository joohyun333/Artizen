package artizens.mapper.dto.collaboration;

import org.springframework.web.multipart.MultipartFile;

public class CollaborationDto {
//	private Long 
	private Long collaborationId;
	private Long collaborationImageId;
	private String title;
	private String content;
	private String deadLineDate;
	private String registerDate;
	private String storedFileName;
	private MultipartFile collaborationImage;
	
	public CollaborationDto() {
		super();
	}
	public CollaborationDto(Long collaborationId, String storedFileName) {
		this.collaborationId = collaborationId;
		this.storedFileName = storedFileName;
	}
	public Long getCollaborationId() {
		return collaborationId;
	}
	public Long getCollaborationImageId() {
		return collaborationImageId;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getDeadLineDate() {
		return deadLineDate;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public MultipartFile getCollaborationImage() {
		return collaborationImage;
	}
	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public void setCollaborationImageId(Long collaborationImageId) {
		this.collaborationImageId = collaborationImageId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDeadLineDate(String deadLineDate) {
		this.deadLineDate = deadLineDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public void setCollaborationImage(MultipartFile collaborationImage) {
		this.collaborationImage = collaborationImage;
	}
	@Override
	public String toString() {
		return "CollaborationDto [collaborationId=" + collaborationId + ", collaborationImageId=" + collaborationImageId
				+ ", title=" + title + ", content=" + content + ", deadLineDate=" + deadLineDate + ", registerDate="
				+ registerDate + ", storedFileName=" + storedFileName + ", collaborationImage=" + collaborationImage
				+ "]";
	}
}
