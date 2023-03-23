package com.app.web.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCES_TOKEN_SECRET = "4UTF4423BGASzasAAe221Vd";
    private final static  Long ACCES_TOKEN_VALIDITY_SECONDS = 2_592_000l;

    public static  String createTOKEN (String NombreCompleto, String email){

        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("NombreCompleto" , NombreCompleto);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){

       try {
           Claims claims = Jwts.parserBuilder()
                   .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();


           String Correo = claims.getSubject();
           return new UsernamePasswordAuthenticationToken(Correo,null, Collections.emptyList());
       }catch (JwtException e){
           return null;
       }



    }


}
