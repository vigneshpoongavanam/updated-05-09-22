package com.example.apiforstudentmanagement.jwtutil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.apiforstudentmanagement.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;


    public JwtUtils() throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        keyPair = keyPairGenerator.generateKeyPair();
    }
    public String generateJwt(User payload) throws Exception {

       payload.setPassword("kamika mudiyadhu poda");

        ObjectMapper m = new ObjectMapper();
        Map<String,Object> props = m.convertValue(payload, Map.class);
        //MyBean anotherBean = m.convertValue(props, MyBean.class);

        JWTCreator.Builder tokenBuilder = JWT.create()
                .withPayload(props)
                .withExpiresAt(Date.from(Instant.now().plusSeconds(300)))
                .withIssuedAt(Date.from(Instant.now()));



        return tokenBuilder.sign(Algorithm.RSA256(((RSAPublicKey) keyPair.getPublic()), ((RSAPrivateKey) keyPair.getPrivate())));


        /*public String generateJwt(Map<String, String> payload) throws Exception {

        JWTCreator.Builder tokenBuilder = JWT.create()
                .withIssuer("admin")
                .withClaim("jti", UUID.randomUUID().toString())
                .withExpiresAt(Date.from(Instant.now().plusSeconds(300)))
                .withIssuedAt(Date.from(Instant.now()));

        payload.entrySet().forEach(action -> tokenBuilder.withClaim(action.getKey(), action.getValue()));

        return tokenBuilder.sign(Algorithm.RSA256(((RSAPublicKey) keyPair.getPublic()), ((RSAPrivateKey) keyPair.getPrivate())));
    }

*/

    }




}
