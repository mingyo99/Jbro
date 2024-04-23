package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("employee")
@Data
public class EmployeeDTO {
	String empNum;
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empAddrDetail;
	String empPost;
	String empPhone;
	String empJumin;
	String empEmail;
	Date empRegiDate;

}
