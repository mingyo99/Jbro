package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
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
	
	
}
