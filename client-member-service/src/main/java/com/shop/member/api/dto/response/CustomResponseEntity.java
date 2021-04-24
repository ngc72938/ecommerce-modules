package com.shop.member.api.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class CustomResponseEntity {
    private HashMap<String, Object> resultMap;

    private Object result;

    private HttpStatus httpStatus;

    private String message;

    public CustomResponseEntity(Object result, HttpStatus httpStatus){
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public CustomResponseEntity(Object result, HttpStatus httpStatus, String message){
        this.result = result;
        this.httpStatus = httpStatus;
        this.message = message;
    }


    public ResponseEntity<HashMap<String, Object>> getResponse(){
        resultMap = new HashMap<>();
        resultMap.put("data", result);

        if(message != null)
            resultMap.put("message",message);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
