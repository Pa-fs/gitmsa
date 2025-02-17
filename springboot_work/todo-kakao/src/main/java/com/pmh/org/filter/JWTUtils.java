package com.pmh.org.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JWTUtils {

    private String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz01234567890";

    public String createJwt(String email) {
        log.info("SECRET_KEY : {}", SECRET_KEY);
        String jwt = Jwts.builder()
                .claim("email",email)
//                .claim("role",role)
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
//                .expiration(new Date(System.currentTimeMillis() + 1000)) // 1초 지나면 유효시간 없음...
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                .compact();
        return jwt;
    }

    public String getEmailFromJwt(String jwt){
        SecretKey secretKey
                = new SecretKeySpec(SECRET_KEY.getBytes(),
                Jwts.SIG.HS256.key().build().getAlgorithm());
        Jws<Claims> cliams = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(jwt);

        return cliams.getPayload().get("email").toString();
    }




}
