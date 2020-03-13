/**
 * @FileName: LinkService
 * @Author: fusheng
 * @Date: 2020/3/11 15:05
 * Description:
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.Link;

import java.util.List;

public interface LinkService {

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
