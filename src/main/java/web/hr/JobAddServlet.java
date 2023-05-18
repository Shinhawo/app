package web.hr;

import java.io.IOException;

import org.apache.coyote.http11.Http11InputBuffer;

import dao.JobDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Job;

/*
 * 요청 URL - http://localhost/app/job/add
 * 
 * urlpatterns - /job/add
 * 요청 파라미터 - id, title, min, max  <-------폼 입력값이 요청 메세지의 바디부에 담겨서 서버로 전달된다.
 * <form>
 * <input type="text" name="id">
 * <input type="text" name="title">
 * <input type="text" name="min">
 * <input type="text" name="max">
 * </form>
 */

@WebServlet(urlPatterns = "/job/add")
public class JobAddServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 파라미터 조회
		// - Job 객체를 생성해서 요청 파라미터값을 저장한다.
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		int minSalary = Integer.parseInt(req.getParameter("min"));
		int maxSalary = Integer.parseInt(req.getParameter("max"));
		
		//업무로직 수행
		Job job = new Job();
		job.setId(id);
		job.setTitle(title);
		job.setMinSalary(minSalary);
		job.setMaxSalary(maxSalary);
		// - 신규 직종 정보가 저장된 Job 객체를 Service객체 혹은 Dao객체에 전달해서 데이터 베이스에 저장한다.
		JobDao dao = new JobDao();
		dao.insertJob(job);
		
		// 재요청 URL 전송 - 서블릿에서 INSERT, UPDATE, DELETE 작업을 했을 때
		
		// 지금은 그냥 홈이 나오게 할 것.
		// 현재 요청 URL : http://localhost/app/job/dd
		// 재요청할 URL : http://localhost/app/index.html
		// resp.sendRedirect("../index.html")   상대주소 표기법
		// resp.sendRedirect("/app/index.html") 절대주소 표기법
		
		// 직종목록이 나오게 할 것
		// 현재 요청 URL : http://localhost/app/job/dd
		// 재요청할 URL : http://localhost/app/job/list
		// resp.sendRedirect("/app/job/list");
		resp.sendRedirect("list");

	}
}
