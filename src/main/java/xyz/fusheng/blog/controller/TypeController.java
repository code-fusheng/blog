/**
 * @FileName: TypeController
 * @Author: fusheng
 * @Date: 2020/3/12 20:06
 * Description: 帖子类型控制类
 */
package xyz.fusheng.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.blog.pojo.Type;
import xyz.fusheng.blog.service.TypeService;
import xyz.fusheng.blog.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 保存添加类型
     * @param type
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Type type){
        typeService.save(type);
        return new Result<>("添加成功!");
    }

    /**
     * 后台查询所有
     * @return
     */
    @GetMapping("/listBack")
    public Result<List<Type>> list(){
        List<Type> typeList = typeService.getAll();
        return new Result<>(typeList);
    }

    /**
     * 前台查询所有
     * @return
     */
    @GetMapping("/getList")
    public Result<List<Type>> getList(){
        List<Type> typeList = typeService.getTypeList();
        return new Result<>(typeList);
    }

    /**
     * 根据id更新
     * @param type
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Type type){
        typeService.update(type);
        return new Result<>("更新成功!");
    }

    /**
     * 根据id启用
     * @param id
     * @return
     */
    @PutMapping("/enable/{id}")
    public Result<Object> enable(@PathVariable("id") Integer id){
        typeService.enableById(id);
        return new Result<>("已启用");
    }

    /**
     * 根据id弃用
     * @param id
     * @return
     */
    @PutMapping("/disable/{id}")
    public Result<Object> disable(@PathVariable("id") Integer id){
        typeService.disableById(id);
        return new Result<>("已弃用");
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable("id") Integer id){
        typeService.deleteById(id);
        return new Result<>("删除成功!");
    }
}
