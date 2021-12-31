package artizens.controller.dto.artwork;

public class ArtCommentDTO {
	private String content;
	private String registerDay;
	private String name;
	private String nickname;
	private String storefilename;
	private int total;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegisterDay() {
		return registerDay;
	}
	public void setRegisterDay(String registerDay) {
		this.registerDay = registerDay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStorefilename() {
		return storefilename;
	}
	public void setStorefilename(String storefilename) {
		this.storefilename = storefilename;
	}
	
	
}
