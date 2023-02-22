package com.dextris.dextris.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    public JwtAuthenticationEntryPoint() {
        System.out.println(" inside the JwtAuthenticationEntryPoint "+this.getClass().getSimpleName());
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        System.out.println(" inside the commence method ");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"UNAUTHORIZED");

    }
}
