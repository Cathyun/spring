package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

@Service
public class BoardService {

	ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BoardDAO bdao;
	
	//게시판 글쓰기
	public ModelAndView boardWriteFile(BoardDTO board) throws IllegalStateException, IOException{
		MultipartFile bFile = board.getBfile();
		String fileName = bFile.getOriginalFilename();
		
		//저장위치
		String savePath = "C:/Users/1/Documents/workspace-spring-tool-suite-4-4.7.1.RELEASE/BoardTest/src/main/webapp/resources/fileUpload/" + fileName;
		
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}
		board.setBfilename(fileName);

		int writeResult = bdao.boardWriteFile(board);
		
		if(writeResult>0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

	   	
	//게시물 목록
	public ModelAndView boardList() {
       List<BoardDTO> boardList = bdao.boardList();
		
		//디스 패쳐 방식
		mav.addObject("boardList", boardList);
		mav.setViewName("boardList");	
		return mav;
	}
	

	private static final int PAGE_LIMIT = 5; //한 페이지에 보여줄 글갯수 
	private static final int BLOCK_LIMIT = 5; //화면에 보여줄 페이지 번호 갯수
	
	//페이지처리
	public ModelAndView pageList(int page) {
		
		PageDTO paging = new PageDTO();
		
		//게시글 갯수 조회 : 2
		int listcount = bdao.listCount();
		
		int startrow = (page - 1) * PAGE_LIMIT + 1;
		int endrow = page * PAGE_LIMIT;
		
		paging.setPage(page);
		paging.setEndrow(endrow);
		paging.setStartrow(startrow);
	
		int maxpage = (int)(Math.ceil((double)listcount/PAGE_LIMIT));
		int startpage = (((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1) * BLOCK_LIMIT+1;
		
		int endpage = startpage + BLOCK_LIMIT - 1;
		
		if(endpage>maxpage) {
			endpage = maxpage;
		}
		
		/*
		 *  (1)올림:Math.ceil 
		 *  (2)내림:Math.floor 
		 *  (3)반올림:Math.round
		 * 
		 */
		
		paging.setMaxpage(maxpage);
		paging.setStartpage(startpage);
		paging.setEndpage(endpage);
		
		List<BoardDTO> pagingList = bdao.pagingList(paging);
		
		mav.addObject("pagingList", pagingList);
		mav.addObject("paging", paging);
		mav.setViewName("pagingList");	
		
		return mav;
	}

	//상세조회
	public ModelAndView listView(int bNum, int page) {
		
		//조회수 증가
		bdao.boardHit(bNum);
		
		//상세보기
		BoardDTO lList = bdao.listView(bNum);
			mav.addObject("lList", lList);
			mav.addObject("page", page);
			mav.setViewName("listView");
		return mav;
	}

    //게시물 수정페이지 이동
	public ModelAndView listModify(int bNum,int page) {
	  BoardDTO bModify = bdao.boardModify(bNum);
	  mav.addObject("bModify",bModify);
	  mav.setViewName("listModify");
	  return mav;
	}

	//게시물 수정하기
	public ModelAndView listProcess(BoardDTO board, int page) throws IllegalStateException, IOException {
		//실제로 업로드 된 파일
		MultipartFile bFile = board.getBfile();
		
		//업로드 된 파일의 이름
		String fileName = bFile.getOriginalFilename();
		
		//저장위치
		String savePath = "C:/Users/1/Documents/workspace-spring-tool-suite-4-4.7.1.RELEASE/BoardTest/src/main/webapp/resources/fileUpload/" 
		+ fileName;
		
		//파일이 있다 -->> !bFile.isEmpty
		//파일이 있을 경우에만 실행된다는 뜻
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}
		
		System.out.println("+++++++++++++++확인1!!+++++++++++++");
		System.out.println(board);
		
		System.out.println(fileName);
		System.out.println("+++++++++++++++확인2!!+++++++++++++");
		System.out.println(board);
		
		
		board.setBfilename(fileName);
		
		int result = bdao.listProcess(board);		
		if(result>0) {
			mav.setViewName("redirect:/pagingList?page="+page);
		}else {
			mav.setViewName("listView");
		}
		return mav;
	}

	//게시물삭제
	public ModelAndView boardDelete(int bNum, int page) {
		int delresult= bdao.boardDelete(bNum);
		if(delresult>0) {
			//페이지를 삭제하면 맨앞에 있는 상세보기로 가는 것이 아니라
			//그 페이지에 남아있는다!
			mav.setViewName("redirect:/pagingList?page="+page);
		}else {
			mav.setViewName("index");
		}
		return mav;
	}

	//게시물 검색기능
	public ModelAndView search(String keyword, String searchCondition) {
		 List<BoardDTO> paginglist = bdao.search(keyword,searchCondition);
		 mav.addObject("pagingList",paginglist);
		 mav.setViewName("pagingList");
		return mav;
	}
}
