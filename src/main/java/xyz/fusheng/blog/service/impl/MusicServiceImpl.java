/**
 * @FileName: MusicServiceImpl
 * @Author: fusheng
 * @Date: 2020/3/11 15:27
 * Description: 音乐业务逻辑接口实现类
 */
package xyz.fusheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fusheng.blog.enums.StateEnums;
import xyz.fusheng.blog.mapper.MusicMapper;
import xyz.fusheng.blog.pojo.Music;
import xyz.fusheng.blog.service.MusicService;
import xyz.fusheng.blog.utils.Page;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public void save(Music music) {
        musicMapper.save(music);
    }

    @Override
    public void update(Music music) {
        musicMapper.update(music);
    }

    @Override
    public Music getById(Integer id) {
        return musicMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        musicMapper.deleteById(id);
    }

    @Override
    public void enableById(Integer id) {
        Music music = musicMapper.getById(id);
        music.setEnabled(StateEnums.ENABLED.getCode());
        musicMapper.update(music);
    }

    @Override
    public void disableById(Integer id) {
        Music music = musicMapper.getById(id);
        music.setEnabled(StateEnums.NOT_ENABLE.getCode());
        musicMapper.update(music);
    }

    @Override
    public Page<Music> getByPage(Page<Music> page) {
        // 查询数据
        List<Music> musicList = musicMapper.getByPage(page);
        page.setList(musicList);
        // 查询总数
        int totalCount = musicMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }

    @Override
    public List<Music> getList() {
        return musicMapper.getList();
    }
}
