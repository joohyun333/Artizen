package artizens.repository.querydsl.patron;

public class RewardImagesDto {
	Long rewardId;
	String rewardUploadFileName;
	
	public RewardImagesDto(Long rewardId, String rewardUploadFileName) {
		this.rewardId = rewardId;
		this.rewardUploadFileName = rewardUploadFileName;
	}

	public Long getRewardId() {
		return rewardId;
	}

	public String getRewardUploadFileName() {
		return rewardUploadFileName;
	}
}
