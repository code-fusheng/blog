/**
 * @FileName: AdminMapper
 * @Author: fusheng
 * @Date: 2020/3/11 13:39
 * Description: 管理员Mapper
 */
package xyz.fusheng.blog.mapper;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import xyz.fusheng.blog.pojo.Admin;

@Component
public interface AdminMapper {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    Admin getByUsername(String username);
}
