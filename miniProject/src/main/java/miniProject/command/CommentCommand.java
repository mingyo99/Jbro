package miniProject.command;

import java.util.Date;

import lombok.Data;
@Data
public class CommentCommand {
	String CommentsContent;
	String postsNum;
	String memberNum;
	Date commentsDate;
	String commentsNum;
	String memberId;
}
