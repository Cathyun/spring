package com.js.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//getter/setter/tostring/생성자
@Data

public class MemberDTO {

	private String jsid;
	private String jspw;
	private String jsname;
	private String jsbirth;
	private String jsgender;
	private String jsemail;

}
