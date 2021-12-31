package artizens.controller.dto.artwork;

public class UploadTextDTO {
	
	private String id;
	private String title;
	private String nickname;
	private String talk;
	private String subject;
	private String tagbox;
	
	@Override
	public String toString() {
		return "UploadTextDTO [id=" + id + ", title=" + title + ", nickname=" + nickname + ", talk=" + talk
				+ ", subject=" + subject + ", tagbox=" + tagbox + "]";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getTalk() {
		return talk;
	}
	public void setTalk(String talk) {
		this.talk = talk;
	}
	public String getTagbox() {
		return tagbox;
	}
	public void setTagbox(String tagbox) {
		this.tagbox = tagbox;
	}
	
}
