package artizens.controller.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadImageDTO {
	
	private int id;
	private String title;
	private MultipartFile file;
	private String talk;
	private String tagbox;
	private String subject;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UploadImageDTO() {	
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}


}
