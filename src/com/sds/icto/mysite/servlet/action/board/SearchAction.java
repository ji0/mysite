package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.vo.BoardVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class SearchAction implements Action  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		String kwd = request.getParameter("kwd");

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.search(kwd);
	
		request.setAttribute("list", list);
		
		WebUtil.forward("/views/board/list.jsp", request, response);

		
		
	}

}
