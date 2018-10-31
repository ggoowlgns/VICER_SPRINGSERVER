package com.ice.vicer;

import java.util.List;
import java.util.concurrent.Flow.Publisher;

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

	@RequestMapping(value="/member_reg.do", method=RequestMethod.POST)
	@ResponseBody
	public String memberReg(HttpServletRequest arg0, MemberDTO dto) {
		int res=999;
		try {
		res = ibatisMapper.regMember(dto);
		
		}
		catch (Exception e) {
			// TODO: handle exception
			return "<html><body>"+res+"</body></html>";
		}
		return "<html><body>"+res+"</body></html>";
	}

	@RequestMapping(value="/member_login.do", method=RequestMethod.POST)
	@ResponseBody
	public String memberLogin(HttpServletRequest arg0, String id, String passwd) {
		
		String passwd_2;
		try{
			passwd_2 = ibatisMapper.loginMember(id);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			return "<html><body>"+"EXCEPT"+"</body></html>";
			
		}
		if(passwd.equals(passwd_2)) {
			return "<html><body>"+1+"</body></html>";
		}else {
			return "<html><body>"+999+"</body></html>";
		}
	}

	@RequestMapping(value="/serial_search.do", method=RequestMethod.POST)
	@ResponseBody
	public String serial_search(HttpServletRequest arg0, String serialNum) {
		String carModel = ibatisMapper.searchSerial(serialNum);
		return "<html><body>"+carModel+"</body></html>";
	}

	/*@RequestMapping(value="/create_otp.do", method=RequestMethod.GET)
	public int createOTP(HttpServletRequest arg0, String serialNum) {
		int res = ibatisMapper.otp_create(serialNum);
		return res;
	}*/
}