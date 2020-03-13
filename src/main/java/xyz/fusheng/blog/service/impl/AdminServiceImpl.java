/**
 * @FileName: AdminServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:21
 * Description: 管理员业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fusheng.blog.mapper.AdminMapper;
import xyz.fusheng.blog.pojo.Admin;
import xyz.fusheng.blog.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    @Override
    public Admin getAdmin() {
        return adminMapper.getAdmin();
    }

    @Override
    public void updateInfo(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public void updatePassword(Admin admin) {
        Admin oldAdmin = adminMapper.getAdmin();
        oldAdmin.setPassword(admin.getPassword());
        adminMapper.update(oldAdmin);
    }
}
