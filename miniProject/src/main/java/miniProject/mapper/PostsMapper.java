package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.PostsDTO;

@Mapper
public interface PostsMapper {
	public void postsInsert(PostsDTO dto);
}
