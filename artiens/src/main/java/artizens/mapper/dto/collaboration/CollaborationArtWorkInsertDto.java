package artizens.mapper.dto.collaboration;

import org.springframework.web.multipart.MultipartFile;

public class CollaborationArtWorkInsertDto {
	
	private Long collaborationArtWorkId;
	private Long creatorId;
	private Long collaborationId;
	private String title;
	private String content;
	private MultipartFile file;
	private String fileName;
	
	
	
	
	public Long getCollaborationArtWorkId() {
		return collaborationArtWorkId;
	}
	public void setCollaborationArtWorkId(Long collaborationArtWorkId) {
		this.collaborationArtWorkId = collaborationArtWorkId;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Long getCollaborationId() {
		return collaborationId;
	}
	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "CollaborationArtWorkInsertDto [collaborationArtWorkId=" + collaborationArtWorkId + ", creatorId="
				+ creatorId + ", collaborationId=" + collaborationId + ", title=" + title + ", content=" + content
				+ ", file=" + file + ", fileName=" + fileName + "]";
	}
	
}
