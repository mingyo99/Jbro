package miniProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberName;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String memberPhone1;
	String memberPhone2;
	String gender;
	String memberEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String height;
	String weight;
	
	MultipartFile profileImg;
}
