/**
 * @FileName: UserController
 * @Author: fusheng
 * @Date: 2020/3/14 17:59
 * Description: 用户控制类
 */
package xyz.fusheng.blog.controller;

import afu.org.checkerframework.checker.oigj.qual.O;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.pojo.User;
import xyz.fusheng.blog.service.UserService;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.utils.Result;
import xyz.fusheng.blog.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存 [后台]
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody User user){
        userService.save(user);
        return new Result<>("添加成功");
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody User user){
        userService.update(user);
        return new Result<>("修改成功!");
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @PutMapping("/updateInfo")
    public Result<Object> updateInfo(@RequestBody User user){
        userService.updateInfo(user);
        return new Result<>("修改成功!");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<User> get(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return new Result<>(user);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return new Result<>("删除成功!");
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<User>> getByPage(@RequestBody Page<User> page){
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)){
            // 排序列不为空
            String[] sortColumns = {"sex", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = userService.getByPage(page);
        return new Result<>(page);
    }

    /**
     * 重置密码
     * @param userIds
     * @return
     */
    @PutMapping("/resetPwd")
    public Result<Object> resetPwd(@RequestBody List<Integer> userIds){
        userService.resetIds(userIds);
        return new Result<>("重置完毕!");
    }
}
