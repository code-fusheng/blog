/**
 * @FileName: Admin
 * @Author: fusheng
 * @Date: 2020/3/11 12:46
 * Description: 管理员表实体类
 */
package xyz.fusheng.blog.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = -559415810554538278L;

    /**
     * 管理员id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String header;

    /**
     * 签名
     */
    private String signature;

    /**
     * 介绍
     */
    private String comment;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;


}
