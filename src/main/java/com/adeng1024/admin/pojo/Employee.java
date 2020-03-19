package com.adeng1024.admin.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;

@Validated
public class Employee {
    private Integer id;
    private String name;
    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Email
    private String email;

    public Employee() {
    }

    public Employee(String name, Integer gender, Date birthday, @Email String email) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
