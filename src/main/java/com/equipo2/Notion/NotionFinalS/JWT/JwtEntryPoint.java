package com.equipo2.Notion.NotionFinalS.JWT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Clase que comprueba si hay un token valido y sino devuelve una respuesta 401 No autorizado.
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    //ATRIBUTOS
    private final static Logger logger= LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        logger. error("Fail en el metodo commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
