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
    private int age;
    @Column
    private String sex;
    @Column
    private String job;
    @Column
    private int annualSalary;
    @Column
    private String civilStatus;

    public UserInfo() {
    }

    public UserInfo(String userName, String city, int age, String sex, String job, int annualSalary, String civilStatus) {
        this.username = userName;
        this.city = city;
        this.age = age;
        this.sex = sex;
        this.job = job;
        this.annualSalary = annualSalary;
        this.civilStatus = civilStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
                ", userName='" + username + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", annualSalary=" + annualSalary +
                ", civilStatus='" + civilStatus + '\'' +
                '}';
    }
}
