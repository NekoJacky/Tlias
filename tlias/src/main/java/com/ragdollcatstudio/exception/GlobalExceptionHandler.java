/**
 * 全局异常处理
 */
package com.ragdollcatstudio.exception;

import com.ragdollcatstudio.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handler(Exception e) {
        e.printStackTrace();
        return Result.error(e.getMessage());
    }
}
