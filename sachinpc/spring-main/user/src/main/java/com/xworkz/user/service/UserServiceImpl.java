package com.xworkz.user.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.xworkz.user.dao.UserDAO;
import com.xworkz.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO dao;
	private Integer count = 0;

	public UserServiceImpl() {
		System.out.println(" this is service impl" + this.getClass().getSimpleName());

	}

	@Override
	public boolean validateAndSave(UserDTO dto) {
		String passwardGenerator = passward();
		Integer count = 0;
		if (!passwardGenerator.isEmpty()) {
			System.out.println(" password is not emty");
			dto.setSecurity(passwardGenerator);
			dto.setCount(count);
			dto.setStatus("unblocked");
			boolean save = dao.save(dto);
			if (save) {
				Boolean sendMail = sendMail(dto.getMailId(), dto, dto.getSecurity());
				System.out.println();
				System.out.println(sendMail);
				return true;
			} else {

				return false;
			}

		} else {
			System.out.println(" passward is emty");
			return false;
		}
	}

	@Override
	public Optional<List<UserDTO>> findByMail(String newMail) {
		Optional<List<UserDTO>> findByMail = dao.findByMail(newMail);
		System.out.println(findByMail.isPresent());
		if (!findByMail.isPresent()) {
			System.out.println(".....................................................");
			return findByMail.empty();
		} else {
			System.out.println(" service checking ...................");
			List<UserDTO> list = findByMail.get();

			return Optional.of(list);

		}
	}

	@Override
	public String passward() {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String num = "0987654321";
		String specialChars = "?!@$%&*";
		String combination = upperCase + lowerCase + specialChars + num;
		int length = 6;
		char[] passward = new char[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {

			passward[i] = combination.charAt(random.nextInt((combination.length())));
		}

		return new String(passward);
	}

	@Override
	public Optional<List<UserDTO>> validateAndFindByMailAndSecurity(String mail, String security, UserDTO dto) {
		String security2 = dto.getSecurity();
		// dto.setStatus("active");
		// dao.updateStatusByMail(dto.getStatus(), mail);
		Optional<List<UserDTO>> emailAndSecurity = dao.findByEmailAndSecurity(mail, security);
		System.out.println(" this =======================🙌🙌🙌🙌🙌🙌🙌");
		if (emailAndSecurity.isPresent()) {
			this.count = 0;
			Boolean countByMail = dao.updateCountByMail(count, mail);
			List<UserDTO> list = emailAndSecurity.get();

			return Optional.of(list);

		} else {
			System.out.println(count);
			this.count++;
			System.out.println(" data is not there this is from service");
			// return Optional.empty();

		}
		if (this.count <= 3) {
			System.out.println(this.count + "💕💕💕💕💕💕💕💕💕💕");
			Boolean statusByMail = this.dao.updateStatusByMail(dto.getStatus(), mail);
			System.out.println(statusByMail);
			Boolean byMail = this.dao.updateCountByMail(count, mail);
			System.out.println(count + "         ❤️❤️❤️❤️❤️");
			System.out.println(byMail);

		}
		if (this.count > 3) {
			dto.setStatus("blocked");
			Boolean byMail = this.dao.updateStatusByMail(dto.getStatus(), mail);

		}
		return Optional.empty();

	}

	@Override
	public Boolean sendMail(String email, UserDTO dto, String security) {
		String to = email;
		String from = "manoj.xworkz@outlook.com";
		String host = "smtp.office365.com";
		String password = "manoj@123";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.debug", true);
		properties.put("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				try {
					return new PasswordAuthentication(from, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}

		});
		session.setDebug(true);
		System.out.println(" running ................................");

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// message.setHeader("hai", "everone");
			message.setSubject("Registration Confirmation Mail");
			message.setText("Hi" + " this mail is from xworkz institute  MR" + " " + dto.getName() + " "
					+ "your registration is completed" + " " + " " + "your passward is" + "= " + dto.getSecurity() + " "
					+ " thank you for register "
					+ "with us we will make u happy and provide best training for java full stack  " + " "
					+ " we have experience trainers and best placement option" + "thanks and regards");
			System.out.println("running 2...................................");
			Transport.send(message);
		} catch (MessagingException e) {
			e.getStackTrace();
		}

		return true;
	}

	@Override
	public Optional<Boolean> updatePasswardByMail(String passward, String mail) {
		// TODO Auto-generated method stub
		System.out.println(" running in updatePasswardByMail");
		if (passward.length() < 10 && passward.length() >= 12 && passward != null) {

			System.out.println(" u enter the passward may be its exceds or null");
		} else {

			System.out.println(" password is valid");
			Optional<List<UserDTO>> byMail = dao.findByMail(mail);
			if (!byMail.isPresent()) {
				System.out.println(" data is not there data is null");
				return Optional.empty();

			} else {
				Optional<Boolean> byMail2 = dao.updatePasswardByMail(passward, mail);
				if (byMail2.isPresent()) {
					System.out.println(" updatePasswardByMail is currect");
					return Optional.of(true);
				} else {

					System.out.println("updatePasswardByMail is not curect");
					return Optional.empty();
				}

			}
		}
		return Optional.empty();
	}

	@Override
	public Integer otpGeneration() {
		double randomPin = (Math.random() * 9000) + 1000;
		int randomPin1 = (int) randomPin;
		Integer valueOf = Integer.valueOf(randomPin1);

		return valueOf;
	}

}
