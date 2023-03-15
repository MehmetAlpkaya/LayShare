package com.LayShare.LayShare.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ApiError {
    private int status; // hata kodu

    private String message; // hatayla ilgili mesaj

    private  String path; // hatanın hangi path da olduğu

    private  long timestap= new Date().getTime(); // hatanın zamanı ms cinsinden tutar

    private Map<String,String> validationErrors; // validation hatası key string değeri string bir map tutarız
// json olarak tutulan bir response da tutulacak bu yüzden getter setterlar kullanıyoruz
    public  ApiError (int status, String message, String path) // constructer
    {
        this.status=status;
        this.message=message;
        this.path=path;

    }
}
