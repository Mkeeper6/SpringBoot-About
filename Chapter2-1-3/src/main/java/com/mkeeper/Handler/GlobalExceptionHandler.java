package com.mkeeper.Handler;

import com.mkeeper.common.R;
import com.mkeeper.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 如果要验证BadException 和 UglyException请注释@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public R businessExceptionHandler(BusinessException exception) {
        return R.isFail(exception);
    }

    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception exception) {
        return R.isFail(exception);
    }
}
