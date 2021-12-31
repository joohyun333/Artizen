package artizens.mapper.dto;

public class InsertUserDto {
	
	private Long id;
	private String email;
	private String name;
	private String password;
	
	@Override
	public String toString() {
		return "InsertUserDto [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + "]";
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
