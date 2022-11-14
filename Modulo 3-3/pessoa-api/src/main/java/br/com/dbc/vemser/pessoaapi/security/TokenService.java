package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.classes.UsuarioLoginEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor

public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String getToken(UsuarioLoginEntity usuarioEntity) {
        LocalDateTime dataAtualLD = LocalDateTime.now();
        Date dataAtual = Date.from(dataAtualLD.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime dataExpLD = dataAtualLD.plusDays(Long.parseLong(expiration));
        Date dataExp = Date.from(dataExpLD.atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setIssuer("vemser-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                .setIssuedAt(dataAtual)
                .setExpiration(dataExp)
                .signWith(SignatureAlgorithm.HS256, secret) // mudar para a vm args
                .compact();
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if(token == null) {
            return null;
        }
        token = token.replace("Bearer ", "");

        Claims keys = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();


        String idLoginUsuario = keys.get(Claims.ID, String.class);

        UsernamePasswordAuthenticationToken dtoSecurityObject =
                new UsernamePasswordAuthenticationToken(idLoginUsuario,
                        null,
                        Collections.emptyList());

        return dtoSecurityObject;
    }
}
