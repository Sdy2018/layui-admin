package com.adeng1024.admin.config;


import com.adeng1024.admin.pojo.User;
import com.adeng1024.admin.service.UserService;
import com.adeng1024.admin.utill.Utill;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;



public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //授权
    //授权不是立刻授权,而是在进入页面的时候进行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//认证成功的时候的user
//        info.addStringPermission();//添加权限
        info.addRole(currentUser.getRole());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //用户名，密码去数据库取
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) {  //没有这个人
            return null;  //其实就是抛出UnknownAccountException异常
        }
        if (user.getPassword().equals(Utill.passMd5(String.valueOf(userToken.getPassword()), user.getSalt()))) {
            user.setPassword(String.valueOf(userToken.getPassword()));
        }
//        System.out.println();
        //shiro的认证很蠢
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), "");
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("user", user.getUsername());
        session.setAttribute("role",user.getRole());

        return info;
    }
}
