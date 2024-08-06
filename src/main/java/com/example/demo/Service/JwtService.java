package com.example.demo.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import com.example.demo.Entite.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {

    private final String SECRET_KEY = "ad54f2fa4802062b017f596597d0bea0e770558513c8cea77778512bb0028248";

    // public String extr
    public <T> T extractClaims(String token, Function<Claims, T> resolver){
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts
            .parser()
            .verifyWith(getSignatureCle())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    public String generationToken(User user){
        String token = Jwts
            .builder()
            .subject(user.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+ 24*60*60*1000))
            .signWith(getSignatureCle())
            .compact();

        return token;
    }

    private SecretKey getSignatureCle() {
        byte[] keybite = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keybite);
    }
}
