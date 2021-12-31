package artizens.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "collaboration")
public class Collaboration {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collaboration_id")
	private Long id;
	
	@Column(name = "collaboration_title", length = 45)
	private String title; 
	
	@Column(name = "collaboration_register_date")
	private LocalDateTime registerDate;
	
	@Column(name = "collaboration_deadline_date")
	private LocalDateTime deadlineDate;
	
	/**
     * 서버에 저장하는 파일명
     * 업로드 된 파일명으로 서버에 저장 시 이름이 중복될 수 있음. 랜덤값으로 만드는 파일 이름
     */
	@Column(name = "collaboration_storefilename", length = 100)
    private String storeFileName;
	
	@Column(name = "collaboration_content", length = 1000000)
	private String content;
	
	@Column(name = "collaboration_evaluate", length = 5)
	private Boolean evaluate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private Creator creator;

	@OneToMany(mappedBy = "collaboration", cascade = CascadeType.ALL)
	private List<CollaborationComment> collaborationComment;
	
	public Collaboration() {
	}
	
	public static Collaboration createCollaboration(
			String title, 
			LocalDateTime deadLineDate, 
			String content, 
			Creator creator,
			String storeFileName) {
		Collaboration collaboration = new Collaboration();
		collaboration.title = title;
		collaboration.registerDate = LocalDateTime.now();
		collaboration.deadlineDate = deadLineDate;
		collaboration.content = content;
		collaboration.creator = creator;
		collaboration.storeFileName = storeFileName;
		collaboration.evaluate = false;
		return collaboration;
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public LocalDateTime getDeadlineDate() {
		return deadlineDate;
	}
	public String getContent() {
		return content;
	}
	public Creator getCreator() {
		return creator;
	}
	
	public String getStoreFileName() {
		return storeFileName;
	}

	public List<CollaborationComment> getCollaborationComment() {
		return collaborationComment;
	}

	@Override
	public String toString() {
		return "Collaboration [id=" + id + ", title=" + title + ", registerDate=" + registerDate + ", deadlineDate="
				+ deadlineDate + ", storeFileName=" + storeFileName + ", content=" + content + ", creator=" + creator
				+ ", collaborationComment=" + collaborationComment + "]";
	}
}
