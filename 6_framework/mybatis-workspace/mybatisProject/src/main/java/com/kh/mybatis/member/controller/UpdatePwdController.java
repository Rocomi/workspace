package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

/**
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
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
		String newPassword = request.getParameter("newPassword");
		
		HttpSession session = request.getSession();
		
		Member updateMem = new MemberServiceImpl().updatePassword(userId, userPwd, newPassword);
		
		if (updateMem == null) {
			request.setAttribute("errorMsg", "비밀번호 변경에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		} else {
			session.setAttribute("alertMsg", "비밀번호 변경에 성공했습니다.");
			session.setAttribute("loginUser", updateMem);
		}

		response.sendRedirect(request.getContextPath() + "/myPage.me");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
