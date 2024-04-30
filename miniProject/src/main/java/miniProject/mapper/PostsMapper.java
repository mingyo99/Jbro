package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.CategoryDTO;
import miniProject.domain.PostsDTO;

@Mapper
public interface PostsMapper {
	public void postsInsert(PostsDTO dto);
	public List<PostsDTO> postsSelectList(String memberNum);
	public PostsDTO postsSelectOne(String postsNum);
	public void postsUpdate(PostsDTO dto);
	public int postsDelete(String postsNum);
	public List<PostsDTO> postsAllSelectList(CategoryDTO dto);
	public void likeAdd(String purchaseNum);
	public void likeDel(String purchaseNum);
	public void postsGoodsInsert(@Param("postsNum") String postsNum, @Param("goodsNum") String goodsNum);
	public List<PostsDTO> postsGoodsSelect(String postsNum);
}
