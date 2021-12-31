package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import artizens.domain.ArtWork;
import artizens.domain.ArtWorkImages;

@Mapper
public interface ArtWorkImagesMapper {
	
	@Select("select * from artwork_images")
	List<ArtWorkImages> artWorkAll();
	
	@Insert("Insert into artwork_images(artwork_images_storefilename, artwork_images_uploadfilename, art_work_id) values(#{storefilename}, #{uploadfilename}, ${artworkid})")
	void insertArtWork(String storefilename, String uploadfilename, Long artworkid);
	
}
