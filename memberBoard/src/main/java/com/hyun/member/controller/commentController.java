package com.hyun.member.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyun.member.dto.CommentDTO;
import com.hyun.member.service.CommentService;

@Controller
@RequestMapping("/comment/*")
public class commentController {
	
	@Autowired
	private CommentService cmtsvc;
	
	List<CommentDTO>commentList = new ArrayList<CommentDTO>();
	
	//댓글목록조회
	//'comment/commentwrite'로 보내는 값을 받는다.
	//CommentDTO→cbnum만 받아와도 상관 x
	@RequestMapping(value="commentlist")
	//@ResponseBody -> service에서 설정하지 않아도 바로 jsp로 갈 수 있도록 하는 것이다!!
	public @ResponseBody List<CommentDTO> commentList(@ModelAttribute CommentDTO comment) {
		commentList=cmtsvc.commentList(comment);
		return commentList;
	}
	
	//댓글 입력
	@RequestMapping(value="commentwrite")
	public @ResponseBody List<CommentDTO> commentwrite(@ModelAttribute CommentDTO comment) {
		commentList = cmtsvc.commentwrite(comment);
		return commentList;
	}
	
	//댓글삭제
	@RequestMapping(value="commentdelete")
	public @ResponseBody List<CommentDTO> commentDelete(@ModelAttribute CommentDTO comment) {
		commentList = cmtsvc.commentDelete(comment);
		return commentList;
	}
}
