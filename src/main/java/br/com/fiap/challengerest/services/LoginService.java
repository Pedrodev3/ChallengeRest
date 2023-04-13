package br.com.fiap.challengerest.services;


import br.com.fiap.challengerest.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public boolean login(String username, String password) {
        return usuarioRepository.existsByNomeAndSenha(username, password);
    }
}
