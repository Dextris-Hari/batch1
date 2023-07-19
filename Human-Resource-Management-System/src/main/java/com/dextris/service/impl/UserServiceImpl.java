package com.dextris.service.impl;

import com.dextris.entity.Role;
import com.dextris.entity.User;
import com.dextris.repository.RoleRepository;
import com.dextris.repository.UserRepository;
import com.dextris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    public UserServiceImpl( UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {

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
        adminUser.setDateOfBirth(new Date());
        adminUser.setGender("male");
        adminUser.setEmail("manoj@123");
        adminUser.setPhoneNumber(7204250720L);
        adminUser.setNewPassword(getEncodedPassword("manoj@123"));

        adminUser.setStatus("unblocked");
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

    @Override
    public Optional<User> getByMail(String mail) {
     User user=   userRepository.findByEmail(mail);
     if(user==null){
         return Optional.empty();
     }
        return  Optional.of(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
@Override
    public void sendCredential(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("manojhj.xworkz@gmail.com");
        simpleMailMessage.setSubject("user creadential");
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setText("this is your user name :"+user.getUserName()+"   this is your password: "+ user.getNewPassword());
        System.out.println("manojis");
try {
    javaMailSender.send(simpleMailMessage);

}
catch (Exception exception){
    exception.printStackTrace();

    System.out.println("mail has been sent ");
}

    }
    public User updateUserDetails(String username, User updatedUserDetails) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found with username: " + username);
        }


        user.setEmail(updatedUserDetails.getEmail());
        user.setDateOfBirth(updatedUserDetails.getDateOfBirth());
        user.setGender(updatedUserDetails.getGender());
        user.setPhoneNumber(updatedUserDetails.getPhoneNumber());


        return userRepository.save(user);


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
    public Boolean resetPassword
            (String email, String newPassword, Integer otp, User user, String conformPassword) {
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
                            user.getOtp(), user.getConfirmPassword());
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

