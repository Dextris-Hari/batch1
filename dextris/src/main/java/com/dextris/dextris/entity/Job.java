package com.dextris.dextris.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String jobName;
    private String jobDescription;
    private String packege;
    private String skills;
    private Integer expirience;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getPackege() {
        return packege;
    }

    public void setPackege(String packege) {
        this.packege = packege;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getExpirience() {
        return expirience;
    }

    public void setExpirience(Integer expirience) {
        this.expirience = expirience;
    }

    public Job( String jobName, String jobDescription, String packege, String skills, Integer expirience) {

        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.packege = packege;
        this.skills = skills;
        this.expirience = expirience;
    }

    public Job() {
    }
}
