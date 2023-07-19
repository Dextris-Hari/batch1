package com.dextris.dextris.repository;


import com.dextris.dextris.entity.User;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByEmail(String email);
    @Transactional
    @Modifying
    @Query("update User info set info.otp=:otp,info.date=:date,info.time=:time where info.email=:mi")
    void updateOtpAndDateAndTimeByEmail(@Param("otp") Integer otp, @Param("mi")String mail,@Param("time") LocalTime time,@Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query(" update  User info set info.otp=:otp,info.newPassword=:newPassword , info.status=:st, info.conformPassword=:cp where info.email=:mi")
    void resetPasswordByEmail(@Param("mi") String findByMail, @Param("newPassword") String newPassword, @Param("st")String status, @Param("otp")Integer otp, @Param("cp")String conformPassword);
}
