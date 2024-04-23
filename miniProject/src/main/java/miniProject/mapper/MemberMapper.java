package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);
	public List<MemberDTO> memberSelectList();
	public MemberDTO memberSelectOne(String memberNumOrId);
	public void memberUpdate(MemberDTO dto);
	public void memberDelete(String memberNum);
}
