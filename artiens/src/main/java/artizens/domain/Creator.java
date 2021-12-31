package artizens.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "creator")
public class Creator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "creator_id")
	private Long id;

	@Column(name = "creator_nickname", length = 45)
	private String nickName;

	@AttributeOverrides({
			@AttributeOverride(name = "uploadFileName", column = @Column(name = "creator_profile_uploadfilename")),
			@AttributeOverride(name = "storeFileName", column = @Column(name = "creator_profile_storefilename")) })
	@Embedded
	private UploadFile uploadFile;

	@Column(name = "creator_one_intro", length = 45)
	private String oneIntro;
	
	@Column(name = "creator_detail_intro", length = 5000)
	private String detailIntro;
	
	@Column(name = "creator_other_uri", length = 200)
	private String otherUri;
	
	@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
	private List<ArtWork> artWork;
	
	@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
	private List<Collaboration> collaboration;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;

	public Creator() {
	}
	
	public static Creator createCreator(String nickName, String otherUri,
			UserProfile userProfile) {
		Creator creator = new Creator();
		creator.nickName = nickName;
		creator.otherUri = otherUri;
		creator.userProfile = creator.addCreatorInUserProfile(userProfile);
		return creator;
	}

	public static Creator createCreator(String nickName, UploadFile uploadFile, String otherUri,
			UserProfile userProfile) {
		Creator creator = new Creator();
		creator.nickName = nickName;
		creator.uploadFile = uploadFile;
		creator.otherUri = otherUri;
		creator.userProfile = creator.addCreatorInUserProfile(userProfile);
		return creator;
	}

	public UserProfile addCreatorInUserProfile(UserProfile userProfile) {
		if (userProfile != null) {
			userProfile.addCreatorInUserProfile(this);
			return userProfile;
		}
		return null;
	}

	public Long getId() {
		return id;
	}

	public String getNickName() {
		return nickName;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public String getOtherUri() {
		return otherUri;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public String getOneIntro() {
		return oneIntro;
	}

	public String getDetailIntro() {
		return detailIntro;
	}
	
	
}
