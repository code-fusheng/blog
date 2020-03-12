/**
 * @FileName: LogMapper
 * @Author: fusheng
 * @Date: 2020/3/11 13:43
 * Description: 日志Mapper
 */
package xyz.fusheng.blog.mapper;

import org.springframework.stereotype.Component;
import xyz.fusheng.blog.pojo.Log;

@Component
public interface LogMapper {

    /**
     * 保存
     * @param logger
     */
    void save(Log logger);
}
