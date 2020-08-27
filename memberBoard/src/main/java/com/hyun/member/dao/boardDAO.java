package com.hyun.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyun.member.dto.PageDTO;
import com.hyun.member.dto.boardDTO;

@Repository
public class boardDAO {

	@Autowired
	private SqlSessionTemplate sql;

	// 글등록
	public int boardWriteFile(boardDTO board) {
		return sql.insert("memBoard.boardWrite", board);
	}

	// 글목록이동
	public List<boardDTO> pagingList() {
		return sql.selectList("memBoard.boardList");
	}
	
	//글상세보기
	public boardDTO listView(int bnum) {
		return sql.selectOne("memBoard.listView",bnum);
	}

	//글삭제
	public int boDel(int bnum) {
		return sql.delete("memBoard.listDel",bnum);
	}
	
	//글수정
	public int listProcess(boardDTO board) {
		return sql.update("memBoard.listProcess",board);
	}

	//검색기능
	public List<boardDTO> search(String content,String searchCondition) {
		if(searchCondition.equals("1")) {
			return sql.selectList("memBoard.search1",content);
		}else {
			return sql.selectList("memBoard.search2",content);
		}
		
		
	}
	
	//카운터수
	public int listCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
