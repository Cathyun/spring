package com.hyun.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyun.member.dto.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	//댓글목록 조회
	public List<CommentDTO> commentList(int cbnum) {
		return sql.selectList("Comment.commentList",cbnum);
	}
	
	//댓글작성
	public int commentwrite(CommentDTO comment) {
		return sql.insert("Comment.commentWrite",comment);
	}
	
	//댓글삭제
	public int commentDelete(int cnum) {
		return sql.delete("Comment.commentDelete",cnum);
	}
	
}
