/**
 * @FileName: InterceptorConfig
 * @Author: fusheng
 * @Date: 2020/3/12 13:42
 * Description:
 */
package xyz.fusheng.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import xyz.fusheng.blog.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 全部拦截, 指定放行
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/*/login");
        super.addInterceptors(registry);
    }
}
