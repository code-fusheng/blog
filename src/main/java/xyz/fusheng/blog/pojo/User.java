/**
 * @FileName: User
 * @Author: fusheng
 * @Date: 2020/3/11 13:12
 * Description: 用户表实体类
 */
package xyz.fusheng.blog.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private static final long serialVersionUID = -131715810554534737L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别。1男2女
     */
    private Integer sex;

    /**
     * 头像
     */
    private String header;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 是否删除。0否1是
     */
    private Integer deleted;


}
