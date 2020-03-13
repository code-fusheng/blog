/**
 * @FileName: Page
 * @Author: fusheng
 * @Date: 2020/3/13 21:51
 * Description: 分页对象
 */
package xyz.fusheng.blog.utils;

import afu.org.checkerframework.checker.igj.qual.I;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Page<T> implements Serializable {

    private static final String SORT_ASC = "asc";

    private static final String SORT_DESC = "desc";

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页显示条数
     */
    private Integer pageSize = 20;

    /**
     * 总页数
     */
    private Integer totalPage = 0;

    /**
     * 总条数
     */
    private Integer totalCount = 0;

    /**
     * 分页起始位置
     */
    private Integer index;

    /**
     * 数据
     */
    private List<T> list;

    /**
     * 条件参数
     */
    private Map<String, Object> params = new HashMap<>(16);

    /**
     * 排序列
     */
    private String sortColumn;

    /**
     * 排序方式
     */
    private String sortMethod = "asc";

    /**
     * 获取当前页
     */
    private Integer getCurrentPage(){
        if(currentPage < 1){
            return 1;
        }
        return this.currentPage;
    }

    /**
     * 获取index
     * @return
     */
    public Integer getIndex(){
        return (currentPage - 1) * pageSize;
    }

    /**
     * 设置总条数的时候计算总页数
     * @param totalCount
     */
    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
        this.totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

    /**
     * 获取排序方式
     * @return
     */
    public String getSortMethod(String sortMethod) {
        if (StringUtils.isBlank(sortMethod)) {
            return "asc";
        }
        if (sortMethod.toLowerCase().startsWith(SORT_ASC)) {
            this.sortMethod = SORT_ASC;
        } else if (sortMethod.toLowerCase().startsWith(SORT_DESC)) {
            this.sortMethod = SORT_DESC;
        } else {
            this.sortMethod = SORT_ASC;
        }
        return this.sortMethod;
    }

}
