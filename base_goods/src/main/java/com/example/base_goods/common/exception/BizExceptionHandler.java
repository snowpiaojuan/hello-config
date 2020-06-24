package com.example.base_goods.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理
 * @author vicky
 * @date 2019/5/27
 */
@ControllerAdvice
@ResponseBody
public class BizExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        apiError.setMsg("参数校验异常,请检查请求参数:" + ex.getBindingResult().getFieldError().getField()
                + ", " + ex.getBindingResult().getFieldError().getDefaultMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        apiError.setMsg(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
                ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> runtimeException(RuntimeException ex) {
        ex.printStackTrace();
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), getStackMsg(ex)));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> myHandleNoHandlerFoundException(NoHandlerFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());
        apiError.setMsg("url错误,无对应方法:" + ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex) {
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException ex) {
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> unknownException(Exception ex) {
        ex.printStackTrace();
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.BAD_REQUEST.value(), getStackMsg(ex)));
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<Object> findBizException(BizException ex) {
        ApiError apiError = new ApiError(HttpStatus.OK, ex.getMessageCode().getCode(), ex.getMessageCode().getMsg());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        //假如是业务异常，warn.否则 error
        if (apiError.getCode() > 100000000) {
            log.warn(apiError.toString());
        } else {
            log.error(apiError.toString());
        }
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    private static String getStackMsg(Exception e) {
        StringBuffer sb = new StringBuffer();
        sb.append(e + "\n");

        StackTraceElement[] stackArray = e.getStackTrace();
        int len = stackArray.length;
        if (len > 2) {
            len = 2;
        }

        for (int i = 0; i < len; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n....");
        }
        return sb.toString();
    }
}