/**
 * @FileName: BlogController
 * @Author: fusheng
 * @Date: 2020/3/13 20:43
 * Description: 博客控制类
 */
package xyz.fusheng.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.pojo.Blog;
import xyz.fusheng.blog.service.BlogService;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.utils.Result;
import xyz.fusheng.blog.utils.StringUtils;
import xyz.fusheng.blog.vo.BlogVo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 保存
     * @param blog
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new Result<>("添加成功!");
    }

    /**
     * 根据id查询[后台使用]
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Object> get(@PathVariable("id") String id) {
        Blog blog = blogService.getById(id);
        return new Result<>(blog);
    }

    /**
     * 更新
     * @param blog
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Blog blog) {
        blogService.update(blog);
        return new Result<>("更新成功!");
    }

    /**
     * 根据id阅读[前端页面展现博客详细信息]
     * @param id
     * @return
     */
    @GetMapping("/read/{id}")
    public Result<BlogVo> read(@PathVariable("id") String id) {
        BlogVo blog = blogService.readById(id);
        return new Result<>(blog);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable("id") String id) {
        blogService.deleteById(id);
        return new Result<>("删除成功!");
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<BlogVo>> getByPage(@RequestBody Page<BlogVo> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序类不为空
            String[] sortColumns = {"blog_goods", "blog_read", "blog_collection",
                    "type_name", "blog_comment", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法");
            }
        }
        page = blogService.getByPage(page);
        return new Result<>(page);
    }


}
