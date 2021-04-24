package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.NotActiveException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ClientMember extends Time implements Serializable , UserDetails {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private String mobile;

    private String gender;

    private String age;

    private String helloDealServiceYn;

    private String locationServiceYn;

    private String marketingServiceYn;

    private Double longitude;

    private Double latitude;

    private String nickName;

    private String profileImagePath;

    private String socialId;

    private String socialType;

    @Column(columnDefinition = "varchar(2000) null comment '디바이스 토큰'")
    private String deviceToken;

    @Column(columnDefinition = "varchar(2000) null comment '소셜 토큰'")
    private String token;

    private String certificationYn;

    private String privacyYn;

    private String favoriteAlertYn;

    private String replyAlertYn;

    private String reviewWriteAlertYn;

    private String useYn;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private List<Role> clientRoles = new ArrayList<>();

    public void verifyExist() {
        if (getId() == 0)
            throw new NoSuchElementException("아이디 또는 비밀번호가 잘못 되었습니다.");
    }

    public void verifyUseYn(){
        if (getUseYn().equals("N"))
            throw new NoSuchElementException("사용이 중지된 아이디 입니다.");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.clientRoles;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
