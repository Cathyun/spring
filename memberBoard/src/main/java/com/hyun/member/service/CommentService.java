package com.hyun.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyun.member.dao.CommentDAO;
import com.hyun.member.dto.CommentDTO;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO cdao;
	
	List<CommentDTO>commentList = new ArrayList<CommentDTO>();	
	
	//댓글목록
	public List<CommentDTO> commentList(CommentDTO comment) {
		commentList = cdao.commentList(comment.getCbnum());
		return commentList;
	}

	//댓글작성
	public List<CommentDTO> commentwrite(CommentDTO comment) {
		int writeResult = cdao.commentwrite(comment);
		if(writeResult>0) {
			commentList = cdao.commentList(comment.getCbnum());
		}else {
			commentList = null;
		}
		return commentList;
	}
	
	//댓글삭제
	public List<CommentDTO> commentDelete(CommentDTO comment) {
		int delResult = cdao.commentDelete(comment.getCnum());
		if(delResult>0) {
			commentList = cdao.commentList(comment.getCbnum());
		}else {
			commentList = null;
		}
		return commentList;
	}
	
	
}
