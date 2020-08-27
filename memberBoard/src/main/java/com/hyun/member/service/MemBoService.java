package com.hyun.member.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hyun.member.dao.memberDAO;
import com.hyun.member.dto.boardDTO;
import com.hyun.member.dto.memberDTO;

@Service
public class MemBoService {
	
	@Autowired
	memberDAO dao;

	@Autowired
	HttpSession session;
	
	ModelAndView mav = new ModelAndView();
	
	//회원가입
	public ModelAndView join(memberDTO member) {
		int result = dao.join(member);
		if(result>0) {
			mav.setViewName("loginForm");
		}else {
			mav.setViewName("index");
		}
		return mav;
	}
	
	//로그인
	public ModelAndView login(memberDTO member) { 
		String memberID =  dao.login(member);
		
		if(memberID != null) { 
			session.setAttribute("memberID",memberID); 
			mav.setViewName("index");
			
			}else{ 
			mav.setViewName("loginForm"); 
		}
		return mav; 
	  }
	
	//회원목록조회
	public ModelAndView mbList() {
		List<memberDTO> mbList = dao.mbList();
		mav.addObject("mbList",mbList);
		mav.setViewName("memberList");
		return mav;
	}
	
	//회원목록상세조회
	public ModelAndView memberView(String mbid) {
		memberDTO mvList = dao.memberView(mbid);
		if(mvList != null) {
			mav.addObject("mvList", mvList);
			mav.setViewName("memberView");
		}else {
			mav.setViewName("memberList");
		}
		return mav;
	}
	
	//내정보
	public ModelAndView myInfo(String loginID) {
		
		memberDTO myInfo = dao.myInfo(loginID);
		
		System.out.println("myInfo");
		System.out.println(myInfo);
		
		if(myInfo!=null) {
			System.out.println("myInfo");
			System.out.println(myInfo);
	 		mav.addObject("myInfo", myInfo);
	        mav.setViewName("myInfo");	
			}else {
				mav.setViewName("index");
			}
			return mav;
		}
		
	//회원목록->수정페이지 이동
	public ModelAndView memberModi(String mbid) {
		memberDTO mbModi = dao.memberView(mbid);
		System.out.println(mbModi);
			mav.addObject("mbModi", mbModi);
			mav.setViewName("memberModi");
		return mav;
	}
	
	//회원목록->회원삭제
	public ModelAndView memberDelete(String mbid) {
		int delResult= dao.mbDel(mbid);
		
		if(delResult>0) {
			mav.setViewName("redirect:/memberList");
		}else {
			mav.setViewName("index");
		}
		return mav;
	}
	//회원수정
	public ModelAndView memberProcess(memberDTO member) {
		int proResult = dao.mbProcess(member);
		
		if(proResult>0) {
			mav.setViewName("redirect:/memberList");
		}else {
			mav.setViewName("memberMdify");
		}
		return mav;
	}
	
	//아이디중복
	public String idOverlap(String mbid) {
		String idCheck = dao.idOverlap(mbid);
		System.out.println("================idCheck==================");
		System.out.println(idCheck);
		String resultMsg = null;
		if(idCheck==null) {
			resultMsg="OK";
		}else {
			resultMsg="NO";	
		}
		return resultMsg;
	}

}
