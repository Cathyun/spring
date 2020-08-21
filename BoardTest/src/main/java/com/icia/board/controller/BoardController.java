package com.icia.board.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BoardService bdsvc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	//게시판 글쓰기 페이지 (boardForm)
	@RequestMapping(value="/boardForm")
	public String boardForm() {
		return "boardWrite";
	}
	
	//게시판 글쓰기 (boardWriteFile)
	@RequestMapping(value="/boardWriteFile", method = RequestMethod.POST)
	public ModelAndView boardWriterFile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException{
		mav = bdsvc.boardWriteFile(board);	
		return mav;
	}
	
	//게시판 목록 (boardList)
	@RequestMapping(value="/boardList")
	public ModelAndView boardList() {
		mav = bdsvc.boardList();
		return mav;
	}
	//게시물과 페이징처리
	 @RequestMapping(value="/pagingList")
	public ModelAndView pagingList(@RequestParam(value="page", required=false,defaultValue="1")int page) {
		//required : 필수로 page를 받아오지 않아도 된다.
		//defaultValue = "1" : 기본값은 "1"
		//int page =1;
		//page=request.getParameter("page");
			
		if(page==0) {
			page=1;
		}
		
		mav = bdsvc.pageList(page);
		return mav;
	}
	
	 //상세보기
	@RequestMapping(value="listView")
	public ModelAndView listView(@RequestParam(value="bnum") int bNum, @RequestParam(value="page", required=false,defaultValue="1")int page) {
		mav = bdsvc.listView(bNum,page);
		return mav;
	}
	 
	
	//게시물수정페이지 이동
	@RequestMapping(value="listModify")
	public ModelAndView listModify(@RequestParam(value="bnum") int bNum, @RequestParam(value="page", required=false,defaultValue="1")int page ) {
		mav=bdsvc.listModify(bNum,page);
		return mav;
	}
	
	//게시물 수정하기
	@RequestMapping(value="listProcess")
	public ModelAndView listProcess(@ModelAttribute BoardDTO board, @RequestParam(value="page", required=false,defaultValue="1")int page) 
			throws IllegalStateException, IOException {
        System.out.println(board);
		mav=bdsvc.listProcess(board,page);
		return mav;
	}
	
	
	//게시글삭제
	@RequestMapping(value="boardDelete")
	public ModelAndView boardDelete(@RequestParam(value="bnum") int bNum, @RequestParam(value="page", required=false,defaultValue="1")int page) {
		mav = bdsvc.boardDelete(bNum,page);
		return mav;
	}
	 
	//검색 기능
	@RequestMapping(value="search")
	public ModelAndView search(@RequestParam(value="keyword") String keyword,
			@RequestParam(value="searchCondition") String searchCondition) {
		mav = bdsvc.search(keyword,searchCondition);
		return mav;
	}
	 
}







