package artizens.repository.querydsl.collaboration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CollaborationArtWorkDto {
	private Long colArtWorkId;
	private String colArtWorkTitle;
	private String colArtWorkImage;
	
	private Long colArtWorkCreatorId;
	private String colArtWorkCreatorImage;
	private String colArtWorkCreatorName;
	
	private LocalDateTime colArtWorkregiseDateTime;

	public CollaborationArtWorkDto(
			Long colArtWorkId, 
			String colArtWorkTitle, 
			String colArtWorkImage,
			Long colArtWorkCreatorId, 
			String colArtWorkCreatorImage, 
			LocalDateTime colArtWorkregiseDateTime,
			String colArtWorkCreatorName) {
		this.colArtWorkId = colArtWorkId;
		this.colArtWorkTitle = colArtWorkTitle;
		this.colArtWorkImage = colArtWorkImage;
		this.colArtWorkCreatorId = colArtWorkCreatorId;
		this.colArtWorkCreatorImage = colArtWorkCreatorImage;
		this.colArtWorkregiseDateTime = colArtWorkregiseDateTime;
		this.colArtWorkCreatorName = colArtWorkCreatorName;
	}

	public Long getColArtWorkId() {
		return colArtWorkId;
	}

	public String getColArtWorkTitle() {
		return colArtWorkTitle;
	}

	public String getColArtWorkImage() {
		return colArtWorkImage;
	}

	public Long getColArtWorkCreatorId() {
		return colArtWorkCreatorId;
	}

	public String getColArtWorkCreatorImage() {
		return colArtWorkCreatorImage;
	}

	public String getColArtWorkregiseDateTime() {
		return colArtWorkregiseDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public String getColArtWorkCreatorName() {
		return colArtWorkCreatorName;
	}
	
}
