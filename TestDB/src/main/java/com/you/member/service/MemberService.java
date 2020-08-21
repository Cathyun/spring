package com.you.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.you.member.dao.MemberDAO;
import com.you.member.dto.MemberDTO;
@Service

public class MemberService {

	@Autowired
	private MemberDAO dao;
	private ModelAndView mav;
	
	public ModelAndView insert(MemberDTO member) {
		mav = new ModelAndView();
		int result = dao.insert(member);
	
		if(result>0) {
//			mav에 담아서 controller로 이동하고 정보를 담아서 LoginForm으로 이동한다. 
			mav.setViewName("LoginForm");
		}else {
			mav.setViewName("index");
		}
		
//		ModelAndView으로 데이터타입을 받았기 때문에 return을 앞에서 선언해준 mav로 받는다!
		return mav;
	}
   
}
