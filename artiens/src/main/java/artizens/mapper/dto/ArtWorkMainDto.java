package artizens.mapper.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class ArtWorkMainDto {
	 
	private Long id;
	private Long imageId;
	private String title;
	private String artworkImgName;
	private String creatorImgName;
	private String creatorNickName;
	private String registerday;
	private Integer likeCount;
	private Integer commentCount;
	
	private int page = 1;
	private int unit = 9;
	private int total;
	private String after;
	private String before;
	
	public int startno( int page ) {
		int startpage = ( page - 1) * this.unit + 1;
		return startpage;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public ArtWorkMainDto() {	
	}
	
	public String getRegisterday() {
		return registerday;
	}

	public void setRegisterday(String registerday) {
		this.registerday = registerday;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtworkImgName() {
		return artworkImgName;
	}
	public void setArtworkImgName(String artworkImgName) {
		this.artworkImgName = artworkImgName;
	}
	public String getCreatorImgName() {
		return creatorImgName;
	}
	public void setCreatorImgName(String creatorImgName) {
		this.creatorImgName = creatorImgName;
	}
	public String getCreatorNickName() {
		return creatorNickName;
	}
	public void setCreatorNickName(String creatorNickName) {
		this.creatorNickName = creatorNickName;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	public String Day( String registerday ) {
		SimpleDateFormat format = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		cal.getTimeInMillis();
		return "";
	}
	
}
