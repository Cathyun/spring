package com.icia.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mbsvc;
	
	private ModelAndView mav;
			
//	첫화면 설정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	//값이 insertDB을 받아와 return을 준다!
	@RequestMapping(value="/insertDB", method = RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute MemberDTO member) {
		mav = new ModelAndView();
		mav = mbsvc.insert(member);
		return mav;
	}
	
    //select	
	@RequestMapping(value="selectDB")
    public ModelAndView mList() {
		mav = new ModelAndView();
		mav = mbsvc.mList();
		return mav;
		
	}
}
