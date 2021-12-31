package artizens.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import artizens.domain.UserProfile;
import artizens.mapper.dto.InsertUserDto;

@Mapper
public interface UserMapper {
	
	@Select("Select * from user_profile where user_profile_id =${userNo}")
	List<UserProfile> getUserByNo(@Param("userNo") Long userNo);
	
	@Select("Select * from user_profile")
	List<UserProfile> getUserAll();
	
	@Insert("Insert into user_profile("
			+ "user_profile_id,"
			+ "user_profile_email,"
			+ "user_profile_name,"
			+ "user_profile_password,"
			+ "user_profile_register_date) values(null, #{email}, #{name}, #{password}, NOW())")
	
	@Options(useGeneratedKeys=true, keyColumn = "user_profile_id", keyProperty="id")
	Long insertUser(InsertUserDto insertUserDto);
//	
//	@Update("update artwork_tag set user_profile_name = #{name}, user_profile_email = #{email} where user_profile_id = ${userNo}")
//	void UpdateUser(String name, String email, Long userNo);
	
//	@Delete("delete from User where user")
	
}
