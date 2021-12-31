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
@Table(name = "collaboration_artwork_comment")
public class CollaborationArtWorkComment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collaboration_artwork_comment_id")
	private Long id;
	
	@Column(name = "collaboration_artwork_comment_content", length = 255)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collaboration_artwork_id")
	private CollaborationArtWork collaborationArtWork;

	public CollaborationArtWorkComment() {
	}
	
}
