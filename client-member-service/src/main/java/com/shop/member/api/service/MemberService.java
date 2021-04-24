package com.shop.member.api.service;


import com.shop.entity.ClientMember;
import com.shop.member.api.dto.member.TokenDTO;


public interface MemberService {
    ClientMember save(ClientMember clientMember);

    ClientMember memberLogin(TokenDTO tokenDTO);
}
