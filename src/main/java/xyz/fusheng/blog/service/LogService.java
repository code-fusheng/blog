/**
 * @FileName: LogService
 * @Author: fusheng
 * @Date: 2020/3/11 15:05
 * Description: 日志业务逻辑接口
 */
package xyz.fusheng.blog.service;

import xyz.fusheng.blog.pojo.Log;

public interface LogService {

    /**
     * 保存
     * @param logger
     */
    void save(Log logger);

}
