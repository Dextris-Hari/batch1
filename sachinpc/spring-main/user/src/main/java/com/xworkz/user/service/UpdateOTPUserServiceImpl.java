package com.xworkz.user.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xworkz.user.dao.UserDAO;
import com.xworkz.user.dto.UserDTO;

@Service
public class UpdateOTPUserServiceImpl implements UserService {
	@Autowired
	private UserDAO dao;
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService service;
	private LocalDateTime mailSendDateTime;

	public UpdateOTPUserServiceImpl() {
		super();
		System.out.println(" created  UpdateOTPUserServiceImpl");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Optional<Boolean> updateOtpDateAndTimeByMail(Integer otp, String mail, LocalTime time, LocalDate date,
			UserDTO dto) {
		System.out.println(" running in updateOtpDateAndTimeByMail method");
		Optional<List<UserDTO>> byMail = dao.findByMail(mail);
		List<UserDTO> list = byMail.get();
		UserDTO userDTO = list.get(0);
		if (userDTO != null) {

			System.out.println(" mail is matched");
			Integer otpGeneration = service.otpGeneration();
			mailSendDateTime = LocalDateTime.now();

			LocalDate date2 = mailSendDateTime.toLocalDate();
			LocalTime time2 = mailSendDateTime.toLocalTime();
			System.out.println(date2);
			System.out.println(time2);
			System.out.println(mailSendDateTime);
			System.out.println(otpGeneration);
			dto.setOtp(otpGeneration);
			dto.setDate(date2);
			dto.setTime(time2);
			Optional<Boolean> otpDateAndTimeByMail = dao.updateOtpDateAndTimeByMail(otpGeneration, dto.getMailId(),
					dto.getDate(), dto.getTime());
			System.out.println(" this is my otp " + dto.getOtp() + "—————————————");
			if (otpDateAndTimeByMail.isPresent()) {
				Optional<Boolean> sendOTPMail = sendOTPMail(mail, otpGeneration, userDTO);
				if (sendOTPMail.isPresent()) {

					System.out.println(" otp is send succussfully");
				} else {

					System.out.println(" otp is not send");
				}
			} else {

				System.out.println(" email is   invalid");
			}

		} else {

			System.out.println(" mail is not matched");
			return Optional.empty();
		}

		return Optional.of(true);
	}

	@Override
	public Optional<Boolean> sendOTPMail(String otpMail, Integer otp, UserDTO dto) {
		System.out.println(" send ,ail €€€€€€€€€²²²²²²²²");
		String to = otpMail;
		String from = "manoj.xworkz@outlook.com";
		String host = "smtp.office365.com";
		String passward = "manoj@123";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.transport.protocol", "smtp");
		System.out.println(" mail ata pata");
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				System.out.println(" mail ata pata 1");

				return new PasswordAuthentication(from, passward);
			}
		});
		System.out.println(" mail ata pata 2");
		session.setDebug(true);
		try {
			System.out.println(" mail ata pata4");
			MimeMessage mimeMessage = new MimeMessage(session);
			System.out.println(" mail ata pata6");
			mimeMessage.setFrom(new InternetAddress(from));
			System.out.println(" mail ata pata7");
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			System.out.println(" mail ata pata8");
			mimeMessage.setSubject("otp for reset password");
			System.out.println(" mail ata pata9");
			// Integer otp2 = dto.getOtp();
			mimeMessage.setText("  hai " + dto.getMailId() + " otp is " + otp + " thank you");
			System.out.println(dto.getOtp() + "🎶🎶🎶🎶🎶🎶🎶🎶🎶🎶🎶🎶🎶");
			System.out.println(" mail ata pata10");
			Transport.send(mimeMessage);
			System.out.println(" mail ata pata1");
		} catch (MessagingException e) {
			// TODO: handle exception
		}

		return Optional.of(true);
	}

	@Override
	public Boolean resetPassward(String mail, String security, Integer otp, UserDTO dto,String conformPassward) {
		System.out.println(" running on resetPassward ");
		Optional<List<UserDTO>> findByMail = dao.findByMail(mail);

		List<UserDTO> list = findByMail.get();
		UserDTO userDTO = list.get(0);
		System.out.println(userDTO + "💖💖💖💖💖💖💖");

		if (userDTO != null) {
			Integer otp2 = userDTO.getOtp();
			// otp2 = otp; // problem
			System.out.println(otp2 + "🐗🐗🐗🐗🐗🐗🐗🐗🐗🐗🐗");
			System.out.println(otp + "🐞🐞🐞🐞🐞🐞🐞🐞🐞🐞🐞");
			LocalTime time = userDTO.getTime();
			LocalTime now = LocalTime.now();
			System.out.println(now);
			Duration between = Duration.between(time, now);
			long minutes = between.toMinutes();
			if (minutes <= 3) {
				if (otp2.equals(otp)) {
					dto.setSecurity(security);
					dto.setStatus("unblocked");
					System.out.println(dto.getStatus()+"🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️");
					// problemmmmm
					Boolean passwordByEmail = dao.resetPasswordByEmail(mail, dto.getSecurity(), dto.getStatus(),
							dto.getOtp(),dto.getConformPassward());
					return true;
				} else {
					System.out.println(" otp is not match");
					return false;
				}

			} else {
				System.out.println(" email is not match");
				return false;
			}

		}

		return false;
	}

}
