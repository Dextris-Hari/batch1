package com.dextris.dextris.service.impl;

import com.dextris.dextris.entity.Attachment;
import com.dextris.dextris.entity.EMail;
import com.dextris.dextris.entity.Role;
import com.dextris.dextris.entity.User;
import com.dextris.dextris.repository.RoleRepository;
import com.dextris.dextris.repository.UserRepository;
import com.dextris.dextris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.*;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
  private  UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder     passwordEncoder;


    @Autowired
    public UserServiceImpl(JavaMailSender javaMailSender, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.javaMailSender = javaMailSender;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        System.out.println("thale novu");
    }

    public UserServiceImpl() {

    }

    @Override
    public User validateAndCreateNewUser(User user) throws IOException {

        Integer count = 0;
        user.setCount(count);
        user.setStatus("unblocked");
        System.out.println(" inside the validateAndCreateNewUser method cus");

        Role role = roleRepository.findById("User").get();
        Set roles = new HashSet();
        roles.add(role);
        user.setRole(roles);
        user.setDateOfBirth(new Date());

        user.setNewPassword(getEncodedPassword(user.getNewPassword()));


        return userRepository.save(user);
    }

    @Override
    public void initRolesAndUser() {
        System.out.println(" inside the initRoleAndUser method cus");

        Role adminRole = new Role();

        adminRole.setRoleDescription("Admin role");
        adminRole.setRoleName("Admin");
        roleRepository.save(adminRole);

        Role userRole = new Role();

        userRole.setRoleDescription("Default role for the newly crated  record");
        userRole.setRoleName("User");
        roleRepository.save(userRole);


        User adminUser = new User();
        adminUser.setUserName("adminmanoj");
        adminUser.setLastName("gowda");
        adminUser.setDateOfBirth(new Date());
        adminUser.setEmail("manoj@123");
        adminUser.setStatus("unblocked");
        adminUser.setNewPassword(getEncodedPassword("manoj@123"));
        adminUser.setPhoneNumber(7204250720L);
        Set<Role> adminRoles = new HashSet<Role>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);

        userRepository.save(adminUser);


//        User user = new User();
//        user.setUserName("user");
//        user.setLastName("h j");
//        user.setDateOfBirth(new Date());
//        user.setEmail("manoj@1998");
//        user.setNewPassword(getEncodedPassword("manoj@1998"));
//        user.setPhoneNumber(9482560881L);
//        Set<Role> userRoles= new HashSet<Role>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userRepository.save(user);


    }

    public String getEncodedPassword(String password) {
        System.out.println(" inside the getEncodedPassword method cus");

        return passwordEncoder.encode(password);

    }


    public void sendEmail(String otpMail, Integer otp) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("manojhj.xworkz@gmail.com");
        simpleMailMessage.setSubject("otp for reset password");
        simpleMailMessage.setTo(otpMail);
        simpleMailMessage.setText("  hai " + " otp is " + otp + " thank you");
        javaMailSender.send(simpleMailMessage);
        System.out.println("mail is sended ");

    }

    @Override
    public void sendWelcomeEmail(String email, String sub, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("manojhj.xworkz@gmail.com");
        simpleMailMessage.setSubject(sub);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText(text);
        System.out.println("manojis");
        javaMailSender.send(simpleMailMessage);
        System.out.println("mail is sended ");

    }


    @Override
    public Attachment getById(String fileId) {
        return null;
    }

    @Override
    public void sendMailWithAttachment(String toMail, String body, String sub, String attachment) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setTo(toMail);
        mimeMessageHelper.setFrom("manojhj.xworkz@gmail.com");
        mimeMessageHelper.setSubject(sub);
        mimeMessageHelper.setText(body);
        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(message);
        System.out.println(" send with attach ment");
    }





    @Override
    public void updateOtpDateAndTimeByMail(Integer otp, String mail, LocalTime time, LocalDate date, User user) {
        System.out.println(" running in updateOtpDateAndTimeByMail method in service");
        System.out.println(mail);
        User byMail = userRepository.findByEmail(mail);
        System.out.println(" findByEmail" + byMail);

        if (byMail != null) {
            System.out.println(" findByEmail" + byMail + "not null");

            System.out.println(" mail is matched");
            double randomPin = (Math.random() * 9000) + 1000;
            int randomPin1 = (int) randomPin;
            Integer valueOf = Integer.valueOf(randomPin1);
            System.out.println(" findByEmail" + valueOf);

            LocalDate localDate1 = LocalDateTime.now().toLocalDate();
            LocalTime localTime = LocalDateTime.now().toLocalTime();


            user.setOtp(valueOf);
            user.setDate(localDate1);
            user.setTime(localTime);
            userRepository.updateOtpAndDateAndTimeByEmail(valueOf, user.getEmail(),
                    localTime, localDate1);
            sendEmail(mail, valueOf);
            System.out.println("manoj is ending");

        }

    }

    @Override
    public Boolean resetPassward(String email, String newPassword, Integer otp, User user, String conformPassword) {
        System.out.println(" running on resetPassward ");
        User findByMail = userRepository.findByEmail(email);


        if (findByMail != null) {
            Integer otp2 = findByMail.getOtp();
            // otp2 = otp; // problem
            System.out.println(otp2 + "🐗🐗🐗🐗🐗🐗🐗🐗🐗🐗🐗");
            System.out.println(otp + "🐞🐞🐞🐞🐞🐞🐞🐞🐞🐞🐞");
            LocalTime time = findByMail.getTime();
            LocalTime now = LocalTime.now();
            System.out.println(now);
            Duration between = Duration.between(time, now);
            long minutes = between.toMinutes();
            if (minutes <= 3) {
                if (otp2.equals(otp)) {
                    user.setNewPassword(getEncodedPassword(newPassword));
                    user.setStatus("unblocked");
                    System.out.println(user.getStatus() + "🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️");
                    // problemmmmm
                    userRepository.resetPasswordByEmail(email, user.getNewPassword(), user.getStatus(),
                            user.getOtp(), user.getConformPassword());
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

    @Override
    public List<User> findAll() {
        List<User> users1 = new ArrayList<User>();
        List<User> users = userRepository.findAll();
        System.out.println(users+"                       "+"today");
        for (User user : users) {
            Set<Role> role = user.getRole();
            System.out.println(role+"🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️");
           for (Role role1 : role) {
                if (role1.getRoleName().equals("User")) {
                    System.out.println("final round of checking1588888888888888888888888888888888888888");
                    users1.add(user);

                }
            }


        }


        return users1;
    }

    @Override
    public EMail send(EMail eMail) throws MessagingException {
        System.out.println("15987453216");
        MimeMessage message = javaMailSender.createMimeMessage();
        System.out.println("2123654789554411");

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        System.out.println("2123654789554411");
        mimeMessageHelper.setTo(eMail.getToMail());
        System.out.println("2123654789554411");
        mimeMessageHelper.setFrom("manojhj.xworkz@gmail.com");
        System.out.println("2123654789554411");
        mimeMessageHelper.setSubject(eMail.getSubject());
        System.out.println("2123654789554411");
        mimeMessageHelper.setText(eMail.getBody());
        FileSystemResource fileSystemResource = new FileSystemResource(new File(eMail.getAttachment()));
        System.out.println("2123654789554411");
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        System.out.println("2123654789554411");
        try {
            javaMailSender.send(message);
        } catch (Exception exception){
            System.out.println(exception.getStackTrace());


        }

        System.out.println("2123654789554411");
        System.out.println(" send with attach ment");
        EMail eMail1=  new EMail(eMail.getToMail(),eMail.getBody(),eMail.getAttachment(),eMail.getSubject());


        return   eMail1   ;
    }


}
