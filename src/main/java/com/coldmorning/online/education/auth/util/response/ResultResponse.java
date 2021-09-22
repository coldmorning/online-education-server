package com.coldmorning.online.education.auth.util.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResultResponse<T> {


    private String msg;
    private  String  code;
    public  static HttpStatus httpStatus = HttpStatus.OK;
    private T data;



    public ResultResponse(ResultCode resultCode){
        this.msg = resultCode.msg;
        this.code = resultCode.code;
        this.httpStatus = resultCode.httpStatus;
    }

    public ResultResponse (T data,ResultCode resultCode){
        this.data = data;
        this.msg = resultCode.msg;
        this.code = resultCode.code;
        this.httpStatus = resultCode.httpStatus;
    }

    public  static  <T>  ResultResponse<T> error(ResultCode code,T data) {
        return new  ResultResponse(data, code);

    }
    public static  <T> ResultResponse<T> sucessful(ResultCode code,T data) {
        return new  ResultResponse(data,code);
    }

    public  static  <T>  ResultResponse<T> error(ResultCode code) {
        return new  ResultResponse(code);

    }
    public static  <T> ResultResponse<T> sucessful(ResultCode code) {
        return new  ResultResponse(code);
    }

}
