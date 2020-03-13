/**
 * @FileName: TestController
 * @Author: fusheng
 * @Date: 2020/3/11 19:11
 * Description: 测试类
 */
package xyz.fusheng.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.utils.Result;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试异常
     */

    @GetMapping("/testException/{id}")
    public Result<Object> testException(@PathVariable("id") Integer id) {
        if (id == 1) {
            return new Result<>();
        } else {
            throw new BlogException("发生了异常");
        }
    }
}
