package artizens.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reward_images")
public class RewardImages {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reward_images_id")
	private Long id;
	
	@AttributeOverrides({
		@AttributeOverride(name = "uploadFileName", column = @Column(name = "reward_images_uploadfilename")),
		@AttributeOverride(name = "storeFileName", column = @Column(name = "reward_images_storefilename"))
	})
	@Embedded
	private UploadFile uploadFile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reward_id")
	private Reward reward;

	public RewardImages() {
	}
	
	public static RewardImages addImages(UploadFile uploadFile, Reward reward) {
		RewardImages rewardImages = new RewardImages();
		rewardImages.uploadFile = uploadFile;
		rewardImages.reward = reward;
		return rewardImages;
	}

	@Override
	public String toString() {
		return "RewardImages [id=" + id + ", uploadFile=" + uploadFile + ", reward=" + reward + "]";
	}
	
	
	
}
