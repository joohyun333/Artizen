package artizens.controller.dto.artwork;

public class CommentDTO {
	
	private String comment;
	private Long userid;
	private Long artworkId;
	
	@Override
	public String toString() {
		return "CommentDTO [comment=" + comment + ", userid=" + userid + ", artworkId=" + artworkId + "]";
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(Long artworkId) {
		this.artworkId = artworkId;
	}

	
	
}
