package com.js.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.js.member.dao.MemberDAO;
import com.js.member.dto.MemberDTO;

@Service
public class MemberService {
 
	@Autowired
	MemberDAO dao;
	
	@Autowired
	HttpSession session;
	
	ModelAndView mav = new ModelAndView();
	
	//회원가입
	public ModelAndView memberJoin(MemberDTO member) {
		int result = dao.memberJoin(member);
		//dao.memberJoin(member)성공하면 1, 실패하면 0값을 반환
		System.out.println(result);
		if(result>0) {
			mav.setViewName("loginForm");
		}else {
			mav.setViewName("index");
		}
		System.out.println(mav);
		return mav;
	}
	
	//회원목록
	public ModelAndView mList() {
		List<MemberDTO>mList = dao.mList();
		//ModelAndView
		//Model : Object
		//View : 이동할jsp주소
		
		//servlet 사용시
		//setAttribute
		mav.addObject("mList",mList);
		
		//disparcher
		mav.setViewName("memberList");
		
		//현재 mav에는 이동할 jsp주소 memberList와
		//List<MemberDTO>를 담고 있다
		
		System.out.println("mav 확인");
		System.out.println(mav);
		
		//service에서는 이동할 주소를 선언만 해주소
		//실제로 jsp로 이동하는 것은controller에서 한다.
		return mav;
		
	}

	//회원로그인
	public ModelAndView memberLogin(MemberDTO member) {
		String loginID = dao.memberLogin(member);
		System.out.println("dao에서 리턴된 값: " + loginID);
		if(loginID!=null) {
			//loginID를 session을 씌우겠다는 작업!
			session.setAttribute("loginID",loginID);
			mav.setViewName("index");
		}else {
			mav.setViewName("loginForm");
		}
		return mav;
	}
    //회원상세보기
	public ModelAndView memberView(String id) {
		MemberDTO mList = dao.memberView(id);
		
		if(mList != null) {
		  mav.addObject("mList",mList);
		  mav.setViewName("memberView");
		}else {
			mav.setViewName("memberList");
		}
	
		return mav;
		
	}
    //회원삭제
	public ModelAndView memberDelete(String id) {
		int result = dao.memberDelete(id);
		if(result>0) {
			//redirect:/memberList을 사용하지 않으면 jsp로  이동한다.
			//그러므로 redirect:/memberList를 사용해서 
			//controller에 있는 /memberList로 이동하여
			//memberList.jsp로 가게 되어진다.
			
			mav.setViewName("redirect:/memberList");
		}else {
			mav.setViewName("index");
		}
		return mav;
	}
	
	//회원수정페이지
	public ModelAndView memberModify(String id) {
		MemberDTO mbModify = dao.memberView(id);
		mav.addObject("mbModify", mbModify);
		mav.setViewName("memberModify");
		return mav;
	}

	//회원수정하기
	public ModelAndView modifyProcess(MemberDTO member) {
		int result = dao.modifyProcess(member);
		if(result>0) {
			mav.setViewName("redirect:/memberList");
		}else {
			mav.setViewName("index");
		}
		return mav;
	}

	
	
	

}
