/**
 * @FileName: AdminService
 * @Author: fusheng
 * @Date: 2020/3/11 15:03
 * Description: 管理员业务逻辑接口
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.Admin;

public interface AdminService {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    Admin getByUsername(String username);
}
