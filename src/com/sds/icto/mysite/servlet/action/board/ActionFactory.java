package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.web.Action;

public class ActionFactory {

	private static ActionFactory instance;

	static {
		instance = new ActionFactory();

	} // 이거 하면 그냥 맨 처음에 로딩될때부터 만들어짐
		// 만들어져있으니까 리턴만 해주면ㄷ ㅐㅇ

	public Action getAction(String a) {

		Action act = null;
		if ("write".equals(a)) {
			act = new WriteAction();
		} else if ("view".equals(a)) {
			act = new ViewAction();
		} else if ("modify".equals(a)) {
			act = new ModifyAction();
		} else if("list".equals(a)){
			act = new ListAction();
		} else if("board".equals(a)){
			act = new ListAction();
		}else if("delete".equals(a)){
			act = new DeleteAction();
		}else if("modifyform".equals(a)){
			act = new ModifyFormAction();
		}else if("writeform".equals(a)){
			act = new WriteFormAction();
		}else if("search".equals(a)){
			act = new SearchAction();
		}
		
		if (act == null) {
			act = new ListAction();
		}

		return act;

	}



	public static ActionFactory getInstance() {

		if (instance == null) {

			instance = new ActionFactory();
		}
		return instance;	
	}

	private ActionFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
