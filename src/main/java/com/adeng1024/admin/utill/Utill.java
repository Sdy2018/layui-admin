package com.adeng1024.admin.utill;


import org.springframework.util.DigestUtils;

public class Utill {
    static public String RandomNumber(){
        String num = "";
        for(int i =0;i<=10;i++){
            num=num+(int)(Math.random()*10);
        }
        return  num;
    }
    static public String passMd5(String password,String salt){
        String pass = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        return pass;
    }
}
