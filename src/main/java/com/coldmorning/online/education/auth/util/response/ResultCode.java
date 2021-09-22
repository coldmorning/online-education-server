package com.coldmorning.online.education.auth.util.response;
import org.springframework.http.HttpStatus;


public enum ResultCode {


    SUCESS(ResultHttpStatus.status200,0000,"成功"),
    ERROR(ResultHttpStatus.status500,1000,"伺服器處理異常"),

    SUCESS_Login(ResultHttpStatus.status200,0000,"登入成功"),
    ERROR_Login(ResultHttpStatus.status500,1001,"登入失敗"),

    SUCESS_Register(ResultHttpStatus.status500,0010,"註冊成功"),
    ERROR_Register_Exist(ResultHttpStatus.status500,1011,"註冊失敗, 帳號已存在"),
    ERROR_Register_RePassword(ResultHttpStatus.status500,1012,"註冊成功, 兩次輸入密碼不同"),
    ERROR_Register_Other(ResultHttpStatus.status500,1013,"註冊失敗, 其他錯誤，請洽詢服務人員");


    public final HttpStatus httpStatus;
    public final String msg;
    public final String code;
    ResultCode(HttpStatus httpStatus,int code,String msg){
        this.httpStatus = httpStatus;
        this.code =  httpStatus+"_"+code;
        this.msg = msg;
    }

}
