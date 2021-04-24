package com.shop.member.api.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "일반회원 로그인 PARAM DTO")
public class TokenDTO {
    @NotBlank
    @ApiModelProperty(value = "email", example = "test@imform.co.kr", required = true)
    private String email;

    @NotBlank
    @ApiModelProperty(value = "password", example = "***********", required = true)
    private String password;

}
