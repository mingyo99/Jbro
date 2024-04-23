package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.EmployeeDTO;
import miniProject.domain.StartEndPageDTO;
	
@Mapper
public interface EmployeeMapper {
	public String autoNum();
	public Integer employeeInsert(EmployeeDTO dto);
	public List<EmployeeDTO> employeeAllSelect(StartEndPageDTO sepDTO);
	public int employeeCount(String searchWord);
	public Integer employeesDelete( @Param("employeesNum") String empsDel[]);
	public EmployeeDTO employeeOneSelect(String empNumId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer employeeDelete(String empNum);
	public String getEmpNum(String empId);
	public void employeePwUpdate(@Param("userPw") String userPw,@Param("userId") String userId);
}