package dao;

import java.util.List;

import util.DaoHelper;
import vo.Employee;

public class EmployeeDao {

	public List<Employee> getEmployeesByJobId(String jobId){
		
		return DaoHelper.selectList("empDao.getEmployeesByJobId", rs -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setHireDate(rs.getDate("hire_date"));
		
			return emp;
		}, jobId);
	}

	public List<Employee> getAllEmployees(){
		
		return DaoHelper.selectList("empDao.getAllEmployees", rs -> {
			
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			
			return emp;
		});
	}
	
	public Employee getEmployee(String Id) {
		
		return DaoHelper.selectOne("empDao.getEmployee", rs -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setEmail(rs.getString("email"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setSalary(rs.getInt("salary"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDeptId(rs.getInt("department_id"));
			
			
			return emp;
		},  Id);
	}
	

}
