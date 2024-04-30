package miniProject.command;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostsCommand {
	String postsNum;
	String memberNum;
	MultipartFile postsImg[];
	String postsContent;
	Date postsdate;
	String postsStyle;
	List<String> goodsNums;
}
