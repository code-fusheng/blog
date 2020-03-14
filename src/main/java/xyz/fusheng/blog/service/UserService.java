/**
 * @FileName: UserService
 * @Author: fusheng
 * @Date: 2020/3/11 15:07
 * Description: 用户业务逻辑接口
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.User;
import xyz.fusheng.blog.utils.Page;

import java.util.List;

public interface UserService {

    /**
     * 保存
     * @param user
     */
    void save(User user);

    /**
     * 更新
     * @param user
     */
    void update(User user);

    /**
     * 修改个人信息
     * @param user
     */
    void updateInfo(User user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<User> getByPage(Page<User> page);

    /**
     * 重置密码[123456]
     * @param userIds
     */
    void resetIds(List<Integer> userIds);
}
