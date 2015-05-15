package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.dao.GuestBookDAO;

import com.sds.icto.mysite.vo.BoardVO;
import com.sds.icto.mysite.vo.GuestBookVO;
import com.sds.icto.mysite.vo.MemberVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
			
		request.setCharacterEncoding("utf-8");

		
		// 이메일을 등록합니다.
		// 인서트 끝났는데 결과 쟤한테 알아왕

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		List<GuestBookVO> list = (List<GuestBookVO>) request
				.getAttribute("list");
		
		MemberVO mem = (MemberVO) session.getAttribute("authMember");
		
		
		String member_name = mem.getName();
		Long member_no = mem.getNo();

		System.out.println("액션 " + member_no);
		System.out.println("액션" + member_name);
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMember_name(member_name);
		vo.setMember_no(member_no);
		
		
		 
		
		
		BoardDAO dao = new BoardDAO();
		dao.insert(vo, member_no, member_name);
		
		response.sendRedirect("/mysite/board");
		

	}

}
