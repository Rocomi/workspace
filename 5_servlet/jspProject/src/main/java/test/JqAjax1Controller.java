package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JqAjax1Controller
 */
@WebServlet("/jqAjax1.do")
public class JqAjax1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjax1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 시 전달된 데이터 추출
		String data = request.getParameter("data");
		
		System.out.println("전달된 데이터 : " + data);
		
		//---------------------------------- 요청에 대한 처리 완료 (가정)
		
		// 응답 데이터
		String result = "전달된 값: " + data + ", 데이터 길이: " + data.length();
		
		// * 응답 데이터 타입, 인코딩 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// * 응답데이터를 전달(돌려주기)
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}