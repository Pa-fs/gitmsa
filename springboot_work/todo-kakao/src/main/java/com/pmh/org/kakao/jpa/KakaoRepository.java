package com.pmh.org.kakao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KakaoRepository extends JpaRepository<KakaoEntity,Long> {
    Optional<KakaoEntity> findByEmail(String email);
}
