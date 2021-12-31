package artizens.controller.dto.artwork;

import artizens.domain.UserProfile;

public class InsertDto {
	
	String title;
	String content;
	UserProfile upProfile;
	
	public InsertDto() {
	}
	
	public InsertDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "title = "+ title + ", content = " + content;
	}

	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public UserProfile getUpProfile() {
		return upProfile;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUpProfile(UserProfile upProfile) {
		this.upProfile = upProfile;
	}
	
}
