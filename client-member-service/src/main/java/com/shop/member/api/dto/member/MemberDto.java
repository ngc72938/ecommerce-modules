package com.shop.member.api.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "진행중인 프로모션 리스트 DTO")
public class MemberDto {
    @ApiModelProperty(value = "email", example = "test@imform.co.kr", required = true)
    @NotBlank
    @Email
    private String email;

    @ApiModelProperty(value = "password", example = "**********", required = true)
    @NotBlank
    private String password;

    @ApiModelProperty(value = "mobile", example = "010-1234-5678")
    private String mobile;

    @ApiModelProperty(value = "gender", example = "male")
    private String gender;

    @ApiModelProperty(value = "age", example = "20")
    private int age;

    @NotBlank
    @ApiModelProperty(value = "helloDealServiceYn", example = "Y", required = true)
    private String helloDealServiceYn;

    @NotBlank
    @ApiModelProperty(value = "locationServiceYn", example = "Y", required = true)
    private String locationServiceYn;

    @NotBlank
    @ApiModelProperty(value = "marketingServiceYn", example = "Y", required = true)
    private String marketingServiceYn;

    @ApiModelProperty(value = "socialType", example = "")
    private String socialType;

    @ApiModelProperty(value = "socialId", example = "")
    private String socialId;

    @ApiModelProperty(value = "type", example = "")
    private String type;

    @NotBlank
    @ApiModelProperty(value = "certificationYn", example = "Y", required = true)
    private String certificationYn;

    @NotBlank
    @ApiModelProperty(value = "useYn", example = "Y", required = true)
    private String useYn;
}
