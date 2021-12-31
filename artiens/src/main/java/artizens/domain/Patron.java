package artizens.domain;

import java.util.ArrayList;
import java.util.Iterator;
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
@Table(name = "patron")
public class Patron extends BaseTimeEntity{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patron_id")
	private Long id;
	
	@Column(name = "patron_title", length = 45)
	private String title;
	
	@Column(name= "patron_content", length = 100000)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private Creator creator;
	
	@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
	private List<PatronImages> patronImages;
	
	public Patron() {
	}
	
	public static Patron createPatron(String title, String content, Creator creator, List<UploadFile> patronImages) {
		Patron patron = new Patron();
		patron.title = title;
		patron.content = content;
		patron.creator = creator;
		patron.patronImages = patron.addPatronInPatronImages(patronImages);
		return patron;
	}
	
	public List<PatronImages> addPatronInPatronImages(List<UploadFile> patronImages) {
		List<PatronImages> patronImagesList = new ArrayList<PatronImages>();
		if (patronImages.size() > 0) {
			for (UploadFile images : patronImages) {
				patronImagesList.add(PatronImages.addImages(images, this));
			}
		}
		return patronImagesList;
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

	public Creator getCreator() {
		return creator;
	}

	public List<PatronImages> getPatronImages() {
		return patronImages;
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", title=" + title + ", content=" + content + ", creator=" + creator
				+ ", patronImages=" + patronImages + "]";
	}
	
}
