package br.com.fiap.challengeresttest.repositories;

import br.com.fiap.challengerest.model.Usuario;

import br.com.fiap.challengerest.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Optional;

import static org.junit.Assert.fail;

/**
 * Explicação sobre @SpringBootTest:
 * <p>
 * Garante que o teste será executado com o contexto do Spring,
 * sem ter que configurar manualmente as dependências e variáveis de ambiente.
 * Com essa Annotation não é necessário criar um 'EntityManagerFactory'.
 * <p>
 * Explicação sobre @Transactional:
 * <p>
 * Garante que toda a transação feita no banco de dados será desfeita ao final do teste
 *
 * @author Pedro
 */


@SpringBootConfiguration
@SpringJUnitConfig
@DataJpaTest
@Transactional
@Import(TestConfigRepository.class)
public class UsuarioRepositoryTest {

    private final UsuarioRepository usuarioRepository;

    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

//    @BeforeEach
//    public void setUp() {
//        Usuario usuario1 = new Usuario();
//        usuario1.setNome("Pedro");
//        usuario1.setSenha("Pedro12345");
//        usuario1.setCpf("12345678910");
//        Calendar cal1 = Calendar.getInstance();
//        cal1.set(Calendar.YEAR, 2004);
//        cal1.set(Calendar.MONTH, Calendar.JUNE);
//        cal1.set(Calendar.DAY_OF_MONTH, 3);
//        usuario1.setDataNascimento(cal1);
//
//        usuarioRepository.save(usuario1);
//    }


    @Test
    public void testCreateUsuario() {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome("Daniel Lucas");
            usuario.setSenha("DL12345");
            usuario.setCpf("12345678910");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2001);
            cal.set(Calendar.MONTH, Calendar.JUNE);
            cal.set(Calendar.DAY_OF_MONTH, 2);
            usuario.setDataNascimento(cal);

            // Salvando usuário no banco de dados (Persistência)
            // Esse método funciona igual o "persist" e vem do Spring Data JPA.

            usuarioRepository.save(usuario);

            // Trazendo o valor salvo no banco de dados
            Optional<Usuario> persistedUsuario = usuarioRepository.findById(usuario.getId());

            // Confirmando se o valor salvo é igual ao valor criado
            Assertions.assertTrue(persistedUsuario.isPresent());
            Assertions.assertEquals(usuario.getId(), persistedUsuario.get().getId());
            Assertions.assertEquals(usuario.getNome(), persistedUsuario.get().getNome());
            Assertions.assertEquals(usuario.getSenha(), persistedUsuario.get().getSenha());
            Assertions.assertEquals(usuario.getCpf(), persistedUsuario.get().getCpf());
            Assertions.assertEquals(usuario.getDataNascimento(), persistedUsuario.get().getDataNascimento());
        } catch (NullPointerException e) {
            e.printStackTrace();
            fail("NullPointerException thrown, check if usuarioRepository is properly initialized");
        }
    }
}
