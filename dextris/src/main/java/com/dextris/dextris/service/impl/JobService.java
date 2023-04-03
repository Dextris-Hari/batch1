package com.dextris.dextris.service.impl;

import com.dextris.dextris.entity.Job;
import com.dextris.dextris.entity.Role;
import com.dextris.dextris.entity.User;
import com.dextris.dextris.repository.JobRepository;
import com.dextris.dextris.repository.UserRepository;
import com.dextris.dextris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public Job addNeWJob(Job job) {

        System.out.println("pffcavvvvvvvv");
        Job job1 = jobRepository.save(job);
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            Set<Role> role = user.getRole();
            for (Role r : role) {
                if (r.getRoleName().equals("User")) {
                    userService.sendWelcomeEmail(user.getEmail(), "Dextris add new job Requerement", job.getJobDescription() +
                       "   "+     "job name:" + job.getJobName()+"    " + "job packege:" + job.getPackege() + "   "+"job requered skills" + job.getSkills()+"     " + " and this job requires a expirience of:"+job.getExpirience()+" thanks and regards   "


                    );
                }
            }

        }


        return job1;
    }
}
