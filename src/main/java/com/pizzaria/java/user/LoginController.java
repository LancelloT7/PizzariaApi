package com.pizzaria.java.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<?> loginValidation(@RequestBody @Valid CredenciaisDTO credenciaisDTO ){
        UsernamePasswordAuthenticationToken token  = new UsernamePasswordAuthenticationToken(credenciaisDTO.getUsername(),
                credenciaisDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
