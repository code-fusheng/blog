/**
 * @FileName: LinkServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:27
 * Description: 友情链接业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fusheng.blog.mapper.LinkMapper;
import xyz.fusheng.blog.pojo.Link;
import xyz.fusheng.blog.service.LinkService;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public void save(Link link) {
        linkMapper.save(link);
    }

    @Override
    public void update(Link link) {
        linkMapper.update(link);
    }

    @Override
    public Link getById(Integer id) {
        return linkMapper.getById(id);
    }

    @Override
    public List<Link> getAll() {
        return linkMapper.getAll();
    }

    @Override
    public void deleteById(Integer id) {
        linkMapper.deleteById(id);
    }


}
