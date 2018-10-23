package com.ice.vicer;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.vicer.service.*;
import com.ice.vicer.model.*;

@Controller
public class VicerController {
	@Autowired
	private IbatisMapper ibatisMapper;

	@RequestMapping(value="/member_reg.do", method=RequestMethod.GET)
	public int memberReg(HttpServletRequest arg0, MemberDTO dto) {
		int res = ibatisMapper.insertMember(dto);
		return res;
	}

	@RequestMapping(value="/member_login.do", method=RequestMethod.GET)
	public int memberLogin(HttpServletRequest arg0, String id, String passwd) {
		int res = ibatisMapper.searchMember(id, passwd);
		return res;
	}

	@RequestMapping(value="/serial_search.do", method=RequestMethod.GET)
	public int serial_search(HttpServletRequest arg0, String serialNum) {
		int res = ibatisMapper.searchSerial(serialNum);
		return res;
	}

	@RequestMapping(value="/create_otp.do", method=RequestMethod.GET)
	public int createOTP(HttpServletRequest arg0, String serialNum) {
		int res = ibatisMapper.otp_create(serialNum);
		return res;
	}
}