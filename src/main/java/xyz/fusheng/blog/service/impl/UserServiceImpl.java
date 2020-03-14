/**
 * @FileName: UserServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:30
 * Description: 用户业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fusheng.blog.mapper.UserMapper;
import xyz.fusheng.blog.pojo.User;
import xyz.fusheng.blog.service.UserService;
import xyz.fusheng.blog.utils.Md5Utils;
import xyz.fusheng.blog.utils.Page;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateInfo(User user) {
        userMapper.updateInfo(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public Page<User> getByPage(Page<User> page) {
        // 查询数据
        List<User> userList = userMapper.getByPage(page);
        page.setList(userList);
        // 查询总数
        int totalCount = userMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }

    @Override
    public void resetIds(List<Integer> userIds) {
        // JDK8新特性：集合的流式操作，这里使用到了Lambda表达式
        // 如果仅仅是遍历的话，增强for循环的效率比流式操作要高
        // 但是可读性没有流式操作高。
        // 当遍历时操作的业务逻辑较多时，流式操作的性能比普通的for循环要高
        List<User> userList = userMapper.getByIds(userIds);
        userList.forEach(user -> {
            // 在for循环中修改数据 case when
            user.setPassword(Md5Utils.toMD5("123456"));
            userMapper.update(user);
        });
    }
}
