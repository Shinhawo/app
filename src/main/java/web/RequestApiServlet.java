package web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/req/api")
public class RequestApiServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//HttpServletRequest 객체의 주요 API
		
		// String getMethod() : HTTP 요청 방식을 반환한다. 
		String method = req.getMethod();
		// sysout은 콘솔창에 찍힘
		System.out.println("요청방식 : " + method);
		
		// String getRequestURL() : 요청 URL을 반환한다.
		String uri = req.getRequestURI();
		System.out.println("요청 URl : " + uri);
		
		// 요청메세지의 헤더정보 조회하기
		String headerValue1 = req.getHeader("accept");
		String headerValue2 = req.getHeader("accept-language");
		String headerValue3 = req.getHeader("accept-encoding");
		String headerValue4 = req.getHeader("user-agent");
		System.out.println("요청헤더정보 : [accept]" + headerValue1);
		System.out.println("요청헤더정보 : [accept-language]" + headerValue2);
		System.out.println("요청헤더정보 : [accept-encoding]" + headerValue3);
		System.out.println("요청헤더정보 : [user-agent]" + headerValue4);
		
	}
}
