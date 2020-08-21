package com.js.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.js.member.dto.MemberDTO;
import com.js.member.service.MemberService;

@Controller
public class MemberController {
  
	ModelAndView mav = new ModelAndView();
	
//	MemberService를 인포트 하기 위하여 @Autowired해주어야 한다.
	@Autowired 
	MemberService mbsvc;
	
	@Autowired
	HttpSession session;
	
	
    //index
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public String index() {
		return "index";
	}
	
    //로그인
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	 public String loginForm() {
		return "loginForm";
	}
	
	//회원가입
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		/*
		 * MemberDTO member = new MembeDTO();
		 * membe.setJsid(request.getParameter("jsid"));
		 * --> 이것들을  @ModelAttribute MemberDTO member를 사용하여 간단하게 만들 수 있다!
		 */
		mav = mbsvc.memberJoin(member);
		//mbsvc.memberJoin(member)
		//service에서 정보를 mav에 담아서 돌아온다.
		
		return mav;
	}
			
    //회원가입
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	 public String joinForm() {
		return "joinForm";
	}
	
	
    //회원목록조회
	//method안쓰면 GET,POST 모두 받음!
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	 public ModelAndView memberList() {
      	mav = mbsvc.mList();
		return mav;
	}
	//회원로그인
	@RequestMapping(value="memberLogin",method=RequestMethod.POST)
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		mav = mbsvc.memberLogin(member);
		return mav;
	}
	//회원정보 상세보기
	@RequestMapping(value="memberView", method = RequestMethod.GET)
	public ModelAndView memberView(@RequestParam("jsid") String id) {
		mav = mbsvc.memberView(id);
		return mav;
	}
	
	//회원삭제하기
	@RequestMapping(value = "memberDelete", method = RequestMethod.GET)
	public ModelAndView memberDelete(@RequestParam("jsid") String id) {
		mav=mbsvc.memberDelete(id);
		return mav;
	}
	
	//회원수정페이지
	@RequestMapping(value = "memberModify", method = RequestMethod.GET)
	public ModelAndView memberModify(@RequestParam("jsid") String id) {
		mav = mbsvc.memberModify(id);
		return mav;
	}
	
	//회원수정하기
	@RequestMapping(value = "modifyProcess", method = RequestMethod.POST)
	public ModelAndView modifyProcess(@ModelAttribute MemberDTO member) {
	 	mav = mbsvc.modifyProcess(member);
		return mav;
	}
	
	//로그아웃
	@RequestMapping(value = "logout")
	public String logout() {
        session.invalidate();
		return "index";
	}
	
	
}





