package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.CommentDTO;

@Mapper
public interface CommentMapper {
	public void commentInsert(CommentDTO dto);
	public List<CommentDTO> commentSelect(String postsNum);
}
