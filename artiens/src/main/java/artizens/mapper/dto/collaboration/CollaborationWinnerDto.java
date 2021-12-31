package artizens.mapper.dto.collaboration;

public class CollaborationWinnerDto {
	
	private Long collaborationId;
	private String image;
	private String title;
	private Long creatorId;
	
	/*
	 * creator nickname 
	 */
	private String nickname;
	
	private int colArtworkId;
	
	

	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public int getColArtworkId() {
		return colArtworkId;
	}
	public void setColArtworkId(int colArtworkId) {
		this.colArtworkId = colArtworkId;
	}
	public Long getCollaborationId() {
		return collaborationId;
	}
	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	
}
