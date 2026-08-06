package com.prverse.prverse.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Create Signing Key
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generate JWT
    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()

                .setSubject(userDetails.getUsername())

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(System.currentTimeMillis() + jwtExpiration)
                )

                .signWith(getSignKey(), SignatureAlgorithm.HS256)

                .compact();

    }

    // Extract Username
    public String extractUsername(String token) {

        return extractClaims(token).getSubject();

    }

    // Validate Token
    public boolean isTokenValid(String token, UserDetails userDetails) {

        String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);

    }

    // Check Expiration
    private boolean isTokenExpired(String token) {

        return extractClaims(token)

                .getExpiration()

                .before(new Date());

    }

    // Extract Claims
    private Claims extractClaims(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(getSignKey())

                .build()

                .parseClaimsJws(token)

                .getBody();

    }

}