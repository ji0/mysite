package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("authMember");
		session.invalidate();
		
		WebUtil.forward("/views/member/loginform.jsp", request, response);

		
		
	}

}
