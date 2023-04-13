package br.com.fiap.challengerest.services;

import br.com.fiap.challengerest.model.Usuario;
import br.com.fiap.challengerest.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(usuario1 -> {
            usuario1.setNome(usuario.getNome());
            usuario1.setSenha(usuario.getSenha());
            usuario1.setCpf(usuario.getCpf());
            usuario1.setDataNascimento(usuario.getDataNascimento());
            return usuarioRepository.save(usuario1);
        }).orElse(null);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
