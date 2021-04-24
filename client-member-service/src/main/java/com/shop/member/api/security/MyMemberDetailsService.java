package com.shop.member.api.security;

import com.shop.entity.ClientMember;
import com.shop.repository.ClientMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyMemberDetailsService implements UserDetailsService {
    private final ClientMemberRepository clientMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        ClientMember member = clientMemberRepository.findByEmail(email).orElseGet(ClientMember::new);

        return new User(
                member.getEmail(),
                member.getPassword(),
                member.getAuthorities()
        );
    }
}
