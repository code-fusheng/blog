/**
 * @FileName: TypeServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:29
 * Description: 博客类型业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fusheng.blog.enums.StateEnums;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.mapper.TypeMapper;
import xyz.fusheng.blog.pojo.Type;
import xyz.fusheng.blog.service.TypeService;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 添加帖子类型
     * @param type
     */
    @Override
    public void save(Type type) {
        // 查询分类是否存在[一般来说,分类类型是不重复的]
        Type t = typeMapper.getByName(type.getTypeName());
        if(t != null){
            throw new BlogException("该分类已经存在!");
        }
        typeMapper.insert(type);
    }

    @Override
    public List<Type> getAll() {
        return typeMapper.getAll();
    }

    @Override
    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }

    @Override
    public void update(Type type) {
        typeMapper.update(type);
    }

    @Override
    public void enableById(Integer id) {
        // 先查再启用
        Type t = typeMapper.getById();
        t.setEnable(StateEnums.ENABLED.getCode());
        typeMapper.update(t);
    }

    @Override
    public void disableById(Integer id) {
        // 先查再弃用 保证数据完整性
        Type t = typeMapper.getById();
        t.setEnable(StateEnums.NOT_ENABLE.getCode());
        typeMapper.update(t);
    }

    @Override
    public void deleteById(Integer id) {
        typeMapper.deleteById(id);
    }


}
