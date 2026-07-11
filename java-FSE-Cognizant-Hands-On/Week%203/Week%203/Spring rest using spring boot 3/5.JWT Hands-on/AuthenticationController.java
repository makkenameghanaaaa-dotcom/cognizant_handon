package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.util.JwtUtil;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        String encoded = authHeader.substring(6);

        byte[] decodedBytes = Base64.getDecoder().decode(encoded);

        String decoded = new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.debug("Decoded Credentials : {}", decoded);

        String[] values = decoded.split(":");

        String username = values[0];
        String password = values[1];

        LOGGER.debug("Username : {}", username);
        LOGGER.debug("Password : {}", password);

        Map<String, String> map = new HashMap<>();

        String token = JwtUtil.generateToken(username);

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }
}
