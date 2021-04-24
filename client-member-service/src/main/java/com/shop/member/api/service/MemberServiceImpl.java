package com.shop.member.api.service;

import com.shop.entity.ClientMember;
import com.shop.entity.Role;
import com.shop.member.api.dto.member.TokenDTO;
import com.shop.member.api.exception.BusinessException;
import com.shop.repository.ClientMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final ClientMemberRepository clientMemberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientMember save(ClientMember clientMember) {
        ClientMember findMember = clientMemberRepository.findByEmail(clientMember.getEmail()).orElse(new ClientMember());
        if(findMember.getEmail() != null)
            throw new BusinessException("이미 사용중인 이메일 입니다.");

        String encryptPassword = passwordEncoder.encode(clientMember.getPassword());
        clientMember.setPassword(encryptPassword);
        clientMember.setClientRoles(Collections.singletonList(Role.CLIENT));
        clientMember.setUseYn("Y");

        return clientMemberRepository.save(clientMember);
    }

    @Override
    public ClientMember memberLogin(TokenDTO tokenDTO) {
        var clientMember = clientMemberRepository.findByEmail(tokenDTO.getEmail()).orElseGet(ClientMember::new);
        clientMember.verifyExist();
        clientMember.verifyUseYn();

        if(!passwordEncoder.matches(tokenDTO.getPassword(), clientMember.getPassword()))
            throw new BusinessException("아이디 또는 비밀번호를 확인해 주세요.");

        return clientMember;
    }

    @Override
    public ClientMember findByEmail(String email) {
        return clientMemberRepository.findByEmail(email).orElseGet(ClientMember::new);
    }


}
