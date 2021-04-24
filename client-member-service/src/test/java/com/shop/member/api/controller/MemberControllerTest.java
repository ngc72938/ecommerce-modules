package com.shop.member.api.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.member.api.dto.member.CheckEmailDTO;
import com.shop.member.api.dto.member.MemberDTO;
import com.shop.member.api.dto.member.TokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private String authToken = "";

    private final MemberDTO memberDto =
            MemberDTO.builder()
                    .email("test@test.com")
                    .password("test")
                    .mobile("01012345678")
                    .gender("male")
                    .age(20)
                    .helloDealServiceYn("Y")
                    .locationServiceYn("Y")
                    .marketingServiceYn("Y")
                    .socialType("")
                    .socialId("")
                    .type("")
                    .certificationYn("Y")
                    .useYn("Y")
                    .build();

    @Test
    @DisplayName("클라이언트 회원생성")
    void createClientMember() throws Exception {
        String memberJson = objectMapper.writeValueAsString(memberDto);

        String result = mockMvc.perform(
            MockMvcRequestBuilders
                .post("/member/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(memberJson)
        ).andReturn().getResponse().getContentAsString();

        HashMap<String, HashMap<String,String>> resultMap = objectMapper.readValue(result, HashMap.class);

        log.info("result ::"+resultMap.entrySet().toString());

        Assertions.assertEquals("test@test.com", resultMap.get("data").get("email"));

    }

    @Test
    @DisplayName("클라이언트 회원 로그인")
    void getToken() throws Exception {
        TokenDTO tokenDTO = new TokenDTO("test@test.com", "test");
        String tokenJsonString = objectMapper.writeValueAsString(tokenDTO);

        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/member/token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tokenJsonString)
        ).andReturn().getResponse().getHeader("Authorization");

        log.info("result ::"+result);

        Assertions.assertNotNull(result);

        authToken = result;
    }

    @Test
    @DisplayName("회원 정보 가져오기")
    void getUserInformation() throws Exception {
        getToken();

        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/member/information")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",authToken)
        ).andReturn().getResponse().getContentAsString();

        HashMap<String, HashMap<String,String>> resultMap = objectMapper.readValue(result, HashMap.class);

        log.info("result ::"+resultMap.entrySet().toString());

        Assertions.assertEquals("test@test.com", resultMap.get("data").get("email"));
    }

    @Test
    @DisplayName("사용 가능한 이메일 체크")
    void check_duplicate_email() throws Exception {
        var checkEmailDTO = new CheckEmailDTO("test1@test.com");
        String jsonString = objectMapper.writeValueAsString(checkEmailDTO);

        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/member/check/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
        ).andReturn().getResponse().getContentAsString();

        log.info("result ::"+result);
    }
}
