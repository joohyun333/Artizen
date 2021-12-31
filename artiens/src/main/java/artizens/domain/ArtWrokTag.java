package artizens.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artwork_tag")
public class ArtWrokTag {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artwork_tag_id")
	private Long id;
	
	@Column(name = "artwork_tag_name", length = 45)
	private String name;

	@OneToMany(mappedBy = "artWrokTag", cascade = CascadeType.ALL)
	private List<ArtWorkArtWorkTag> artWorkArtWorkTag;
	
	public ArtWrokTag() {
	}
}
