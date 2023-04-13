package br.com.fiap.challengerest.controllers;

import br.com.fiap.challengerest.model.Usuario;
import br.com.fiap.challengerest.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) { this.loginService = loginService; }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        boolean exists = loginService.login(usuario.getNome(), usuario.getSenha());
        if (exists) {
            return ResponseEntity.ok("Authenticated");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
