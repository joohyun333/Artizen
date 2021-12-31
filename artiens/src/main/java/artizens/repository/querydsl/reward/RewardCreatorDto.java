package artizens.repository.querydsl.reward;

import java.util.List;

public class RewardCreatorDto {
	private Long rewardId;
	private Long patronId;
	private String rewardTitle;
	private int rewardPrice;
	private String rewardFileName;
	private String creatorName;
	
	public RewardCreatorDto(
			Long rewardId, 
			Long patronId, 
			String rewardTitle, 
			int rewardPrice, 
			String creatorName) {
		this.rewardId = rewardId;
		this.patronId = patronId;
		this.rewardTitle = rewardTitle;
		this.rewardPrice = rewardPrice;
		this.creatorName = creatorName;
	}
	
	public Long getRewardId() {
		return rewardId;
	}

	public Long getPatronId() {
		return patronId;
	}

	public String getRewardTitle() {
		return rewardTitle;
	}

	public int getRewardPrice() {
		return rewardPrice;
	}

	public String getRewardFileName() {
		return rewardFileName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}

	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}

	public void setRewardFileName(List<RewardImageDto> rewardFileName) {
		if (rewardFileName != null && rewardFileName.size()>0) {
			this.rewardFileName = rewardFileName.get(0).getRewardFileName();
		}
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
}
