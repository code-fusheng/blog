/**
 * @FileName: BeanConfig
 * @Author: fusheng
 * @Date: 2020/3/11 12:24
 * Description: 用于将一些实体类放入容器[IdWorkder 学号算法]
 */
package xyz.fusheng.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.fusheng.blog.utils.IdWorker;

@Configuration
public class BeanConfig {

    /**
     * 将学法算法工具类注入容器
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}
