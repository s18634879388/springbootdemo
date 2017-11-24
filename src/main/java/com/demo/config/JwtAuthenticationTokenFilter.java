package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/11/17.
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * # JWT
     jwt:
     header: Authorization
     secret: mySecret
     expiration: 604800
     tokenHead: "Bearer "
     route:
     authentication:
     path: auth
     refresh: refresh
     register: "auth/register"
     */

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            final String authToken = authHeader.substring("Bearer ".length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            if (username==null){
                response.setStatus(403);
                return;
            }

            if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)){
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
//                            request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }

        }
        try {
            filterChain.doFilter(request,response);
        } catch (Exception e) {
            response.setStatus(403);
        }

    }
}
