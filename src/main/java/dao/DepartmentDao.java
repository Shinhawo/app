package dao;

import java.util.List;

import util.DaoHelper;
import vo.Department;
import vo.Employee;

public class DepartmentDao {
	
	public List<Department> getDepartmentInfo() {
		
		return DaoHelper.selectList("deotDao.getAllDept", rs -> {
			
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			
			return department;
		});	
	}
	
	public List<Employee> getDepartmentEmp(String deptId) {
		
		return DaoHelper.selectList("deptDao.getDept", rs -> {
			
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
		}, deptId);
	}
	
}
