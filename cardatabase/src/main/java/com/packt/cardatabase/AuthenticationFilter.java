package com.packt.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.packt.cardatabase.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, java.io.IOException { 
			//Authorization 헤더에서 토큰을 가져옴
			String jws = request.getHeader(HttpHeaders.AUTHORIZATION);
			if(jws != null) {
				// 토큰을 확인하고 사용자를 얻음
				System.out.println("시작 전 :" + jws);
				String user = jwtService.getAuthUser(request);
				System.out.println("시작 후");
				// 인증
				Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, java.util.Collections.emptyList());
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
			filterChain.doFilter(request, response);
		
	}
	
}
