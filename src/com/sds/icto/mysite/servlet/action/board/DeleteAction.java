package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ClassNotFoundException, ServletException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");


		String no = request.getParameter("no");
		System.out.println(no);
		
		Long lNo = Long.parseLong(no);

		BoardDAO dao = new BoardDAO();
		dao.delete(lNo);

		response.sendRedirect("/mysite/board");
		
		
		
		
	}

}
