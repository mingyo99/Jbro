package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.PostsDTO;

@Mapper
public interface PostsMapper {
	public void postsInsert(PostsDTO dto);
	public List<PostsDTO> postsSelectList(String memberNum);
	public PostsDTO postsSelectOne(String postsNum);
	public void postsUpdate(PostsDTO dto);
	public int postsDelete(String postsNum);
}
