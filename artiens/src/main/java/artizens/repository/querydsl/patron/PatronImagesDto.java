package artizens.repository.querydsl.patron;

public class PatronImagesDto {
	private Long patronId;
	private String patronUploadFileName;
	
	public PatronImagesDto(Long patronId, String patronUploadFileName) {
		this.patronId = patronId;
		this.patronUploadFileName = patronUploadFileName;
	}

	public Long getPatronId() {
		return patronId;
	}

	String getPatronUploadFileName() {
		return patronUploadFileName;
	}
}
