package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.member.service.MemberServiceImpl;

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
		request.setCharacterEncoding("UTF-8");
		

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberServiceImpl().deleteMember(userId, userPwd);
		
		HttpSession session = request.getSession();
		if (result > 0 ) {
			
			session.removeAttribute("loginUser");

			session.setAttribute("alertMsg", "회원 탈퇴처리가 완료되었습니다. 그동안 이용해주셔서 감사합니다.");
			
			
		} else {
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
