/**
 * @FileName: LogServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:25
 * Description: 日志业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fusheng.blog.mapper.LogMapper;
import xyz.fusheng.blog.pojo.Log;
import xyz.fusheng.blog.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存
     * @param logger
     */
    @Override
    public void save(Log logger) {
        logMapper.save(logger);
    }
}
