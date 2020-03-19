package com.adeng1024.admin.pojo;


import java.util.Date;

public class User {
    private String username;
    private String password;
    private String salt;
    private String role;
    private Integer id;
    private Date date;

    public User(String username, String password, String salt, String role, Integer id, Date date) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.id = id;
        this.date = date;
    }


    public User() {
    }

    public User(String username, String password, String salt,Date date) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.date=date;
    }

    public User(String username, String password, String salt, String role) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
