package com.coldmorning.online.education.auth.util.response;
import org.springframework.http.HttpStatus;


public enum ResultCode {


    SUCESS(ResultHttpStatus.status200,0000,"成功"),
    ERROR(ResultHttpStatus.status500,1000,"伺服器處理異常"),
    SUCESS_Login(ResultHttpStatus.status200,0000,"登入成功"),
    ERROR_Login(ResultHttpStatus.status500,1001,"登入失敗");


    public final HttpStatus httpStatus;
    public final String msg;
    public final String code;
    ResultCode(HttpStatus httpStatus,int code,String msg){
        this.httpStatus = httpStatus;
        this.code =  httpStatus+"_"+code;
        this.msg = msg;
    }

}
