package artizens.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_profile_id")
	private Long id;
	
	@Column(name = "user_profile_email", length = 100 ,nullable = false)
	private String email;
	
	@Column(name = "user_profile_password", length = 45, nullable = false)
	private String password;
	
	@Column(name = "user_profile_name", length = 45, nullable = false)
	private String name;
	
	@Column(name = "user_profile_register_date", nullable = false)
	private Date registerDate;
	
	@OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
	private Creator creator;
	
	@OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
	private List<ArtWorkComment> artWorkComment;
	
	public UserProfile() {
	}

	public static UserProfile createUser(String email, String password, String name) {
		UserProfile userProfile = new UserProfile();
		userProfile.email = email;
		userProfile.password = password;
		userProfile.name = name;
		userProfile.registerDate = new Date();
		return userProfile;
	}
	
	public void addCreatorInUserProfile(Creator creator) {
		this.creator = creator;
	}
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public Creator getCreator() {
		return creator;
	}	
	
}
