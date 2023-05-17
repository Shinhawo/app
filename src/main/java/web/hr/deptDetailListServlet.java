package web.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.DepartmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Department;
import vo.Employee;

@WebServlet(urlPatterns = "/dept/detail")
public class deptDetailListServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String deptId = req.getParameter("did");
		System.out.println("조회 요청한 department_id : "+ deptId);
		
		DepartmentDao departmentDao = new DepartmentDao();
		List<Employee> empList = departmentDao.getDepartmentEmp(deptId);
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8'>");
		out.println("	<title>부서 상세 정보</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>부서 상세 정보</h1>");
		out.println("	<table border='1'>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>사원아이디</th>");
		out.println("				<th>사원이름</th>");
		out.println("				<th>직종아이디</th>");
		out.println("				<th>전화번호</th>");
		out.println("				<th>이메일</th>");
		out.println("				<th>급여</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		if(empList.isEmpty()) {
			out.println("<tr>");
			out.println("<td colspan = 6>이 부서에는 직원이 존재하지 않습니다.</td>");
			out.println("</tr>");
		} else {
			for(Employee employee : empList) {
				out.println("			<tr>");
				out.println("				<td>"+employee.getId()+"</td>");
				out.println("				<td>"+employee.getFirstName()+" "+employee.getLastName()+"</td>");
				out.println("				<td>"+employee.getJobId()+"</td>");
				out.println("				<td>"+employee.getPhoneNumber()+"</td>");
				out.println("				<td>"+employee.getEmail()+"</td>");
				out.println("				<td>"+employee.getSalary()+"</td>");
				out.println("			</tr>");
			}
		}	
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
