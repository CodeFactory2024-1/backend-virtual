package com.backauth.presentacion.controller;

import com.backauth.aplicacion.AuthService;
import com.backauth.aplicacion.ServiceUser;
import com.backauth.core.dominio.AuthResponse;
import com.backauth.core.dominio.LoginRequest;
import com.backauth.core.dominio.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final ServiceUser serviceUser;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        if (serviceUser.getUserEmail(request.getUserEmail()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else if (serviceUser.getUser(request.getUserId()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else
        {
            return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
        }
    }
}
