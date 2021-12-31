package artizens.controller.dto.artwork;

public class ArtCategoryDTO {
	
	private Long imageId;
	private Long creatorId;
	private String storefilename;
	private String title;
	private String registerday;
	private String profileimage;
	private String nickname;
	
	
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public String getStorefilename() {
		return storefilename;
	}
	public void setStorefilename(String storefilename) {
		this.storefilename = storefilename;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegisterday() {
		return registerday;
	}
	public void setRegisterday(String registerday) {
		this.registerday = registerday;
	}
	
	
}
