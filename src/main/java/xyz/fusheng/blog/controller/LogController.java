/**
 * @FileName: LogController
 * @Author: fusheng
 * @Date: 2020/3/14 11:14
 * Description: 日志控制类
 */
package xyz.fusheng.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fusheng.blog.enums.ResultEnum;
import xyz.fusheng.blog.pojo.Log;
import xyz.fusheng.blog.service.LogService;
import xyz.fusheng.blog.utils.Page;
import xyz.fusheng.blog.utils.Result;
import xyz.fusheng.blog.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<Log>> getByPage(@RequestBody Page<Log> page){
        String sortColumn = page.getSortColumn();
        if(StringUtils.isNotBlank(sortColumn)){
            // 排序列不为空
            String[] sortColumns = {"log_url", "log_status", "log_method", "log_time", "created_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = logService.getByPage(page);
        return new Result<>(page);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable("id") Integer id){
        logService.deleteById(id);
        return new Result<>("删除成功!");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PutMapping("/deleteByIds")
    public Result<Object> deleteByIds(@RequestBody List<Integer> ids) {
        logService.deleteByIds(ids);
        return new Result<>("删除成功！");
    }

}
