/**
 * @FileName: Log
 * @Author: fusheng
 * @Date: 2020/3/11 13:07
 * Description: 接口访问日志表实体类
 */
package xyz.fusheng.blog.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Log implements Serializable {
    /**
     * 日志id
     */
    private Integer logId;

    /**
     * 请求路径
     */
    private String logUrl;

    /**
     * 参数
     */
    private String logParams;

    /**
     * 访问状态，1正常0异常
     */
    private Integer logStatus;

    /**
     * 异常信息
     */
    private String logMessage;

    /**
     * 请求方式，get、post等
     */
    private String logMethod;

    /**
     * 响应时间
     */
    private Long logTime;

    /**
     * 返回值
     */
    private String logResult;

    /**
     * 请求ip
     */
    private String logIp;

    /**
     * 创建时间
     */
    private String createdTime;
}
