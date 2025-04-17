package com.kriNad.backend.controller;

import com.kriNad.backend.DTO.LoginRequest;
import com.kriNad.backend.DTO.RegisterRequest;
import com.kriNad.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String result = authService.registerCustomer(request);
        if ("success".equals(result)) {
            return ResponseEntity.ok("customer");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String result = authService.login(request);
        switch (result) {
            case "admin": return ResponseEntity.ok("admin");
            case "agent": return ResponseEntity.ok("agent");
            case "customer": return ResponseEntity.ok("customer");
            case "Email does not exist":
            case "Invalid credentials":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
            default: return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error");
        }
    }
}
