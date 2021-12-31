package artizens.controller.dto.artwork;

public class CreatorDTO {
	
	private Long creatorid;
	private Long userid;
	private String title;
	private String nickname;
	private String userprofileimage;
	private String otheruri;
	private String intro;
	
	
	@Override
	public String toString() {
		return "CreatorDTO [creatorid=" + creatorid + ", userid=" + userid + ", title=" + title + ", nickname="
				+ nickname + ", userprofileimage=" + userprofileimage + ", otheruri=" + otheruri + ", intro=" + intro
				+ "]";
	}
	public Long getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserprofileimage() {
		return userprofileimage;
	}
	public void setUserprofileimage(String userprofileimage) {
		this.userprofileimage = userprofileimage;
	}
	public String getOtheruri() {
		return otheruri;
	}
	public void setOtheruri(String otheruri) {
		this.otheruri = otheruri;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	
}
