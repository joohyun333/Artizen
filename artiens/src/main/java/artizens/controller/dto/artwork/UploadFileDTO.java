package artizens.controller.dto.artwork;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileDTO {
	
	/**
	 * 아이디
	 */
	private Long artworkId;
	/**
	 * 프로필 아이디값
	 */
	private Long userProfileId;
	/**
	 * 작품 제목
	 */
	private String title;
	
	/**
	 * 닉네임
	 */
	private String nickname;

	/**
	 * 이미지 파일
	 */
	private MultipartFile file;
	
	/**
	 * 태그 종류
	 */
	private String tagbox;
	
	/**
	 * 작품 종류
	 */
	private String subject;
	
	/**
	 * 작가의 말
	 */
	private String talk;
	
	/**
	 * 크리에이터 아이디
	 */
	private Long creatorId;
	
	

	@Override
	public String toString() {
		return "UploadFileDTO [artworkId=" + artworkId + ", userProfileId=" + userProfileId + ", title=" + title
				+ ", nickname=" + nickname + ", file=" + file + ", tagbox=" + tagbox + ", subject=" + subject
				+ ", talk=" + talk + ", creatorId=" + creatorId + "]";
	}



	public Long getUserProfileId() {
		return userProfileId;
	}



	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}



	public Long getCreatorId() {
		return creatorId;
	}



	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	

	public Long getArtworkId() {
		return artworkId;
	}

	public void setArtworkId(Long artworkId) {
		this.artworkId = artworkId;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public UploadFileDTO() {
		
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

	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}
	
	
	
}