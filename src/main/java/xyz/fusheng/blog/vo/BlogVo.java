/**
 * @FileName: BlogVo
 * @Author: fusheng
 * @Date: 2020/3/13 21:39
 * Description: VO（ View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
 */
package xyz.fusheng.blog.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogVo implements Serializable {
    /**
     * 帖子id
     */
    private String blogId;

    /**
     * 标题
     */
    private String blogTitle;

    /**
     * 封面
     */
    private String blogImage;

    /**
     * 帖子内容
     */
    private String blogContent;

    /**
     * 点赞数
     */
    private Integer blogGoods;

    /**
     * 阅读数
     */
    private Integer blogRead;

    /**
     * 收藏数
     */
    private Integer blogCollection;

    /**
     * 博客分类
     */
    private String typeName;

    /**
     * 文章来源
     */
    private String blogSource;

    /**
     * 简介
     */
    private String blogRemark;

    /**
     * 评论数
     */
    private Integer blogComment;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
