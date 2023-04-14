package br.com.fiap.challengerest.controllers;


import br.com.fiap.challengerest.model.Pergunta;
import br.com.fiap.challengerest.services.PerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<List<Pergunta>> findAll (){
        List<Pergunta> perguntas = perguntaService.findAll();
        return new ResponseEntity<>(perguntas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pergunta> save(@RequestBody Pergunta pergunta){
        Pergunta savedPergunta = perguntaService.save(pergunta);
        return new ResponseEntity<>(savedPergunta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pergunta> deleteById(@PathVariable Long id){
        perguntaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
