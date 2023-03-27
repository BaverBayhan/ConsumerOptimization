package com.GDSC.ConsumerOptimization.Entity.User;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String city;
    @Column
    private String memberNumberInHome;
    @Column
    private String job;
    @Column
    private int annualSalary;
    @Column
    private String civilStatus;

    public UserInfo() {
    }

    public UserInfo(String username, String city, String memberNumberInHome, String job, int annualSalary, String civilStatus) {
        this.username = username;
        this.city = city;
        this.memberNumberInHome = memberNumberInHome;
        this.job = job;
        this.annualSalary = annualSalary;
        this.civilStatus = civilStatus;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMemberNumberInHome() {
        return memberNumberInHome;
    }

    public void setMemberNumberInHome(String memberNumberInHome) {
        this.memberNumberInHome = memberNumberInHome;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", city='" + city + '\'' +
                ", memberNumberInHome='" + memberNumberInHome + '\'' +
                ", job='" + job + '\'' +
                ", annualSalary=" + annualSalary +
                ", civilStatus='" + civilStatus + '\'' +
                '}';
    }
}
