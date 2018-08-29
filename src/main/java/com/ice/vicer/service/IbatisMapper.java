package com.ice.vicer.service;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.vicer.model.MemberDTO;

@Service
public class IbatisMapper {
	@Autowired
	private SqlSession session;
	
	public List<MemberDTO> listBoard() {
		List<MemberDTO> list = null;
		list = session.selectList("listBoard");
		return list;
	}
	
	public int insertBoard(MemberDTO dto) {
		int res = session.insert("insertBoard", dto);
		return res;
	}
	
	public MemberDTO getBoard(int num, String mode){
		
		if (mode.equals("content")) plusReadcount(num);
		MemberDTO dto = session.selectOne("getBoard", num);
 		return dto;
  	}
	
	public void plusReadcount(int num) {
 		session.update("plusReadcount", num);
   	}
  	
  	public int deleteBoard(int num, String pass) {
  		MemberDTO dto = getBoard(num, "delete");
  		if(dto.getPasswd().equals(pass)) {
  			int res = session.delete("deleteBoard", num);
  			return res;
  		}else {
  			return -1;
  		}
  	}
  	
}

