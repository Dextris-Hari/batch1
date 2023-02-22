package com.dextris.dextris.configuration;

import com.dextris.dextris.service.impl.JwtService;
import com.dextris.dextris.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtService jwtService;

    public JwtRequestFilter() {
        System.out.println(this.getClass().getSimpleName());

    }

    public JwtRequestFilter(JwtUtil jwtUtil, JwtService jwtService) {
        System.out.println(this.getClass().getSimpleName()+ "inside JwtRequestFilter para");
        this.jwtUtil = jwtUtil;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println(" inside doFilterInternal  ");
        final String HEADER = request.getHeader("Authorization");
        System.out.println(HEADER);
        String jwtToken = null;
        String userName = null;
        if (HEADER != null && HEADER.startsWith("Bearer ")) {
            System.out.println(" no entry 1");

            jwtToken = HEADER.substring(7);
            try {
                userName = jwtUtil.getUserNameFromToken(jwtToken);

            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("enable to get JWT Token");
            } catch (ExpiredJwtException expiredJwtException) {


                System.out.println("token is expired");
            }

        } else {

            System.out.println(" jwt token doesnot start with Bearer");
        }
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println(" no entry 2");
            UserDetails userDetails = jwtService.loadUserByUsername(userName);
            if (jwtUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        System.out.println(" yes i find it");
        filterChain.doFilter(request, response);


    }
}
