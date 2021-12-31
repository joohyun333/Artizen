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
@Table(name = "artwork_artwork_tag")
public class ArtWorkArtWorkTag {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artwork_artwork_tag_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artwork_id")
	private ArtWork artWork;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artwork_tag_id")
	private ArtWrokTag artWrokTag;

	public ArtWorkArtWorkTag() {
	}
	
}
