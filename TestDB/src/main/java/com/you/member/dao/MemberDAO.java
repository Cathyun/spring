package com.you.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.you.member.dto.MemberDTO;


@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int insert(MemberDTO member) {
//		리턴값을 만들어주고 sql문을 xml파일로 만들어준다!
		return sql.insert("Member.insert",member);
	}
	
	
	

}
