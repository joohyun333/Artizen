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
@Table(name = "collaboration_images")
public class CollaborationImages {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collaboration_images_id")
	private Long id;
	
	@AttributeOverrides({
		@AttributeOverride(name = "uploadFileName", column = @Column(name = "collaboration_images_uploadfilename")),
		@AttributeOverride(name = "storeFileName", column = @Column(name = "collaboration_images_storefilename"))
	})
	@Embedded
	private UploadFile uploadFile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collaboration_id")
	private Collaboration collaboration;

	public CollaborationImages() {
	}
	
	public static CollaborationImages addImages(UploadFile uploadFile, Collaboration collaboration) {
		CollaborationImages collaborationImages = new CollaborationImages();
		collaborationImages.uploadFile = uploadFile;
		collaborationImages.collaboration = collaboration;
		return collaborationImages;
	}
	
}
