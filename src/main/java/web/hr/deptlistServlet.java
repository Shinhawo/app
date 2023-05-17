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

@WebServlet(urlPatterns = "/dept/list")
public class deptlistServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> deptList = departmentDao.getDepartmentInfo();
		

		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8'>");
		out.println("	<title>전체 부서목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>전체 부서목록</h1>");
		out.println("	<table border='1'>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>부서아이디</th>");
		out.println("				<th>부서이름</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		
	
		for (Department department : deptList) {
			out.println("		<tr>");
			out.println("			<td><a href='detail?did="+department.getId()+"'>"+department.getId()+"</a></td>");
			out.println("			<td>"+department.getName()+"</td>");
			out.println("		</tr>");
		}
	
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
