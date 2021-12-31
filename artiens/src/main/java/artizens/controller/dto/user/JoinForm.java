package artizens.controller.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class JoinForm {
    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String repassword;
    
    public JoinForm() {
		// TODO Auto-generated constructor stub
	}
    
	public JoinForm(String name, String email, String username, String password, String repassword) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.repassword = repassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
    
    
}
