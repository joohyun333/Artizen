package artizens.repository.querydsl.reward;

import java.util.List;

public class RewardImageDto {
	private Long rewardId;
	private String rewardFileName;
	
	public RewardImageDto(Long rewardId, String rewardFileName) {
		this.rewardId = rewardId;
		this.rewardFileName = rewardFileName;
	}
	public Long getRewardId() {
		return rewardId;
	}
	public String getRewardFileName() {
		return rewardFileName;
	}
	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}
	public void setRewardFileName(String rewardFileName) {
		this.rewardFileName = rewardFileName;
	}
	@Override
	public String toString() {
		return "RewardImageDto [rewardId=" + rewardId + ", rewardFileName=" + rewardFileName + "]";
	}
	
}
