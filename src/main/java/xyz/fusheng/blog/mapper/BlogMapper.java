/**
 * @FileName: BlogMapper
 * @Author: fusheng
 * @Date: 2020/3/11 13:39
 * Description: 博客Mapper
 */
package xyz.fusheng.blog.mapper;

import org.springframework.stereotype.Component;
import xyz.fusheng.blog.pojo.Blog;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.vo.BlogVo;

import java.util.List;

@Component
public interface BlogMapper {

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
     * 根据id删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<BlogVo> getByPage(Page<BlogVo> page);

    /**
     * 查询总数
     * @param page
     * @return
     */
    int getCountByPage(Page<BlogVo> page);
}
