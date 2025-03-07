package com.samsung.jwtauthen.common;

import com.samsung.jwtauthen.model.entities.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.Date;

@Component
public class JwtUtil {
    private String secretKey = "PnFOWWYzd0ckVkpaYG56ViglYEtFUlkwMDEjJEUlL0wlbFcjX05YXmhaeHt0YjRxO0J3Rn1Xek4kal1tYDMz";

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000*60)) //60s
                .signWith(SignatureAlgorithm.HS384, secretKey)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        return (username.equalsIgnoreCase(extractUsername(token))
                && !extractExpiration(token).before(new Date()));
    }

    public String extractUsername(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

    public Date extractExpiration(String token) {
        Claims claims = extractClaims(token);
        return claims.getExpiration();
    }

    public Claims extractClaims(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims;
    }
}
