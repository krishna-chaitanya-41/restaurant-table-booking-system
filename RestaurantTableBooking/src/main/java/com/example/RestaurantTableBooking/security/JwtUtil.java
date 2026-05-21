package com.example.RestaurantTableBooking.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil{
    private String secretKey = "mnbvcxzlkjhgfdsapoiuytrewq0987654321";
    public String generateToken(String email){
        return Jwts.builder().setSubject(email).
                setIssuedAt(new Date()).
                setExpiration(new Date(System.currentTimeMillis()+1000*60*60)).
                signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    public String extractEmail(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        String email=extractEmail(token);
        return email.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey())
                .build().parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());
    }
    private Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
