package com.hyun.member.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class boardDTO {
	private int bnum;
	private String bwriter;
	private String bpassword;
	private String btitle;
	private String bcontents;
	private Date bdate;
	private int bhit;
	
	private MultipartFile bfile;
	private String bfilename;
}
