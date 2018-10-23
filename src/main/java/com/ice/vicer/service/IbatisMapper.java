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
	
	public int insertMember(MemberDTO dto) {
		int res = session.insert("insertMember", dto);
		return res;
	}
	
	public int searchMember(String id, String passwd) {
		List list = session.selectList("searchMember");
		if(passwd.equals(list.get(0))) {
			return 1;
		}
		return 0;
	}

	public int searchSerial(String serialNum) {
		List list = session.selectList("searchSerial");
		if(list.get(0) != null) {
			return 1;
		}
		return 0;
	}

  	public int otp_create(String serialNum) {
  		int otp;
  		//otp 난수 값 생성
  		int res = session.update("putOtp");
  		return res;
  	}
  	
}

