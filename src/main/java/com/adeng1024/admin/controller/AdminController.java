package com.adeng1024.admin.controller;


import com.adeng1024.admin.pojo.Employee;
import com.adeng1024.admin.pojo.Msg;
import com.adeng1024.admin.pojo.SuccessMsg;

import com.adeng1024.admin.pojo.User;
import com.adeng1024.admin.service.EmployeeService;
import com.adeng1024.admin.service.UserService;


import com.adeng1024.admin.utill.Utill;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServerProperties serverProperties;


    //登出
    @GetMapping("/logout")
    public String logout(){
        Subject currentSubject = SecurityUtils.getSubject();
        currentSubject.logout();
        return "redirect:/";
    }

    //登录验证
    @PostMapping("/toLogin")
    @ResponseBody
    public Msg login(String username,String password) {
        //获取当前输入的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        登录，没有异常就说明登录成功
        try {
            //这个token会传到userRealm域的认证方法中
            subject.login(token);
            return new SuccessMsg(200,"success","ok");
        } catch (UnknownAccountException e) {
            return new Msg(403,"账号或者密码错误");
        } catch (IncorrectCredentialsException e) {
            return new Msg(403,"账号或者密码错误");
        }
    }

    //用户页面
    @GetMapping("/user")
    public String user(Model model){
        List<User> users = userService.queryUserList();
        model.addAttribute("userList", users);
        model.addAttribute("prefix", serverProperties.getServlet().getContextPath());
        return "user";
    }
    //删除用户
    @DeleteMapping("/user/delete/{id}")
    @ResponseBody
    public Msg deleteUser(@PathVariable("id") Integer id){
        Integer res = userService.deleteUserById(id);
        if(res>0){
            return new Msg(200,"删除成功");
        }
        return new Msg(400,"删除失败");
    }
    //添加用户
    @PostMapping("/user")
    @ResponseBody
    public Msg addUser(User user){
        User user1 = userService.queryUserByName(user.getUsername());
        if(user1!=null){
            return new Msg(500, "用户名已存在");
        }
        System.out.println(new Date());
        String salt = Utill.RandomNumber();
        Integer res=userService.addUser(new User(user.getUsername(),Utill.passMd5(user.getPassword(),salt),salt,new Date()));
        if(res>=1){
            return new Msg(200,"success");
        }
        return new Msg(500,"添加失败");
    }

    //添加员工
    @PostMapping("/employee")
    @ResponseBody
    public Msg addEmp(Employee employee){

        System.out.println(employee);

        Integer res = employeeService.addEmp(employee);
        if(res>=1){
            return new Msg(200,"success");
        }
        return new Msg(500,"添加失败");
    }

    //人员页面
    @GetMapping("/employee")
    public String employee(Model model){
        List<Employee> employees = employeeService.queryEmpList();
        model.addAttribute("empList", employees);
        model.addAttribute("prefix", serverProperties.getServlet().getContextPath());
        return "employee";
    }

    //删除员工
    //删除用户
    @DeleteMapping("/employee/delete/{id}")
    @ResponseBody
    public Msg deleteEmployee(@PathVariable("id") Integer id){
        Integer res = employeeService.deleteEmpById(id);
        if(res>0){
            return new Msg(200,"删除成功");
        }
        return new Msg(400,"删除失败");
    }

    //人员更新页面
    @GetMapping("/employee/update/{id}")
    public String updateEmpPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.queryEmpById(id);
        if(employee==null){
            return "error/404";
        }
        model.addAttribute("employee", employee);
        return "employee-update";
    }
    //人员更新请求
    @PutMapping("/employee/update")
    @ResponseBody
    public Msg updateEmp(Employee employee){
        Integer integer = employeeService.updateEmp(employee);
        System.out.println(employee.toString());
        if(integer>0){
            return new Msg(200, "success");
        }
        return new Msg(400, "更新失败");
    }
}
