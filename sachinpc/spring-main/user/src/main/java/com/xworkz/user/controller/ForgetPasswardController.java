
package com.xworkz.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.user.dto.UserDTO;
import com.xworkz.user.service.UserService;

@Controller
@RequestMapping("/forget")
public class ForgetPasswardController {
	@Autowired
	@Qualifier("updateOTPUserServiceImpl")
	private UserService service;

	public ForgetPasswardController() {
		super();
		System.out.println(" created  ForgetPasswardController ");

	}

	@GetMapping
	String forgetPassward(UserDTO dto) {
		Optional<Boolean> otpDateAndTimeByMail = service.updateOtpDateAndTimeByMail(dto.getOtp(), dto.getMailId(),
				dto.getTime(), dto.getDate(), dto);
		Boolean boolean1 = otpDateAndTimeByMail.get();
		if (boolean1) {
			System.out.println(" check our mail id otp is sended");

			return "ConformPassward";
		} else {

			System.out.println(" invalid mail id");
			return "ForgetPassward";
		}

	}

	@PostMapping
	String onPostForgetPassward(UserDTO dto) {

		return this.forgetPassward(dto);
	}

}
