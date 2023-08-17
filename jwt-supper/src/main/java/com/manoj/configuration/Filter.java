package com.manoj.configuration;

import com.manoj.servce.MyUserServiceDetails;
import com.manoj.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
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
public class Filter extends OncePerRequestFilter {
    @Autowired
    private MyUserServiceDetails myUserServiceDetails;
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String HEADER = request.getHeader("Authorization");
      String s=  request.getRemoteHost();
        System.out.println(s+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        String jwtToken = null;
        String userName = null;

        if (HEADER != null && HEADER.startsWith("earer ")) {

            jwtToken = HEADER.substring(6);
            try {
                userName = jwtUtil.getUserNameFromToken(jwtToken);

            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("enable to get JWT Token");
            } catch (ExpiredJwtException expiredJwtException) {


                System.out.println("token is expired");
            }
        }else {

            System.out.println(" jwt token doesnot start with Bearer");
        }
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println(" no entry 2");
            UserDetails userDetails = myUserServiceDetails.loadUserByUsername(userName);
            if (jwtUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken
                                (userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.
                        setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);

    }
}
