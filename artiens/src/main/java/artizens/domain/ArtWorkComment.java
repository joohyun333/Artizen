package artizens.domain;

import java.util.Date;

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
@Table(name = "artwork_comment")
public class ArtWorkComment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artwork_comment_id")
	private Long id;
	
	@Column(name = "artwork_comment_conetent", length = 255)
	private String content;
	
	@Column(name = "artwork_comment_register_date")
	private Date registerDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_profile_id")
	private UserProfile userProfile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="artwork_id")
	private ArtWork artWork;

	public ArtWorkComment() {
	}
	
	
}
