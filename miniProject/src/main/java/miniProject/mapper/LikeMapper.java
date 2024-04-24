package miniProject.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {
	public void likeAddDel(@Param("postsNum") String postsNum, @Param("memberNum") String memberNum);
	public int likeCountSelectOne(Map<String, String> map);
	public Integer likeCountSelectAll(String postsNum);
}
