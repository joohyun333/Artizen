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
@Table(name = "patron_images")
public class PatronImages {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patron_images_id")
	private Long id;
	
	@AttributeOverrides({
		@AttributeOverride(name = "uploadFileName", column = @Column(name = "patron_images_uploadfilename")),
		@AttributeOverride(name = "storeFileName", column = @Column(name = "patron_images_storefilename"))
	})
	@Embedded
	private UploadFile uploadFile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patron_id")
	private Patron patron;

	public PatronImages() {
	}
	
	public static PatronImages addImages(UploadFile uploadFile, Patron patron) {
		PatronImages patronImages = new PatronImages();
		patronImages.uploadFile = uploadFile;
		patronImages.patron = patron;
		return patronImages;
	}

	public Long getId() {
		return id;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public Patron getPatron() {
		return patron;
	}	
	
}
