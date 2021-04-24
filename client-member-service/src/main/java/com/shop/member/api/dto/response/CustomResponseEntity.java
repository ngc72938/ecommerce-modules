package com.shop.member.api.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class CustomResponseEntity {
    private final HashMap<String, Object> resultMap = new HashMap<>();

    private final Object result;

    public CustomResponseEntity(Object result){
        this.result = result;
    }
    public ResponseEntity<HashMap<String, Object>> getResponse(){
        resultMap.put("payload", result);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
