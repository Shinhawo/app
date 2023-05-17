package web.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Employee;

@WebServlet(urlPatterns = "/emp/detail") 
public class EmpDetailListServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empId = req.getParameter("eid");
		System.out.println("조회요청한 EMPLOYEE_ID : "+empId);
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee emp = employeeDao.getEmployee(empId);
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8'>");
		out.println("	<title>사원 상세 정보</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>사원 상세 정보</h1>");
		out.println("	<table border='1'>");
		out.println("		<tbody>");
		out.println("			<tr>");
		out.println("				<th>직원아이디</th>");
		out.println("				<td>"+emp.getId()+"</td>");
		out.println("				<th>이름</th>");
		out.println("				<td>"+emp.getFirstName()+" "+emp.getLastName()+"</td>");
		out.println("            </tr>");
		out.println("            <tr>");
		out.println("				<th>이메일</th>");
		out.println("				<td>"+emp.getEmail()+"</td>");
		out.println("				<th>전화번호</th>");
		out.println("				<td>"+emp.getPhoneNumber()+"</td>");
		out.println("            </tr>");
		out.println("            <tr>");
		out.println("				<th>급여</th>");
		out.println("				<td>"+emp.getSalary()+"</td>");
		out.println("				<th>커미션</th>");
		out.println("				<td>"+emp.getCommissionPct()+"</td>");
		out.println("            </tr>");
		out.println("            <tr>");
		out.println("				<th>직종아이디</th>");
		out.println("				<td>"+emp.getJobId()+"</td>");
		out.println("				<th>입사일</th>");
		out.println("				<td>"+emp.getHireDate()+"</td>");
		out.println("            </tr>");
		out.println("            <tr>");
		out.println("				<th>부서아이디</th>");
		out.println("				<td>"+emp.getDeptId()+"</td>");
		out.println("				<th>매니저</th>");
		out.println("				<td>"+emp.getManagerId()+"</td>");
		out.println("			</tr>");
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
