package com.elcom.library.security;

import com.elcom.library.service.impl.user.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
    Class support:
    - Generate JWT from username, date, expiration, secret,...
    - Parse JWT, get username in JWT
    - Validate JWT
 */

@Component
public class JwtUtils {
    @Value("${elcom.app.jwtSecret}")
    private String jwtSecret;

    @Value("${elcom.app.jwtExpirationMs}")
    private int jwtExp;

    @Value("${elcom.app.jwtCookieName}")
    private String jwtCookie;


    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    // Tạo token từ username trả về client
    public String generateToken(UserDetailsImpl userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExp))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }


    public String getJwtFromRequest(HttpServletRequest requets){
        String bearerToken = requets.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e){
        }
        return false;

    }
}

