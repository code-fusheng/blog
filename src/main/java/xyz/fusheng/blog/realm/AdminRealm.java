/**
 * @FileName: AdminRealm
 * @Author: fusheng
 * @Date: 2020/3/12 12:03
 * Description: 处理管理员的登录和授权逻辑
 */
package xyz.fusheng.blog.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.pojo.Admin;
import xyz.fusheng.blog.service.AdminService;

public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        Admin admin = adminService.getByUsername(username);
        if (admin == null){
            // 用户不存在
            throw new BlogException(ResultEnum.ERROR.getCode(),"用户不存在!");
        }

        return new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());
    }
}
