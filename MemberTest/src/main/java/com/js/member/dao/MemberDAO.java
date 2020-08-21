package com.js.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	//ctrl+shift+o 를 누르면 자동import!
	
	//바로 다음에 선언한 것을 자동적으로 잡아주기 위하여 
	//@Autowired를 선언
	@Autowired
	private SqlSessionTemplate sql;
	
	//회원가입
	public int memberJoin(MemberDTO member) {
		return sql.insert("Member.memberJoin", member);
	}

	//회원목록
	public List<MemberDTO> mList() {
		return sql.selectList("Member.memberList");
	}
    
	//로그인
	public String memberLogin(MemberDTO member) {
		return sql.selectOne("Member.memberLogin",member);
	}

	//상세조회
	public MemberDTO memberView(String id) {
		return sql.selectOne("Member.memberView",id);
	}
	
	//회원삭제
	public int memberDelete(String id) {
		return sql.delete("Member.memberDelete",id);
	}
 
	//회원수정하기
	public int modifyProcess(MemberDTO member) {
		return sql.update("Member.memberModify",member);
	}
	
	
	

	
	
	
	
	
}
