package miniProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class EmployeeCommand {
	String empNum;
	@NotEmpty(message = "아이디를 입력하세요")
	String empId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@%&-+~]).{8,12}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상의 암호를 입력하세요")
	String empPw;
	@NotBlank(message = "비밀번호 확인을 입력하세요")
	String empPwCon;
	@NotBlank(message = "이름을 입력하세요")
	String empName;
	@NotBlank(message = "이메일을 입력하세요")
	String empAddr;
	String empAddrDetail;
	String empPost;
	@Size(min = 11 , max = 13)
	@NotBlank(message = "전화번호를 입력하세요")
	String empPhone;
	@Size(min = 13 , max = 13)
	@NotBlank(message = "주민번호를 입력하세요")
	String empJumin;
	@NotBlank(message = "이메일을 입력하세요")
	String empEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empRegiDate;
	
	public boolean isemployeePwEqualsempPwCon() {
		return empPw.equals(empPwCon);
	}

	public boolean isEmpPwEqualsEmpPwCon() {
		// TODO Auto-generated method stub
		return empPw.equals(empPwCon);
	}
}
