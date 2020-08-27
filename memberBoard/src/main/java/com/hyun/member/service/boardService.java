package com.hyun.member.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hyun.member.dao.boardDAO;
import com.hyun.member.dao.memberDAO;
import com.hyun.member.dto.boardDTO;
import com.hyun.member.dto.PageDTO;

@Service
public class boardService {

	@Autowired
	boardDAO dao;

	@Autowired
	HttpSession session;

	ModelAndView mav = new ModelAndView();

	// 글작성하기
	public ModelAndView boardWriteFile(boardDTO board) throws IllegalStateException, IOException {
		MultipartFile bFile = board.getBfile();
		String fileName = bFile.getOriginalFilename();

		// 저장위치
		String savePath = "C:/Users/1/Documents/workspace-spring-tool-suite-4-4.7.1."
				+ "RELEASE/BoardTest/src/main/webapp/resources/fileUpload/" + fileName;

		if (!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}

		board.setBfilename(fileName);

		int writeReustlt = dao.boardWriteFile(board);

		if (writeReustlt > 0) {
			mav.setViewName("BoardListButton");
		} else {
			mav.setViewName("BoardWrite");
		}
		return mav;
	}

	
	  private static final int PAGE_LIMIT = 5; 
	  private static final int BLOCK_LIMIT = 5;
	 
	// 글목록이동
	public ModelAndView pagingList(int page) {

		
		  PageDTO paging = new PageDTO();
		  
		  int listcount = dao.listCount();
		  
		  int startrow = (page - 1) * PAGE_LIMIT + 1; 
		  int endrow = page * PAGE_LIMIT;
		  
		  paging.setPage(page); paging.setEndrow(endrow); paging.setStartrow(startrow);
		  
		  int maxpage = (int) (Math.ceil((double) listcount / PAGE_LIMIT)); 
		  int startpage = (((int) (Math.ceil((double) page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		  
		  int endpage = startpage + BLOCK_LIMIT - 1;
		  
		  if (endpage > maxpage) { endpage = maxpage; }
		  
		  paging.setMaxpage(maxpage); paging.setStartpage(startpage);
		  paging.setEndpage(endpage);
		 

		List<boardDTO> pagingList = dao.pagingList();

		mav.addObject("pagingList", pagingList);
		mav.setViewName("pagingList");
		return mav;
	}

	// 글상세보기
	public ModelAndView listView(int bnum) {
		boardDTO boList = dao.listView(bnum);
		if (boList != null) {
			mav.addObject("boList", boList);
			mav.setViewName("listView");
		} else {
			mav.setViewName("pagingList");
		}
		return mav;
	}

	// 글삭제
	public ModelAndView listDelete(int bnum) {
		int BoResult = dao.boDel(bnum);
		if (BoResult > 0) {
			mav.setViewName("redirect:/listView");
		} else {
			mav.setViewName("pagingList");
		}
		return mav;
	}

	// 수정페이지
	public ModelAndView listModify(int bnum) {
		boardDTO boList = dao.listView(bnum);
		mav.addObject("boList", boList);
		mav.setViewName("listModify");
		return mav;
	}

	// 글수정
	public ModelAndView listProcess(boardDTO board) throws IllegalStateException, IOException {
		System.out.println("========board=========");
		System.out.println(board);

		MultipartFile bFile = board.getBfile();
		String fileName = bFile.getOriginalFilename();

		// 저장위치
		String savePath = "C:/Users/1/Documents/workspace-spring-tool-suite-4-4.7.1."
				+ "RELEASE/BoardTest/src/main/webapp/resources/fileUpload/" + fileName;

		if (!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}

		board.setBfilename(fileName);

		int proResult = dao.listProcess(board);

		if (proResult > 0) {
			mav.setViewName("redirect:/pagingList");
		} else {
			mav.setViewName("listModify");
		}
		return mav;
	}
	
	//검색
	public ModelAndView search(String content,String searchCondition) {
		List<boardDTO> pagingList=dao.search(content,searchCondition);
		System.out.println("=========================결과========================");
		System.out.println("pagingList :" + pagingList);
		mav.addObject("pagingList",pagingList);
		mav.setViewName("pagingList");
		return mav;
	}

}
