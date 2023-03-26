package com.GDSC.ConsumerOptimization.Controller;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.GDSC.ConsumerOptimization.Dto.AuthResponseDto;
import com.GDSC.ConsumerOptimization.Dto.RegisterDto;
import com.GDSC.ConsumerOptimization.Entity.User.Roles;
import com.GDSC.ConsumerOptimization.Entity.User.User;
import com.GDSC.ConsumerOptimization.Repository.UserRepo;
import com.GDSC.ConsumerOptimization.Security.JwtGenerator;
import org.apache.http.protocol.HTTP;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(path = "api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @NotNull RegisterDto registerDto)
    {
        if(userRepo.existsByUsername(registerDto.getUsername()))
        {
            return new ResponseEntity<>("Username is taken !",HttpStatus.BAD_REQUEST);
        }
        else
        {
            User user = new User();
            user.setUsername(registerDto.getUsername());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            user.setRoles(Collections.singletonList(Roles.USER));
            userRepo.save(user);
            return new ResponseEntity<>("User Registered Successfully !",HttpStatus.CREATED);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @NotNull RegisterDto loginDto)
    {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
    }




}












