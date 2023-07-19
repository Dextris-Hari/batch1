package com.xworkz.user.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.xworkz.user.dto.UserDTO;

public interface UserService {
	default boolean validateAndSave(UserDTO dto) {
		return false;

	}

	default Optional<List<UserDTO>> findByMail(String newMail) {
		return null;

	}

	default String passward() {
		return null;

	}

	default Optional<List<UserDTO>> validateAndFindByMailAndSecurity(String mail, String security, UserDTO dto) {
		return null;

	}

	default Boolean sendMail(String email, UserDTO dto, String security) {
		return null;

	}

	default Optional<Boolean> updatePasswardByMail(String passward, String mail) {
		return null;

	}

	default Integer otpGeneration() {

		return null;

	}

	default Optional<Boolean> updateOtpDateAndTimeByMail(Integer otp, String mail, LocalTime time, LocalDate date,
			UserDTO dto) {

		return null;

	}

	default Optional<Boolean> sendOTPMail(String otpMail, Integer otp, UserDTO dto) {
		return null;

	}
	 default Boolean resetPassward(String mail, String security,Integer otp,UserDTO dto,String conformPassward) {
		return null;
		 
		 
		 
	 }
	 
}
