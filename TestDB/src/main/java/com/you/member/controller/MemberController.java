package com.you.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.you.member.dto.MemberDTO;
import com.you.member.service.MemberService;

@Controller
public class MemberController {
   
	@Autowired //@Autowired아래 문장만 사용한다!
	private MemberService mbsvc;
	
	private ModelAndView mav;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	@RequestMapping(value ="/insertDB")
	public ModelAndView insert(@ModelAttribute MemberDTO member){ 
		mav = new ModelAndView();
		mav = mbsvc.insert(member);
		return mav;
		
		
    		
		
	    
 }
}
	
	
	
	
	
	
	
	
	
	
	