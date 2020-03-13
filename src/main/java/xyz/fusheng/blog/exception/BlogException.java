/**
 * @FileName: BlogException
 * @Author: fusheng
 * @Date: 2020/3/11 10:43
 * Description:
 */
package xyz.fusheng.blog.exception;

import lombok.Getter;
import xyz.fusheng.blog.enums.ResultEnum;


@Getter
public class BlogException extends RuntimeException {

    /**
     * RuntimeException 运行时异常：是那些可能在 Java 虚拟机正常运行期间抛出的异常的超类。
     * 可能在执行方法期间抛出但未被捕获的RuntimeException 的任何子类都无需在 throws 子句中进行声明。
     * 它是Exception的子类。
     */

    private Integer errorCode = ResultEnum.ERROR.getCode();

    public BlogException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }

    public BlogException(ResultEnum resultEnum, Throwable throwable) {
        super(resultEnum.getMsg(), throwable);
        this.errorCode = resultEnum.getCode();
    }

    public BlogException(Integer errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BlogException(String msg) {
        super(msg);
    }

    public BlogException(Throwable throwable) {
        super(throwable);
    }

    public BlogException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

}
