/**
 * @FileName: BlogGoods
 * @Author: fusheng
 * @Date: 2020/3/11 13:01
 * Description: 博客点赞表实体
 */
package xyz.fusheng.blog.pojo;

import lombok.Data;

@Data
public class BlogGoods {

    private String id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 博客id
     */
    private String blogId;

}
