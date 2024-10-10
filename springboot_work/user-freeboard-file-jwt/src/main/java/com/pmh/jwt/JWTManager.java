package com.pmh.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
@Component
public class JWTManager {
    // JWT 생성
    public String createJWT(String secrekey){
        String jwt = Jwts.builder()
                .claim("email","aaa@naver.com")
                .claim("role","ADMIN")
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(secrekey.getBytes()))
                .compact();
        return jwt;
    }
    // JWT 유효한지 검사 .... 우리가 설정한 비밀번호까지...
    public String validJWT(String jwt, String key){
        try {
            SecretKey secretKey
                    = new SecretKeySpec(key.getBytes(),
                    Jwts.SIG.HS256.key().build().getAlgorithm());
            Jws<Claims> claims = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt);

            // 만약에 유효시간이 지났으면.. JWT 사용 못하게 하기 위한 설정
            claims.getPayload().getExpiration().before(new Date());
            return "true";
        }catch (Exception e){
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        return "false";
    }
}