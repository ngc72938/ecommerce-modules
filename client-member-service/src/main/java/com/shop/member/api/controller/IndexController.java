package com.shop.member.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@RestController
public class IndexController {
    private HashMap<String, Object> returnMap = null;

    @PostMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HashMap<String, Object>> getIndex(){

        returnMap = new HashMap<>();
        returnMap.put("payload","test");
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }
}
