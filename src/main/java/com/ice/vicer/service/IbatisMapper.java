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
	
	public int regMember(MemberDTO dto) {
		int res = session.insert("regMember", dto);
		return res;
	}
	
	public String loginMember(String id) {
		System.err.println("IN LOGIN_MEMBER FUNC");
		System.err.println(id);
		String passwd = session.selectOne("loginMember",id);
		System.err.println(passwd);
		return passwd;
	}

	public String searchSerial(String serialNum) {
		String carModel = session.selectOne("searchSerial",serialNum);
		if(carModel != null) {
			return carModel;
		}
		return "999";
	}

  	public int otp_create(String serialNum) {
  		int otp;
  		//otp 난수 값 생성
  		int res = session.update("putOtp");
  		return res;
  	}
  	
}

