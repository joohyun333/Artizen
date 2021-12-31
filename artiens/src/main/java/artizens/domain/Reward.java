package artizens.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward extends BaseTimeEntity{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reward_id")
	private Long id;
	
	@Column(name = "reward_title", length = 45)
	private String title;
	
	@Column(name = "reward_content", length = 10000)
	private String content;
	
	@Column(name = "reward_price")
	private int price;
	
	@Column(name = "reward_suject", length = 45)
	private String subject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patron_id")
	private Patron patron;
	
	@OneToMany(mappedBy = "reward", cascade = CascadeType.ALL)
	private List<RewardImages> rewardImages;
	
	public Reward() {
	}

	public static Reward createReward(
			String title, 
			String content, 
			int price, 
			String subject, 
			Patron patron,
			List<UploadFile> rewardImages) {
		Reward reward = new Reward();
		reward.title = title;
		reward.content = content;
		reward.price = price;
		reward.subject = subject;
		reward.patron = patron;
		reward.rewardImages = reward.addRewardInRewardImages(rewardImages);
		return reward;
	}
	
	public List<RewardImages> addRewardInRewardImages(List<UploadFile> rewardImages) {
		List<RewardImages> rewardImagesList = new ArrayList<RewardImages>();
		if (rewardImages.size() > 0) {
			for (UploadFile images : rewardImages) {
				rewardImagesList.add(RewardImages.addImages(images, this));
			}
		}
		return rewardImagesList;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getPrice() {
		return price;
	}

	public String getSubject() {
		return subject;
	}

	public Patron getPatron() {
		return patron;
	}

	public List<RewardImages> getRewardImages() {
		return rewardImages;
	}

	@Override
	public String toString() {
		return "Reward [id=" + id + ", title=" + title + ", content=" + content + ", price=" + price + ", subject="
				+ subject + ", patron=" + patron + "]";
	}
	
	
}
