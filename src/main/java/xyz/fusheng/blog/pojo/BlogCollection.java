/**
 * @FileName: BlogCollection
 * @Author: fusheng
 * @Date: 2020/3/11 12:56
 * Description: 博客收藏时间表实体类
 */
package xyz.fusheng.blog.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogCollection implements Serializable {

    private static final long serialVersionUID = -535915810554536111L;

    /**
     * 收藏id
     */
    private String collectionId;

    /**
     * 帖子id
     */
    private String blogId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 收藏时间
     */
    private String collectionTime;


}
