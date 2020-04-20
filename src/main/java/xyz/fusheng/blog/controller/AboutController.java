/**
 * @FileName: AboutController
 * @Author: fusheng
 * @Date: 2020/3/14 9:34
 * Description: 关于我的(博客信息)控制类
 */
package xyz.fusheng.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.pojo.About;
import xyz.fusheng.blog.service.AboutService;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.utils.Result;
import xyz.fusheng.blog.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    /**
     * 保存
     * @param about
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody About about){
        aboutService.save(about);
        return new Result<>("保存成功!");
    }

    /**
     * 修改成功
     * @param about
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody About about){
        aboutService.update(about);
        return new Result<>("修改成功!");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Object> get(@PathVariable("id") Integer id){
        About about = aboutService.getById(id);
        return new Result<>(about);
    }

    /**
     * 阅读 [保证只存在一个关于我的]
     * @return
     */
    @GetMapping("/read")
    public Result<Object> read(){
        About about = aboutService.read();
        return new Result<>(about);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable("id") Integer id){
        aboutService.deleteById(id);
        return new Result<>("删除成功!");
    }

    /**
     * 启用
     * @param id
     * @return
     */
    @PutMapping("/enable/{id}")
    public Result<Object> enable(@PathVariable("id") Integer id) {
        aboutService.enableById(id);
        return new Result<>("启用成功");
    }

    /**
     * 弃用
     * @param id
     * @return
     */
    @PutMapping("/disable/{id}")
    public Result<Object> disable(@PathVariable("id") Integer id) {
        aboutService.disableById(id);
        return new Result<>("弃用成功");
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<About>> getByPage(@RequestBody Page<About> page) {
        String sortColumn = page.getSortColumn();
        String newSortColumn = StringUtils.upperCharToUnderLine(sortColumn);
        page.setSortColumn(newSortColumn);
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"about_read", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(newSortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = aboutService.getByPage(page);
        return new Result<>(page);
    }
}
