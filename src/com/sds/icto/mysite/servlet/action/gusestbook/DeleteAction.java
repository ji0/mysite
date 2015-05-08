package com.sds.icto.mysite.servlet.action.gusestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDAO;
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
		String password = request.getParameter("password");

		System.out.println(no + ", " + password);

		GuestBookDAO dao = new GuestBookDAO();
		dao.delete(lNo, password);

		response.sendRedirect("/mysite/guestbook");
		
		
		
		
	}

}
