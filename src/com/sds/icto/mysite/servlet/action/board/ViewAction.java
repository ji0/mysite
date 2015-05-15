package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.dao.GuestBookDAO;
import com.sds.icto.mysite.vo.BoardVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class ViewAction implements Action  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		
		
		
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		String view_cnt = request.getParameter("view_cnt");
		
		Long lNo = Long.parseLong(no);
		Long lView = Long.parseLong(view_cnt);
		lView++;
				
		dao.plus_view_cnt(lNo, lView);
		BoardVO list = dao.fetchDetail(lNo);
	 
		request.setAttribute("list", list);
		
		WebUtil.forward("/views/board/view.jsp", request, response);
	}

}
