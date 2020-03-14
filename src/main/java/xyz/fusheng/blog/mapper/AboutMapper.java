/**
 * @FileName: AboutMapper
 * @Author: fusheng
 * @Date: 2020/3/11 13:37
 * Description: 帖子信息Mapper
 */
package xyz.fusheng.blog.mapper;

import org.springframework.stereotype.Component;
import xyz.fusheng.blog.pojo.About;
import xyz.fusheng.blog.utils.Page;

import java.util.List;

@Component
public interface AboutMapper {
    /**
     * 保存
     * @param about
     */
    void save(About about);

    /**
     * 根据id更新
     * @param about
     */
    void updateById(About about);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    About getById(Integer id);

    /**
     * 查询关于我的
     * @return
     */
    About getAbout();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 更新启用状态
     * @param about
     */
    void updateEnable(About about);

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<About> getByPage(Page<About> page);

    /**
     * 分页查询是统计总数
     * @param page
     * @return
     */
    int getCountByPage(Page<About> page);
}
