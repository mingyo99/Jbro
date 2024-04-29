package miniProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class MemberCommand {
	String memberNum;
	@NotBlank(message = "")
	String memberId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@%&-+~]).{8,12}$", message = "영어 대소문자 , 숫자, 특수문자가 포함된 8글자 이상")
	String memberPw;
	String memberPwCon;
	@NotEmpty(message = "이름을 입력해주세요")
	String memberName;
	@NotBlank(message = "주소를 입력해주세요")
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	@NotEmpty(message = "전화번호를 입력해주세요")
	String memberPhone1;
	String memberPhone2;
	String gender;
	String memberEmail;
	@NotNull(message = "생년월일을 선택해 주세요")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String height;
	String weight;
	
	MultipartFile profileImg;
	
	public boolean isMemberPwEqualsMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
