package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	//게시글 등록
		public int boardWriteFile(BoardDTO board) {
			return sql.insert("Board.boardWriteFile", board);
		}

	//게시글 전체목록
	public List<BoardDTO> boardList() {
		return sql.selectList("Board.boardList");
	}

	 //게시물 갯수조회
	public int listCount() {
		return sql.selectOne("Board.listCount");
	}
	
	//페이징처리
	public List<BoardDTO> pagingList(PageDTO paging) {
		return sql.selectList("Board.paginglist", paging);
	}

	//상세조회
	public BoardDTO listView(int bNum) {
		return sql.selectOne("Board.listView",bNum);
	}
    
	//수정페이지
	public BoardDTO boardModify(int bNum) {
		return sql.selectOne("Board.boardModify",bNum);
	}
	
	//게시물수정
	public int listProcess(BoardDTO board) {
		return sql.update("Board.listProcess", board);
	}

	//조회수증가
	public void boardHit(int bNum) {
		sql.update("Board.boardHit",bNum);
	}
	
	//게시물삭제
	public int boardDelete(int bNum) {
		return sql.delete("Board.boardDelete",bNum);
	}
	//검색기능
	public List<BoardDTO> search(String keyword, String searchCondition) {

		if(searchCondition.equals("1")) {
			return sql.selectList("Board.search1",keyword);
		}else {
			return sql.selectList("Board.search2",keyword);
		}
		
	}

	
	
	
	
	

	
	
   
	
	
	
}
