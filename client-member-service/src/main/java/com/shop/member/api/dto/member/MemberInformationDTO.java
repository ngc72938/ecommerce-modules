package com.shop.member.api.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "회원정보 가져오기 DTO")
public class MemberInformationDTO {
    @ApiModelProperty(value = "memberId", example = "1", required = true)
    private long memberId;

    @ApiModelProperty(value = "email", example = "test@imform.co.kr", required = true)
    private String email;

    @ApiModelProperty(value = "nickName", example = "아이엠폼테스트", required = true)
    private String nickName;

    @ApiModelProperty(value = "age", example = "23", required = true)
    private String age;

    @ApiModelProperty(value = "gender", example = "male", required = true)
    private String gender;

    @ApiModelProperty(value = "birthDay", example = "2000-05-05", required = true)
    private LocalDate birthDay;

    @ApiModelProperty(value = "mobile", example = "010-1234-5678", required = true)
    private String mobile;

    @ApiModelProperty(value = "profileImagePath", example = "https://hellodeal-client-api.s3.ap-northeast-2.amazonaws.com/profileImage/2020/07/23/cdff2e5a-955c-4dea-826a-de8feda1155b-20200723111839-Screenshot_2017-08-01-21-30-15.png", required = true)
    private String profileImagePath;

    @ApiModelProperty(value = "favoriteAlertYn", example = "Y", required = true)
    private String favoriteAlertYn;

    @ApiModelProperty(value = "replyAlertYn", example = "Y", required = true)
    private String replyAlertYn;

    @ApiModelProperty(value = "reviewWriteAlertYn", example = "Y", required = true)
    private String reviewWriteAlertYn;

    @ApiModelProperty(value = "couponCount", example = "2", required = true)
    private long couponCount;

    @ApiModelProperty(value = "reviewCount", example = "4", required = true)
    private long reviewCount;

    @ApiModelProperty(value = "favoriteCount", example = "5", required = true)
    private long favoriteCount;

    @ApiModelProperty(value = "messageCount", example = "21", required = true)
    private long messageCount;

    @ApiModelProperty(value = "storeBoardCount", example = "11", required = true)
    private long storeBoardCount;

    @ApiModelProperty(value = "socialType", example = "apple", required = true)
    private String socialType;

}
