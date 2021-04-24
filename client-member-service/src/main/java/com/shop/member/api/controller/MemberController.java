package com.shop.member.api.controller;

import com.shop.entity.ClientMember;
import com.shop.entity.Role;
import com.shop.member.api.dto.member.MemberDto;
import com.shop.member.api.dto.member.TokenDTO;
import com.shop.member.api.dto.response.CustomResponseEntity;
import com.shop.member.api.security.JwtTokenProvider;
import com.shop.member.api.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final ModelMapper modelMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "일반 회원가입", notes = "일반 회원가입", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "회원 가입 완료", response = String.class)})
    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HashMap<String, Object>> createClientMember(@RequestBody @Valid MemberDto memberDto){
        var clientMember = modelMapper.map(memberDto, ClientMember.class);

        var savedMember = memberService.save(clientMember);

        return new CustomResponseEntity(savedMember, HttpStatus.OK).getResponse();
    }

    @ApiOperation(value = "일반 로그인", notes = "일반 회원 로그인", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "로그인 성공", response = String.class)})
    @PostMapping(path = "/token", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HashMap<String, Object>> getToken(@RequestBody @Valid TokenDTO tokenDTO, HttpServletResponse response) {
        ClientMember member = memberService.memberLogin(tokenDTO);

        String token = jwtTokenProvider.createToken(tokenDTO.getEmail(), member.getId(), (List<Role>) member.getAuthorities());
        response.setHeader("Authorization", token);

        return new CustomResponseEntity(member, HttpStatus.OK).getResponse();
    }
}
