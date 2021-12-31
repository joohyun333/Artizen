package artizens.repository.querydsl.patron;

import java.util.List;
import java.util.stream.Collectors;

public class RewardDto {
	private Long rewardId;
	private String rewardTitle;
	private String rewardContent;
	private String rewardSubject;
	private int rewardPrice;
	private List<String> rewardImages;
	
	public RewardDto(
			Long rewardId, 
			String rewardTitle, 
			String rewardContent,
			String rewardSubject,
			int rewardPrice) {
		this.rewardId = rewardId;
		this.rewardTitle = rewardTitle;
		this.rewardContent = rewardContent;
		this.rewardSubject = rewardSubject;
		this.rewardPrice = rewardPrice;
	}

	public Long getRewardId() {
		return rewardId;
	}

	public String getRewardTitle() {
		return rewardTitle;
	}

	public String getRewardContent() {
		return rewardContent;
	}
	
	public String getRewardSubject() {
		return rewardSubject;
	}
	
	public List<String> getRewardImages() {
		return rewardImages;
	}
	
	public int getRewardPrice() {
		return rewardPrice;
	}
	
	public void setRewardImages(List<RewardImagesDto> rewardImages) {
		this.rewardImages = rewardImages.stream().map(r -> r.getRewardUploadFileName()).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "RewardDto [rewardId=" + rewardId + ", rewardTitle=" + rewardTitle + ", rewardContent=" + rewardContent
				+ ", rewardSubject=" + rewardSubject + ", rewardImages=" + rewardImages + "]";
	}
	
	
}
