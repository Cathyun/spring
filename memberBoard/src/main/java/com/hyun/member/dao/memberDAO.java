package com.hyun.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyun.member.dto.boardDTO;
import com.hyun.member.dto.memberDTO;

@Repository
public class memberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	//회원가입
	public int join(memberDTO member) {
		return sql.insert("memBoard.memberjoin",member);
	}

	//로그인
     public String login(memberDTO member) { 
		  return sql.selectOne("memBoard.memberLogin",member); 
	  }

     //회원목록조회
	public List<memberDTO> mbList() {
		return sql.selectList("memBoard.memberList");
	}
	
	//회원상세조회
	public memberDTO memberView(String mbid) {
		return sql.selectOne("memBoard.memberOne",mbid);
	}

	//회원삭제
	public int mbDel(String mbid) {
		return sql.delete("memBoard.memberDel",mbid);
	}
	
	//회원수정
	public int mbProcess(memberDTO member) {
		return sql.update("memBoard.memberProcess",member);
	}

	//내정보
	public memberDTO myInfo(String loginID) {
		return sql.selectOne("memBoard.myInfo", loginID);
	}

	//아이디중복
	public String idOverlap(String mbid) {
		return sql.selectOne("memBoard.idOverlap",mbid);
	}
	
	


}
