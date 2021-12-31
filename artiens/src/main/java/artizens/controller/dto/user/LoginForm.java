package artizens.controller.dto.user;

import javax.validation.constraints.NotBlank;

public class LoginForm {
	@NotBlank
    private String email;
    @NotBlank
    private String password;
    
    public LoginForm() {
		// TODO Auto-generated constructor stub
	}    
	public LoginForm(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
