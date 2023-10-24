package com.nadhem.users.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nadhem.users.dto.AuthenticationRequest;
import com.nadhem.users.dto.AuthenticationResponse;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(   @RequestBody AuthenticationRequest request) {
        
        return ResponseEntity.ok(service.authenticate(request));
    }

   
}