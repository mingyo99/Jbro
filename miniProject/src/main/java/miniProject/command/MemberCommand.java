package miniProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class MemberCommand {
	String memberNum;
	@NotBlank(message = "")
	String memberId;
	@NotBlank(message = "")
	String memberPw;
	String memberPwCon;
	@NotBlank(message = "")
	String memberName;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	@NotBlank(message = "")
	String memberPhone1;
	String memberPhone2;
	String gender;
	String memberEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String height;
	String weight;
	
	MultipartFile profileImg;
	
	public boolean isMemberPwEqualsMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
