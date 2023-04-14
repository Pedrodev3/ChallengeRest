package br.com.fiap.challengerest.services;


import br.com.fiap.challengerest.model.Pergunta;
import br.com.fiap.challengerest.repositories.PerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository){ this.perguntaRepository = perguntaRepository; }

    public List<Pergunta> findAll(){
        return perguntaRepository.findAll();
    }

    public Pergunta save(Pergunta pergunta){ perguntaRepository.save(pergunta);
        return pergunta;
    }

    public void deleteById(Long id){ perguntaRepository.deleteById(id); }
}
