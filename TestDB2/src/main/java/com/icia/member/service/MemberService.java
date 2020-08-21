package com.icia.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	private ModelAndView mav;
	
	public ModelAndView insert(MemberDTO member) {
		mav = new ModelAndView();
		int result = dao.insert(member);
		
		if(result>0) {
			mav.setViewName("LoginForm");
		} else {
			mav.setViewName("index");
		}
		
		return mav;
	}

	public ModelAndView mList() {
		mav = new ModelAndView();
		List<MemberDTO>mList = dao.mList();
		
		mav.addObject("mList",mList);
		mav.setViewName("MemberList");
		
		return mav;

	}

}
