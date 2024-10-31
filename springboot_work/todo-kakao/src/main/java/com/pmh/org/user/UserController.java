package com.pmh.org.user;

import com.pmh.org.kakao.jpa.KakaoEntity;
import com.pmh.org.kakao.jpa.KakaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final KakaoRepository kakaoRepository;

    @GetMapping("info")
    public ResponseEntity<KakaoEntity> getUserInfo(
            @RequestHeader("Authorization") String token,
            @AuthenticationPrincipal UserDetails userDetails) {

        KakaoEntity kakaoEntity = kakaoRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return ResponseEntity.ok(kakaoEntity);
    }
}
