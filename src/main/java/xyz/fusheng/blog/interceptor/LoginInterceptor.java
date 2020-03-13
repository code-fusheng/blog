/**
 * @FileName: LoginInterceptor
 * @Author: fusheng
 * @Date: 2020/3/12 12:51
 * Description: 登录拦截
 */
package xyz.fusheng.blog.interceptor;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.pojo.Admin;
import xyz.fusheng.blog.utils.ShiroUtils;
import xyz.fusheng.blog.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取 token
        String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token)) {
            // token 不为空,获取当前登录用户
            Object loginUser = ShiroUtils.getLoginUser();
            if (loginUser != null) {
                // 说明 token 有效
                return true;
            }
        }
        throw new BlogException(ResultEnum.NOT_LOGIN);
    }
}
