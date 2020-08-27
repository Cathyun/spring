package com.hyun.member.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hyun.member.dto.boardDTO;
import com.hyun.member.dto.memberDTO;
import com.hyun.member.service.MemBoService;

@Controller
public class memberController {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	MemBoService mbsvc;

	@Autowired
	HttpSession session;

	// 처음화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}

	// 처음화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index2(Locale locale, Model model) {
		return "index";
	}

	// 회원가입폼
	@RequestMapping(value = "joinForm")
	public String joinForm() {
		return "joinForm";
	}

	// 회원가입
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute memberDTO member) {
		mav = mbsvc.join(member);
		return mav;
	}

	// 로그인폼
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}

	// 로그인하기
	@RequestMapping(value = "login")
	public ModelAndView login(@ModelAttribute memberDTO member) {
		mav = mbsvc.login(member);
		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "logOut")
	public String logout() {
		session.invalidate();
		return "index";
	}

	// 회원목록조회
	@RequestMapping(value = "memberList")
	public ModelAndView memberList() {
		mav = mbsvc.mbList();
		return mav;
	}

	// 회원목록(상세조회)
	@RequestMapping(value = "memberView")
	public ModelAndView memberView(@RequestParam("mbid") String mbid) {
		mav = mbsvc.memberView(mbid);
		return mav;
	}

	// 로그인시 ->내정보
	@RequestMapping(value = "myInfo")
	public ModelAndView myInfo(@RequestParam("loginID") String loginID) {
		System.out.println(loginID);
		mav = mbsvc.myInfo(loginID);
		return mav;
	}

	// 회원목록-> 수정 페이지이동
	@RequestMapping(value = "memberModi")
	public ModelAndView memberModi(@RequestParam("mbid") String mbid) {
		mav = mbsvc.memberModi(mbid);
		return mav;
	}

	// 회원삭제
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(@RequestParam("mbid") String mbid) {
		mav = mbsvc.memberDelete(mbid);
		return mav;
	}
	
	// 회원수정
	@RequestMapping(value = "memberProcess")
	public ModelAndView memberProcess(@ModelAttribute memberDTO member) {
		mav = mbsvc.memberProcess(member);
		return mav;
	}

	//아이디중복
	@RequestMapping(value="idoverlap")
	public @ResponseBody String idOverlap(@RequestParam("mbid") String mbid) {
		String resultMsg=mbsvc.idOverlap(mbid);
		System.out.println("resultMsg"+resultMsg);
		return resultMsg;
		
	}
	
	
}
