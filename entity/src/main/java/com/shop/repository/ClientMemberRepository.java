package com.shop.repository;

import com.shop.entity.ClientMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientMemberRepository extends JpaRepository<ClientMember, Long> {
    Optional<ClientMember> findByEmail(String email);
}
