/**
 * @FileName: BlogExceptionAdvice
 * @Author: fusheng
 * @Date: 2020/3/11 11:08
 * Description: 自定义异常处理器
 */
package xyz.fusheng.blog.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.fusheng.blog.exception.BlogException;
import xyz.fusheng.blog.utils.Result;

@ControllerAdvice
@Slf4j
public class BlogExceptionAdvice {
     /**
       * 功能描述：统一异常处理
       * @since: 1.0.0
       * @Author: 25610
       * @Date: 2020/3/11 11:21
       */
    @ExceptionHandler(BlogException.class)
    @ResponseBody
    public Result<Object> exceptionHandler(BlogException exception){
        exception.printStackTrace();
        log.error("统一异常处理",exception);
        return new Result<>(exception.getErrorCode(),exception.getMessage());
    }
}
