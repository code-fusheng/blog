/**
 * @FileName: TypeService
 * @Author: fusheng
 * @Date: 2020/3/11 15:06
 * Description: 博客类型业务逻辑接口
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.Type;

import java.util.List;

public interface TypeService {

    /**
     * 保存添加类型
     * @param type
     */
    void save(Type type);

    /**
     * 查询类型list
     * @return
     */
    List<Type> getAll();

    /**
     * 前台查询所有
     * @return
     */
    List<Type> getTypeList();

    /**
     * 根据id更新
     * @param type
     */
    void update(Type type);

    /**
     * 根据id启用
     * @param id
     */
    void enableById(Integer id);

    /**
     * 根据id弃用
     * @param id
     */
    void disableById(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Type getById(Integer id);
}
