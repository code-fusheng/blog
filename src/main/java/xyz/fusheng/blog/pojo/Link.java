/**
 * @FileName: Link
 * @Author: fusheng
 * @Date: 2020/3/11 13:04
 * Description: 友情链接表实体类
 */
package xyz.fusheng.blog.pojo;

import lombok.Data;

@Data
public class Link {

    /**
     * 链接id
     */
    private Integer linkId;

    /**
     * 名称
     */
    private String linkName;

    /**
     * 链接地址
     */
    private String linkUrl;

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
     * 是否删除，0否1是
     */
    private Integer deleted;

}
