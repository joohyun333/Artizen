package artizens.repository.querydsl.patron;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PatronCreatorRewardDto {
	private Long patronId;
	private String patronTitle;
	private String patronContent;
	private List<String> patronImages;
	private String patronCreatedDate;
	private String creatorNickName;
	private String creatorProfileImage;
	private List<RewardDto> rewards;
	
	public PatronCreatorRewardDto(
			Long patronId, 
			String patronTitle, 
			String patronContent, 
			String creatorNickName,
			LocalDateTime patronCreatedDate,
			String creatorProfileImage) {
		this.patronId = patronId;
		this.patronTitle = patronTitle;
		this.patronContent = patronContent;
		this.creatorNickName = creatorNickName;
		this.patronCreatedDate = patronCreatedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.creatorProfileImage = creatorProfileImage;
	}

	public Long getPatronId() {
		return patronId;
	}

	public String getPatronTitle() {
		return patronTitle;
	}

	public String getPatronContent() {
		return patronContent;
	}

	public List<String> getPatronImages() {
		return patronImages;
	}

	public String getCreatorNickName() {
		return creatorNickName;
	}

	public List<RewardDto> getRewards() {
		return rewards;
	}
	
	public void setPatronImages(List<PatronImagesDto> patronImages) {
		this.patronImages = patronImages.stream().map(p -> p.getPatronUploadFileName()).collect(Collectors.toList());;
	}
	
	public void setRewards(List<RewardDto> rewards) {
		this.rewards = rewards;
	}
	
	public String getPatronCreatedDate() {
		return patronCreatedDate;
	}
	
	
	public String getCreatorProfileImage() {
		return creatorProfileImage;
	}

	@Override
	public String toString() {
		return "PatronCreatorRewardDto [patronId=" + patronId + ", patronTitle=" + patronTitle + ", patronContent="
				+ patronContent + ", patronImages=" + patronImages + ", creatorNickName=" + creatorNickName
				+ ", rewards=" + rewards + "]";
	}

	
	
	
}	
