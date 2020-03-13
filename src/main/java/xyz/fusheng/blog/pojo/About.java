/**
 * @FileName: About
 * @Author: fusheng
 * @Date: 2020/3/11 12:34
 * Description: 帖子信息表实体类
 */
package xyz.fusheng.blog.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class About {
    /**
     * 帖子id
     */
    private Integer aboutId;

    /**
     * 标题
     */
    private String aboutTitle;

    /**
     * 帖子内容
     */
    private String aboutContent;

    /**
     * 阅读数
     */
    private Integer aboutRead;

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
     * 是否启用
     */
    private Integer enable;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;
}
