package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// java는 웹 어플리케이션이므로 경로를 갖고있지 않다.(html과는 다름) 
// 어떤 url을 요청해왔을 때 이 어플리케이션을 실행할지 지정해야함 -> url패턴
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// () 비어있는 것
		System.out.println("init() 실행됨...");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 실행됨...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 노란색 단추. java application의 main 역할을 한다.
		System.out.println("service(request, response) 실행됨...");
		
		// 응답 컨텐츠 제공하기
		// printwriter = 텍스트 출력 전용 스트림
		PrintWriter out = resp.getWriter(); 
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
}
