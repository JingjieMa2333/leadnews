package com.heima.common.exception;

import com.heima.model.common.enums.AppHttpCodeEnum;

/*
CustomException 是一个自定义的运行时异常类，
专门用于处理特定业务逻辑中的异常情况。通过结合枚举类型 AppHttpCodeEnum，
它可以传递异常的具体信息（如错误码和描述），从而方便异常的分类和处理。
结合全局异常类使用

RuntimeException 是 Java 中的运行时异常基类，比如1. NullPointerException 2. ArrayIndexOutOfBoundsException
不需要显式捕获（即不需要 try-catch 块处理），如果抛出该异常，会直接导致程序终止。
 */
public class CustomException extends RuntimeException {

    //异常对应的枚举类
    private AppHttpCodeEnum appHttpCodeEnum;

    //当抛出CustomException 时，可以指定具体的错误信息，
    //例如：throw new CustomException(AppHttpCodeEnum.PARAM_REQUIRE);
    //PARAM_REQUIRE(500,"缺少参数"),
    public CustomException(AppHttpCodeEnum appHttpCodeEnum){
        this.appHttpCodeEnum = appHttpCodeEnum;
    }

    //提供了 getAppHttpCodeEnum 方法，用于获取异常对应的 AppHttpCodeEnum 枚举值。
    //使用这个方法，异常处理代码可以轻松获取错误的详细信息，例如：
    /*
    try {
        throw new CustomException(AppHttpCodeEnum.PARAM_ERROR);
    } catch (CustomException e) {
        System.out.println("错误码：" + e.getAppHttpCodeEnum().getCode());
        System.out.println("错误信息：" + e.getAppHttpCodeEnum().getErrorMessage());
    }
    */
    public AppHttpCodeEnum getAppHttpCodeEnum() {
        return appHttpCodeEnum;
    }
}
