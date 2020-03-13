/**
 * @FileName: LinkController
 * @Author: fusheng
 * @Date: 2020/3/13 13:49
 * Description: 友情链接控制类
 */
package xyz.fusheng.blog.controller;

import afu.org.checkerframework.checker.oigj.qual.O;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.blog.pojo.Link;
import xyz.fusheng.blog.service.LinkService;
import xyz.fusheng.blog.utils.Result;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 添加
     * @param link
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Link link){
        linkService.save(link);
        return new Result<>("添加成功!");
    }

    /**
     * 修改
     * @param link
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Link link){
        linkService.update(link);
        return new Result<>("修改成功!");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Object> get(@PathVariable("id") Integer id){
        Link link = linkService.getById(id);
        return new Result<>(link);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/list")
    public Result<List<Link>> list(){
        List<Link> linkList = linkService.getAll();
        return new Result<>(linkList);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable("id") Integer id){
        linkService.deleteById(id);
        return new Result<>("删除成功!");
    }



}
