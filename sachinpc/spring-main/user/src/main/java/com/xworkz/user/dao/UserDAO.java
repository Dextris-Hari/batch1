package com.xworkz.user.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.xworkz.user.dto.UserDTO;

public interface UserDAO {
	boolean save(UserDTO dto);

	Optional<List<UserDTO>> findByMail(String newMail);

	default Optional<List<UserDTO>> findByEmailAndSecurity(String email, String security) {

		return null;

	}

	Boolean updateStatusByMail(String status, String mail);

	Boolean updateCountByMail(int count, String mail);

	Optional<Boolean> updatePasswardByMail(String passward, String mail);

	Optional<Boolean> updateOtpDateAndTimeByMail(Integer otp, String email, LocalDate date, LocalTime time);

	default Boolean resetPasswordByEmail(String email, String security, String status, Integer otp,String conformPassward) {
		return true;

	}

	Boolean updateNameAndPhoneNumberBymail(String mail, Long number, String name, String fileName);
	
	

}
