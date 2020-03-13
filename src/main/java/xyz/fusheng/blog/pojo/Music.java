/**
 * @FileName: Music
 * @Author: fusheng
 * @Date: 2020/3/11 13:08
 * Description: 歌曲信息表实体类
 */
package xyz.fusheng.blog.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Music {

    /**
     * 音乐id
     */
    private Integer id;

    /**
     * 歌曲名
     */
    private String name;

    /**
     * 歌手
     */
    private String artist;

    /**
     * 歌曲链接
     */
    private String url;

    /**
     * 封面
     */
    private String cover;

    /**
     * 歌词
     */
    private String lrc;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 是否启用，0否1是
     */
    private Integer enabled;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;

}
