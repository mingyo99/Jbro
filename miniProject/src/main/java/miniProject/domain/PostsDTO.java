package miniProject.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Alias("posts")
public class PostsDTO {
	String postsNum;
	String memberNum;
	String postsImg;
	String postsImgImg;
	String postsContent;
	Date postsdate;
	String postsStyle;
	
	String memberId;
	List<String> goodsNums;
	String goodsNum;
	String goodsName;
	String goodsMainStore;
	
}
