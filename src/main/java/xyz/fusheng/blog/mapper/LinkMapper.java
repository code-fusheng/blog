/**
 * @FileName: LinkMapper
 * @Author: fusheng
 * @Date: 2020/3/11 13:42
 * Description: 友情链接Mapper
 */
package xyz.fusheng.blog.mapper;

import org.springframework.stereotype.Component;
import xyz.fusheng.blog.pojo.Link;

import java.util.List;

@Component
public interface LinkMapper {

    /**
     * 添加
     * @param link
     */
    void save(Link link);

    /**
     * 修改
     * @param link
     */
    void update(Link link);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Link getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Link> getAll();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);
}
