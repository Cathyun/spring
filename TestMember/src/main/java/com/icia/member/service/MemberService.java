package com.icia.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;
import com.icia.member.dto.joinDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	private ModelAndView mav;

	public ModelAndView insert(joinDTO member) {
		mav  = new ModelAndView();
		int result = dao.insert(member);
		if(result>0) {
			mav.setViewName("joinsuccess");
		}else {
			mav.setViewName("joinFail");
		}
		
		return mav;
	}

}
