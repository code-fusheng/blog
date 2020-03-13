/**
 * @FileName: TypeMapper
 * @Author: fusheng
 * @Date: 2020/3/11 13:44
 * Description: 帖子类型Mapper
 */
package xyz.fusheng.blog.mapper;

import org.springframework.stereotype.Component;
import xyz.fusheng.blog.pojo.Type;

import java.util.List;

@Component
public interface TypeMapper {

    /**
     * 根据名称查询
     * @param typeName
     * @return
     */
    Type getByName(String typeName);

    /**
     * 插入
     * @param type
     */
    void insert(Type type);

    /**
     * 后台查询所有
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
     * 根据id查询
     * @return
     */
    Type getById();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id查
     * @param id
     * @return
     */
    Type getById(Integer id);
}
