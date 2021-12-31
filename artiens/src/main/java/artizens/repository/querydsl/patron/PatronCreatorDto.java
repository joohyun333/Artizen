package artizens.repository.querydsl.patron;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PatronCreatorDto {
	private Long patronId;
	private String patronTitle;
	private String patronContenet;
	private String patronRegisterDate;
	private List<String> patronStoredFiles;
	private String creatorNickName;
	private String creatorStoredFiles;
	
	public PatronCreatorDto(
			Long patronId, 
			String patronTitle, 
			String patronContenet, 
			LocalDateTime patronRegisterDate,
			String creatorNickName, 
			String creatorStoredFiles) {
		this.patronId = patronId;
		this.patronTitle = patronTitle;
		this.patronContenet = patronContenet;
		this.patronRegisterDate = patronRegisterDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.creatorNickName = creatorNickName;
		this.creatorStoredFiles = creatorStoredFiles;
	}
	
	
	// PatronImagesDto의 patronUploadFileName만 추출
	public void setPatronStoredFiles(List<PatronImagesDto> patronStoredFiles) {
		this.patronStoredFiles = patronStoredFiles.stream().map(file -> file.getPatronUploadFileName()).collect(Collectors.toList());
	}



	public Long getPatronId() {
		return patronId;
	}
	public String getPatronTitle() {
		return patronTitle;
	}
	public String getPatronContenet() {
		return patronContenet;
	}
	public String getPatronRegisterDate() {
		return patronRegisterDate;
	}
	public List<String> getPatronStoredFiles() {
		return patronStoredFiles;
	}
	public String getCreatorNickName() {
		return creatorNickName;
	}
	public String getCreatorStoredFiles() {
		return creatorStoredFiles;
	}
	
	@Override
	public String toString() {
		return "PatronCreatorDto [patronId=" + patronId + ", patronTitle=" + patronTitle + ", patronContenet="
				+ patronContenet + ", patronRegisterDate=" + patronRegisterDate + ", patronStoredFiles="
				+ patronStoredFiles + ", creatorNickName=" + creatorNickName + ", creatorStoredFiles="
				+ creatorStoredFiles + "]";
	}

}
