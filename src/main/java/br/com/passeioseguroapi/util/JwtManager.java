package br.com.passeioseguroapi.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtManager {

	public static String generateToken(String cpf) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("cpf", cpf);

		return Jwts.builder().setClaims(claims).setSubject(cpf).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 864000000)).compact();
	}

	public static String validateToken(String token) {
		try {
			Claims claims = Jwts.parser().parseClaimsJws(token).getBody();
			return claims.getSubject();
		} catch (Exception e) {
			return null;
		}
	}
}
