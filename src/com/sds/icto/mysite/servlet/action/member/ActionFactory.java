package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.action.IndexAction;
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
		if ("joinform".equals(a)) {
			act = new JoinFormAction();
		}else if("join".equals(a)){
			act = new JoinAction();
		}else if("joinsuccess".equals(a)){
			act = new JoinSuccessAction();			
		}else if("loginform".equals(a)){
			act = new LoginFormAction();
		}else if("login".equals(a)){
			act = new LoginAction();
		}else if("logout".equals(a)){
			act = new LogoutAction();
		}else if("uinfo".equals(a)){
			act = new UInfoAction();
		}
		
		
		
		if (act == null) {
			act = new IndexAction();
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
