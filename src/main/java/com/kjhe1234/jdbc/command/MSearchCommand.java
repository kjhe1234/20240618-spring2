package com.kjhe1234.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kjhe1234.jdbc.dao.MemberDao;
import com.kjhe1234.jdbc.dto.MemberDto;

public class MSearchCommand implements MCommand {

	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mid = request.getParameter("mid");		
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = memberDao.searchMember(mid);
		if(memberDto != null) {
			model.addAttribute("memberDto", memberDto);
		} else {
			model.addAttribute("error", "회원정보가 없는 아이디 입니다. 다시 확인해주세여");
		}
		
		return 0;
	}

}
