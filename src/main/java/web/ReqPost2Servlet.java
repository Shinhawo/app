package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reqPost2")
public class ReqPost2Servlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String maker = req.getParameter("maker");
		String price = req.getParameter("price");
		String disPrice = req.getParameter("disPrice");
		String amount = req.getParameter("amount");
		
//      html에서 값이 숫자인 것들의 type을 number가 아닌 text로 작성했을 경우
//      int price = Integer.parseInt(req.getParmeter("price"));
//		int expectedTotalSellPrice = disPrice * amount;
		
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>getParameter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>요청파라미터값 조회</h1>");
		out.println("<p> 상품명 : "+name+"</p>");
		out.println("<p> 제조사 : "+maker+"</p>");
		out.println("<p> 가격 : "+price+"</p>");
		out.println("<p> 할인가격 : "+disPrice+"</p>");
		out.println("<p> 입고수량 : "+amount+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
