/**
 * @FileName: LogService
 * @Author: fusheng
 * @Date: 2020/3/11 15:05
 * Description: 日志业务逻辑接口
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.Log;
import xyz.fusheng.blog.utils.Page;

import java.util.List;

public interface LogService {

    /**
     * 保存
     * @param logger
     */
    void save(Log logger);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<Log> getByPage(Page<Log> page);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 批量删除[根据id集合删除]
     * @param ids
     */
    void deleteByIds(List<Integer> ids);
}
