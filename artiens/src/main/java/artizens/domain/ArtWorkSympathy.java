package artizens.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artwork_sympathy")
public class ArtWorkSympathy {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artwork_sympathy_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artwork_id")
	private ArtWork artWork;

	public ArtWorkSympathy() {
	}
}
