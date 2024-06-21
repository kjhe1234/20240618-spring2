package com.kjhe1234.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kjhe1234.jdbc.dao.MemberDao;

public class MjoinCommand {

		public int execute(Model model) {
			
			Map<String, Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			
			String mid =request.getParameter("mid");
			String mpw =request.getParameter("mpw");
			String mname =request.getParameter("mname");
			String memail =request.getParameter("memail");
			
			MemberDao memberDao = new MemberDao();
			int success = memberDao.joinMember(mid, mpw, mname, memail);
			//success 값이 1이면 sql문 실행 성공 아니면 실패			
			
			return success;
			
		}
	
}
