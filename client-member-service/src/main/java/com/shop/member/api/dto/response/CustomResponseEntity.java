package com.shop.member.api.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class CustomResponseEntity {
    private HashMap<String, Object> resultMap;

    private Object result;

    private HttpStatus httpStatus;

    public CustomResponseEntity(Object result, HttpStatus httpStatus){
        this.result = result;
        this.httpStatus = httpStatus;
    }
    public ResponseEntity<HashMap<String, Object>> getResponse(){
        resultMap = new HashMap<>();
        resultMap.put("data", result);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
