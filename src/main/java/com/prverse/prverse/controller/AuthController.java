package com.prverse.prverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.prverse.prverse.Service.UserService;
import com.prverse.prverse.dtos.LoginRequest;
import com.prverse.prverse.dtos.LoginResponse;
import com.prverse.prverse.entity.User;
import com.prverse.prverse.security.JwtService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        try {

            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getEmail(),
                                    request.getPassword()
                            )
                    );

            String token = jwtService.generateToken(
                    (UserDetails) authentication.getPrincipal()
            );

            return new LoginResponse(token);

        } catch (Exception e) {

            System.out.println("====================================");
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("====================================");

            throw e;
        }
    }
    
    @Autowired
	private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        User savedUser = userService.createNewUser(user);

        return ResponseEntity.ok(savedUser);
    }
}