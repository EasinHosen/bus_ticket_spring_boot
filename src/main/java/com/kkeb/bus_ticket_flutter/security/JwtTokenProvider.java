package com.kkeb.bus_ticket_flutter.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.kkeb.bus_ticket_flutter.models.ReservationAPIException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecretKey; 

     @Value("${app-jwt-expiration-milliseconds}")
    private Long expiration;

    public String generateToken(Authentication authentication){
        String userName = authentication.getName();
        Date expireDate = new Date(new Date().getTime()+expiration);

        return Jwts.builder()
        .setSubject(userName)
        .setIssuedAt(new Date())
        .setExpiration(expireDate)
        .signWith(key())
        .compact();
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretKey));
    }

    public String getUserName(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody(); 
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (MalformedJwtException e) {
            throw new ReservationAPIException(HttpStatus.BAD_REQUEST, "Invalid token");
        }catch (ExpiredJwtException e) {
            throw new ReservationAPIException(HttpStatus.BAD_REQUEST, "Token expired");
        }catch (UnsupportedJwtException e) {
            throw new ReservationAPIException(HttpStatus.BAD_REQUEST, "Unsupported token");
        }catch (IllegalArgumentException e) {
            throw new ReservationAPIException(HttpStatus.BAD_REQUEST, "Invalid argument");
        }
    }
}
