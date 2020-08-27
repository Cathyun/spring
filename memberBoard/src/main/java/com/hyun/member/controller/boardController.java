package com.hyun.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hyun.member.dto.boardDTO;
import com.hyun.member.service.boardService;

@Controller
public class boardController {

	@Autowired
	boardService bosvc;

	@Autowired
	HttpSession session;
	
	private ModelAndView mav = new ModelAndView();
	
	// 게시판버튼 이동
	@RequestMapping(value = "BoardListButton")
	public String BoardListButton() {
		return "BoardListButton";
	}

	// 글쓰기페이지이동
	@RequestMapping(value = "BoardWrite")
	public String BoardWrite() {
		return "BoardWrite";
	}

	//글작성
	@RequestMapping(value = "boardWriteFile", method = RequestMethod.POST)
	public ModelAndView boardWriteFile(@ModelAttribute boardDTO board) throws IllegalStateException, IOException {
		mav = bosvc.boardWriteFile(board);
		return mav;
	}
	
	// 글목록보기 (&페이징처리)
	@RequestMapping(value="/pagingList")
	public ModelAndView pagingList(@RequestParam(value="page", required=false,defaultValue="1")int page) {
		
		if(page==0) {
			page=1;
		}
		
		mav = bosvc.pagingList(page);
		return mav;
	}
	
	//글상세보기
	@RequestMapping(value="listView")
	public ModelAndView listView(@RequestParam("bnum")int bnum) {
		mav = bosvc.listView(bnum);
		return mav;
	}
	
	//글삭제
	@RequestMapping(value="listDelete")
	public ModelAndView listDelete(@RequestParam("bnum")int bnum) {
		mav=bosvc.listDelete(bnum);
		return mav;
		
	}
	
	//글수정페이지
	@RequestMapping(value="listModify")
	public ModelAndView listModify(@RequestParam("bnum")int bnum) {
		mav = bosvc.listModify(bnum);
		return mav;
	}
	
	//글수정
	@RequestMapping(value="listProcess")
	public ModelAndView listProcess(@ModelAttribute boardDTO board) throws IllegalStateException, IOException{
		System.out.println("============board==================");
		System.out.println(board);
		mav = bosvc.listProcess(board);
		return mav;
	}
	
	//검색기능
	@RequestMapping(value="search")
	public ModelAndView search(@RequestParam(value="searchCondition")String searchCondition,@RequestParam(value="content")String content) {
		System.out.println("==============================컨트롤러==========================================");
		System.out.println("searchCondition : " + searchCondition);
		System.out.println("content"+content);
		mav=bosvc.search(content,searchCondition);
		return mav;
	}
	
	
}
