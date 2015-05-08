package com.sds.icto.mysite.servlet.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.MemberDAO;
import com.sds.icto.mysite.vo.MemberVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException{
		// TODO Auto-generated method stub
		
		
		WebUtil.forward("/views/main/index.jsp", request, response);
		
	}

	
}
