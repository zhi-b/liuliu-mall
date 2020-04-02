package com.liuliu.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//API接口的响应结果的封装,响应结果都是JSON格式
@Getter
//带有@NonNull注解的参数的构造方法
@RequiredArgsConstructor
//将数据转为JSON格式。当值为空时，不参与JSON格式的转换
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseData<T> implements Serializable {
    //请求的状态码
    @NonNull
    private int status;
    //请求结果的消息描述
    @NonNull
    private String message;

    //响应的数据
    private Map<String,T> data = new HashMap<>();

    //
    public ResponseData putDataVal(String key, T value){
        data.put(key, value);
        return this;
    }

    public static ResponseData success(){
        return new ResponseData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public static ResponseData badRequest(){
        return new ResponseData(ResponseCode.REQUEST_BAD.getCode(),ResponseCode.REQUEST_BAD.getDesc());
    }
    public static ResponseData notFound(){
        return new ResponseData(ResponseCode.NOTFOUND.getCode(),ResponseCode.NOTFOUND.getDesc());
    }
    public static ResponseData forbidden(){
        return new ResponseData(ResponseCode.FORBIDDEN.getCode(),ResponseCode.FORBIDDEN.getDesc());
    }
    public static ResponseData serverError(){
        return new ResponseData(ResponseCode.SERVER_ERROR.getCode(),ResponseCode.SERVER_ERROR.getDesc());
    }
    public static ResponseData unauthorzed(){
        return new ResponseData(ResponseCode.UNAUTHORZED.getCode(),ResponseCode.UNAUTHORZED.getDesc());
    }
    public static ResponseData customError(){
        return new ResponseData(ResponseCode.CUSTOM_ERROR.getCode(),ResponseCode.CUSTOM_ERROR.getDesc());
    }
}
