package com.sds.icto.mysite.servlet.action.gusestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.action.gusestbook.DeleteAction;
import com.sds.icto.mysite.servlet.action.gusestbook.DeleteFormAction;
import com.sds.icto.mysite.servlet.action.gusestbook.GBIndexAction;
import com.sds.icto.mysite.servlet.action.gusestbook.InsertAction;
import com.sds.icto.web.Action;

public class ActionFactory {

	private static ActionFactory instance;

	static {
		instance = new ActionFactory();

	} // 이거 하면 그냥 맨 처음에 로딩될때부터 만들어짐
		// 만들어져있으니까 리턴만 해주면ㄷ ㅐㅇ

	public Action getAction(String a) {

		Action act = null;
		if ("deleteform".equals(a)) {
			act = new DeleteFormAction();
		} else if ("delete".equals(a)) {
			act = new DeleteAction();
		} else if ("insert".equals(a)) {
			act = new InsertAction();
		} else if("guestbook".equals(a)){
			act = new GBIndexAction();
		}
		
		if (act == null) {
			act = new GBIndexAction();
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
