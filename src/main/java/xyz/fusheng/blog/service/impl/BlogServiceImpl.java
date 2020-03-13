/**
 * @FileName: BlogServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:23
 * Description: 博客业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.fusheng.blog.mapper.BlogMapper;
import xyz.fusheng.blog.mapper.TypeMapper;
import xyz.fusheng.blog.pojo.Blog;
import xyz.fusheng.blog.pojo.Type;
import xyz.fusheng.blog.service.BlogService;
import xyz.fusheng.blog.utils.IdWorker;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.vo.BlogVo;

import java.beans.Transient;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     * @param blog
     */
    @Override
    public void save(Blog blog) {
        blog.setBlogId(idWorker.nextId() + "");
        blogMapper.save(blog);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Blog getById(String id) {
        return blogMapper.getById(id);
    }

    /**
     * 更新
     * @param blog
     */
    @Override
    public void update(Blog blog) {
        blogMapper.update(blog);
    }

    /**
     * 根据id阅读[需要进行更新(+1)阅读数操作]
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BlogVo readById(String id) {
        Blog blog = blogMapper.getById(id);
        // 阅读 --> 增加阅读数[更新阅读数]
        blog.setBlogRead(blog.getBlogRead() + 1);
        blogMapper.update(blog);
        // 将 Blog 转为 BlogVo
        BlogVo blogVo = new BlogVo();
        // Spring 自带的属性转换
        BeanUtils.copyProperties(blog, blogVo);
        // 查询分类
        Type type = typeMapper.getById(blog.getBlogType());
        blogVo.setTypeName(type.getTypeName());
        return blogVo;
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void deleteById(String id) {
        blogMapper.deleteById(id);
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<BlogVo> getByPage(Page<BlogVo> page) {
        // 先查询数据
        List<BlogVo> blogVoList = blogMapper.getByPage(page);
        page.setList(blogVoList);
        // 再查询总数
        int totalCount = blogMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
