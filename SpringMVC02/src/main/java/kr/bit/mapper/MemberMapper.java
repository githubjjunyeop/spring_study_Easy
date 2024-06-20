package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.bit.model.MemberVO;

//@Mapper //MyBatis(SqlSessionFactory + SqlSession)
public interface MemberMapper {
	
	@Select("select * from member1")
	public List<MemberVO> memberList(); // --SQL id ="memberList";

	@Insert("INSERT INTO member1 (id, pass, name, age, email, phone) \r\n"
			+ "	VALUES(\r\n"
			+ "	#{id}, \r\n"
			+ "	#{pass}, \r\n"
			+ "	#{name}, \r\n"
			+ "	#{age}, \r\n"
			+ "	#{email}, \r\n"
			+ "	#{phone} \r\n"
			+ "	)")
	public int memberInsert(MemberVO vo);

	@Delete("DELETE FROM member1 WHERE num=#{num}")
	public int memberDelete(int num);
	
	@Select("SELECT * FROM member1 WHERE num=#{num}")
	public MemberVO memberContent(int num);
	
	@Update("UPDATE member1 set age=#{age}, email=#{email}, phone=#{phone} WHERE num=#{num}")
	public int memberUpdate(MemberVO vo);

	
}
