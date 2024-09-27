package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteMemberController
 */
@WebServlet("/delete.me")
public class DeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
		
		// 전달된 데이터 추출 (아이디, 비밀번호 )
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 서비스객체에게 데이터를 전달하면서 탈퇴 요청(사용자 삭제 -> update 탈퇴컬럼(status))
		int result = new MemberService().deleteMember(userId, userPwd);
		
		HttpSession session = request.getSession();
		// 탈퇴 성공했을 경우 -> 탈퇴 성공했다는 메시지 출력, 로그아웃 처리
		if (result > 0 ) {
			
			session.removeAttribute("loginUser");

			session.setAttribute("alertMsg", "회원 탈퇴처리가 완료되었습니다. 그동안 이용해주셔서 감사합니다.");
			
			
		} else {
			// 탈퇴 실패했을 경우 -> 에러페이지 응답. 탈퇴 실패 메시지 담아서
			request.setAttribute("errorMsg", "회원 탈퇴에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		response.sendRedirect(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
