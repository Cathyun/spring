package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;


@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int insert(MemberDTO member) {
		return sql.insert("Member.insert", member);
	}

	public List<MemberDTO> mList() {
		return sql.selectList("Member.mList");
	}

}
