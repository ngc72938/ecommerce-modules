package com.shop.member.api.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "이메일 중복체크 PARAM DTO")
public class CheckEmailDTO {
    @ApiModelProperty(value = "email", example = "test@test.co.kr", required = true)
    @Email
    private String email;
}
