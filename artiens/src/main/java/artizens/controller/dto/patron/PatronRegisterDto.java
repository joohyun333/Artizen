package artizens.controller.dto.patron;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PatronRegisterDto {
	
	private Long creatorId;
	private String patronTitle;
	private String patronAuthor;
	private String patronContent;
	private List<MultipartFile> patronFiles;
	private String rewardTitle;
	private String rewardCategory;
	private int rewardPrice;
	private String rewardContent;
	private List<MultipartFile> rewardFiles;
	public Long getCreatorId() {
		return creatorId;
	}
	public String getPatronTitle() {
		return patronTitle;
	}
	public String getPatronAuthor() {
		return patronAuthor;
	}
	public String getPatronContent() {
		return patronContent;
	}
	public List<MultipartFile> getPatronFiles() {
		return patronFiles;
	}
	public String getRewardTitle() {
		return rewardTitle;
	}
	public String getRewardCategory() {
		return rewardCategory;
	}
	public int getRewardPrice() {
		return rewardPrice;
	}
	public String getRewardContent() {
		return rewardContent;
	}
	public List<MultipartFile> getRewardFiles() {
		return rewardFiles;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public void setPatronTitle(String patronTitle) {
		this.patronTitle = patronTitle;
	}
	public void setPatronAuthor(String patronAuthor) {
		this.patronAuthor = patronAuthor;
	}
	public void setPatronContent(String patronContent) {
		this.patronContent = patronContent;
	}
	public void setPatronFiles(List<MultipartFile> patronFiles) {
		this.patronFiles = patronFiles;
	}
	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}
	public void setRewardCategory(String rewardCategory) {
		this.rewardCategory = rewardCategory;
	}
	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}
	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}
	public void setRewardFiles(List<MultipartFile> rewardFiles) {
		this.rewardFiles = rewardFiles;
	}
	@Override
	public String toString() {
		return "PatronRegisterDto [creatorId=" + creatorId + ", patronTitle=" + patronTitle + ", patronAuthor="
				+ patronAuthor + ", patronContent=" + patronContent + ", patronFiles=" + patronFiles + ", rewardTitle="
				+ rewardTitle + ", rewardCategory=" + rewardCategory + ", rewardPrice=" + rewardPrice
				+ ", rewardContent=" + rewardContent + ", rewardFiles=" + rewardFiles + "]";
	}
	
}
