/**
 * @FileName: BlogService
 * @Author: fusheng
 * @Date: 2020/3/11 15:03
 * Description: 博客业务逻辑接口
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.Blog;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.vo.BlogVo;

public interface BlogService {

    /**
     * 保存
     * @param blog
     */
    void save(Blog blog);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Blog getById(String id);

    /**
     * 更新
     * @param blog
     */
    void update(Blog blog);

    /**
     * 根据id阅读
     * @param id
     * @return
     */
    BlogVo readById(String id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<BlogVo> getByPage(Page<BlogVo> page);
}
