package artizens.domain;

import java.time.LocalDateTime;
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
@Table(name = "collaboration_artwork")
public class CollaborationArtWork {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collaboration_artwork_id")
	private Long id;
	
	@Column(name = "collaboration_artwork_title")
	private String title;
	
	@Column(name = "collaboration_artwork_content")
	private String content;
	
	@Column(name = "collaboration_artwork_register_date")
	private LocalDateTime registerDate;
	
	@Column(name = "collaboration_artwork_winner")
	private boolean winner; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collaboration_id")
	private Collaboration collaboration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private Creator creator;
	
	/**
     * 서버에 저장하는 파일명
     * 업로드 된 파일명으로 서버에 저장 시 이름이 중복될 수 있음. 랜덤값으로 만드는 파일 이름
     */
	@Column(name = "collaboration_artwork_storefilename", length = 100)
    private String storeFileName;
	
	@OneToMany(mappedBy = "collaborationArtWork", cascade = CascadeType.ALL)
	private List<CollaborationArtWorkComment> collaborationArtWorkComments;
	
	public CollaborationArtWork() {
	}
	
	public static CollaborationArtWork createCollaborationArtWork(
			String title, 
			String content, 
			Creator creator,
			String collaboArtWorkImage,
			Collaboration collaboration) {
		CollaborationArtWork collaborationArtWork = new CollaborationArtWork();
		collaborationArtWork.title = title;
		collaborationArtWork.registerDate = LocalDateTime.now();
		collaborationArtWork.content = content;
		collaborationArtWork.creator = creator;
		collaborationArtWork.storeFileName = collaboArtWorkImage;
		collaborationArtWork.winner = false;
		collaborationArtWork.collaboration = collaboration;
		return collaborationArtWork;
	}
	
	/**
	 * 당선작 수상시 true
	 * 아닐시 false
	 * @param winner
	 */
	public void setCollaborationArtWorkWinner(Boolean winner) {
		this.winner = winner;
	}
	
	
	
}
