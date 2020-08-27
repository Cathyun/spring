package com.hyun.member.dto;

import com.hyun.member.dto.CommentDTO;

import lombok.Data;

@Data
public class CommentDTO {
	private int cnum;  //댓글번호(PK)
	private int cbnum; //게시글번호(FK)
	private String cwriter; //작성자
	private String ccontents; //댓글내용

}
