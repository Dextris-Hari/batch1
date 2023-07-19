package com.xworkz.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.user.dto.UserDTO;
import com.xworkz.user.service.UserService;

@Controller
@RequestMapping("/conform")
public class ConformPassward {
	@Autowired
	@Qualifier("updateOTPUserServiceImpl")
	private UserService service;

	public ConformPassward() {
		super();
		System.out.println(" created ConformPassward ");
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	String updatePassward(UserDTO dto,Model model) {
		
		if(dto.getSecurity().equals(dto.getConformPassward())){
			
		Boolean resetPassward = 
		service.resetPassward(dto.getMailId(), dto.getSecurity(), dto.getOtp(), dto,dto.getConformPassward());
		  

		if (resetPassward) {

			System.out.println(" password is reseted");
			return "SignIn";
		} else {

			System.out.println(" password is not reseted");
			return "ForgetPassward";
		}
	
		}
		else {
			
			model.addAttribute("msg" ,"u r passward is mismatched");
			return "ConformPassward";	
		}
		
	}	
		

	@PostMapping
	String onUpdatePassward(UserDTO dto,Model model) {

		return updatePassward(dto,model);
	}

}
