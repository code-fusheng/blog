/**
 * @FileName: ShiroUtils
 * @Author: fusheng
 * @Date: 2020/3/11 12:01
 * Description: Shiro 相关工具类
 */
package xyz.fusheng.blog.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Component;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.pojo.Admin;

@Component
public class ShiroUtils {

    private ShiroUtils() {
    }

    /**
     * 获取登录中的用户
     * @return
     */
    public static Admin getLoginUser() {
        Session session = SecurityUtils.getSubject().getSession();
        SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        if (principalCollection == null) {
            return null;
        }
        return (Admin) principalCollection.getPrimaryPrincipal();
    }
}
