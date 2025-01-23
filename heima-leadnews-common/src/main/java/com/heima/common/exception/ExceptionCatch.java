package com.heima.common.exception;


import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  //控制器增强类
@Slf4j
public class ExceptionCatch {

    /**
     * 处理不可控异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception e){
        e.printStackTrace();
        log.error("catch exception:{}",e.getMessage());

        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);//服务器内部错误
    }

    /**
     * 处理可控异常  自定义异常 runtime异常
     * @param e
     * @return 返回一个包含code,msg的ResponseResult对象
     * 控制台或日志文件会打印错误码和错误信息，客户端会收到一个 JSON 响应包含错误码和错误信息
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody//这个方法的返回值会作为 HTTP 响应体，直接返回给客户端
    public ResponseResult exception(CustomException e){
        log.error("catch exception:{}",e);//使用日志记录工具记录异常信息，便于后续调试和排查。
        return ResponseResult.errorResult(e.getAppHttpCodeEnum());
        /*
        方法具体代码
        public static ResponseResult errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getErrorMessage());
        }
        */
    }
}
