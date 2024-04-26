package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("comment")
public class CommentDTO {
	String CommentsContent;
	String postsNum;
	String memberNum;
	Date commentsDate;
	String commentsNum;
	String memberId;
}
