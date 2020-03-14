/**
 * @FileName: AboutServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:09
 * Description: 博客信息业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.enums.StateEnums;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.mapper.AboutMapper;
import xyz.fusheng.blog.pojo.About;
import xyz.fusheng.blog.service.AboutService;
import xyz.fusheng.blog.utils.Page;

import java.util.List;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public void save(About about) {
        aboutMapper.save(about);
    }

    @Override
    public void update(About about) {
        aboutMapper.updateById(about);
    }

    @Override
    public About getById(Integer id) {
        return aboutMapper.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public About read() {
        About about = aboutMapper.getAbout();
        if (about == null){
            return null;
        }
        // 更新阅读数
        about.setAboutRead(about.getAboutRead() + 1);
        aboutMapper.updateById(about);
        return about;
    }

    @Override
    public void deleteById(Integer id) {
        aboutMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void enableById(Integer id) {
        // 查询是否已经存在关于我的
        About about = aboutMapper.getAbout();
        if(about != null){
            throw new BlogException(ResultEnum.ERROR.getCode(),"当前已存在启用中关于我的信息");
        }
        about = aboutMapper.getById(id);
        about.setEnable(StateEnums.ENABLED.getCode());
        aboutMapper.updateEnable(about);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void disableById(Integer id) {
        About about = aboutMapper.getById(id);
        about.setEnable(StateEnums.NOT_ENABLE.getCode());
        aboutMapper.updateEnable(about);
    }

    @Override
    public Page<About> getByPage(Page<About> page) {
        // 查询数据
        List<About> aboutList = aboutMapper.getByPage(page);
        page.setList(aboutList);
        // 查询总数
        int totalCount = aboutMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
