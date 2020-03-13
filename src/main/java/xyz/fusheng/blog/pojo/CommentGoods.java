/**
 * @FileName: CommentGoods
 * @Author: fusheng
 * @Date: 2020/3/11 13:03
 * Description: 评论点赞表实体类
 */
package xyz.fusheng.blog.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentGoods {

    private String id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 评论id
     */
    private String commentId;

}
