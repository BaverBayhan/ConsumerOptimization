package com.GDSC.ConsumerOptimization.Security;

import com.GDSC.ConsumerOptimization.Service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtGeneratorTest {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    JwtGenerator generator;

    @Test
    void testJWT()
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername("baver");

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()));

        String token = generator.generateToken(authentication);
        System.err.println(token);
    }

}