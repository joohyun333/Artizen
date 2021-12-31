package artizens.mapper.dto.collaboration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

public class CollaborationMainDto {
	
//	private Long 
	private Long collaborationId;
	private String title;
	private String deadLineDate;
	private String deadLineYear;
	private String deadLineMonth;
	private String deadLineDay;
	private String registerDate;
	private String storedFileName;
	private MultipartFile collaborationImage;
	private Long creatorId;
	private String creatorNickName;
	private String creatorProfileStoredFileName;
	private int artworkcount;
	private int deadLineDateCompare;
	private boolean evaluate;
	
	
	public CollaborationMainDto() {
		super();
	}
	public Long getCollaborationId() {
		return collaborationId;
	}
	public String getTitle() {
		return title;
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
	public String getDeadLineYear() {
		return deadLineYear;
	}
	public String getDeadLineMonth() {
		return deadLineMonth;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public String getDeadLineDay() {
		return deadLineDay;
	}
	public String getCreatorNickName() {
		return creatorNickName;
	}
	public String getCreatorProfileStoredFileName() {
		return creatorProfileStoredFileName;
	}
	public int getDeadLineDateCompare() {
		return deadLineDateCompare;
	}
	public int getArtworkcount() {
		return artworkcount;
	}
	public boolean isEvaluate() {
		return evaluate;
	}
	
	

	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDeadLineDate(String deadLineDate) {
		this.deadLineDate = (deadLineDate!=null)?deadLineDate:null;
		this.deadLineYear = (deadLineDate!=null)?deadLineDate.split("-")[0]:null;
		this.deadLineMonth = (deadLineDate!=null)?deadLineDate.split("-")[1]:null;
		this.deadLineDay = (deadLineDate!=null)?deadLineDate.split("-")[2].substring(0,2):null;
		this.deadLineDateCompare = LocalDateTime.parse(deadLineDate,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")).compareTo(LocalDateTime.now());
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate.substring(0,10);
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public void setCollaborationImage(MultipartFile collaborationImage) {
		this.collaborationImage = collaborationImage;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public void setCreatorNickName(String creatorNickName) {
		this.creatorNickName = creatorNickName;
	}
	public void setCreatorProfileStoredFileName(String creatorProfileStoredFileName) {
		this.creatorProfileStoredFileName = creatorProfileStoredFileName;
	}
	public void setArtworkcount(int artworkcount) {
		this.artworkcount = artworkcount;
	}
	public void setEvaluate(boolean evaluate) {
		this.evaluate = evaluate;
	}
	@Override
	public String toString() {
		return "CollaborationMainDto [collaborationId=" + collaborationId + ", title=" + title + ", deadLineDate="
				+ deadLineDate + ", deadLineYear=" + deadLineYear + ", deadLineMonth=" + deadLineMonth
				+ ", deadLineDay=" + deadLineDay + ", registerDate=" + registerDate + ", storedFileName="
				+ storedFileName + ", collaborationImage=" + collaborationImage + ", creatorId=" + creatorId
				+ ", creatorNickName=" + creatorNickName + ", creatorProfileStoredFileName="
				+ creatorProfileStoredFileName + ", artworkcount=" + artworkcount + ", deadLineDateCompare="
				+ deadLineDateCompare + ", evaluate=" + evaluate + "]";
	}
}
