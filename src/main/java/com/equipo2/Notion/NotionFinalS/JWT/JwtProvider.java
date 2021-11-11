package com.equipo2.Notion.NotionFinalS.JWT;

import com.equipo2.Notion.NotionFinalS.Entities.UsuarioPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Genera el token, comprueba que este bien formado y que no esta expirado
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Component
public class JwtProvider {
    //ATRIBUTOS
    private final static Logger logger= LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    //METODOS

    /**
     * Metodo que genera el token
     * @param authentication autenticacion pasada desde algun formulario
     * @return el token construido
     */
    public String generateToken(Authentication authentication){
        //Obtenemos el usuario principal
        UsuarioPrincipal usuarioPrincipal= (UsuarioPrincipal) authentication.getPrincipal();
        //Generamos el token
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Metodo que toma el nombre de usuario del token
     * @param token token pasado
     * @return nombre de usuario
     */
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Metodo que valida el token
     * @param token token pasado
     * @return si es bueno o no el token pasado
     */
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(Exception e){

        }
        return false;
    }
}
