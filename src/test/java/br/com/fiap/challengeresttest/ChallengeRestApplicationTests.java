package br.com.fiap.challengeresttest;

import br.com.fiap.challengeresttest.repositories.UsuarioRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Component
@ExtendWith(SpringExtension.class)
public class ChallengeRestApplicationTests {

    private final UsuarioRepositoryTest usuarioRepositoryTest;

    public ChallengeRestApplicationTests(UsuarioRepositoryTest usuarioRepositoryTest) {
        this.usuarioRepositoryTest = usuarioRepositoryTest;
    }

    @BeforeEach
    public void setup() {
        // Perform any setup needed for the test
    }

    @Test
    public void testCreateUsuario() {
        usuarioRepositoryTest.testCreateUsuario();
    }
}
