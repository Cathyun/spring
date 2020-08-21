package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;
import com.icia.member.dto.joinDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int insert(joinDTO member) {
		return sql.insert("Member.insert",member);
	}
}

