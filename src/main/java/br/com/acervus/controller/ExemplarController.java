package br.com.acervus.controller;

import br.com.acervus.model.Exemplar;
import br.com.acervus.service.ExemplarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edicoes/{edicaoId}/exemplares")
public class ExemplarController {

    private final ExemplarService exemplarService;

    public ExemplarController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @PostMapping
    public Exemplar cadastrar(@PathVariable Long edicaoId,
                              @RequestBody Exemplar exemplar) {
        return exemplarService.cadastrar(edicaoId, exemplar);
    }

    @GetMapping
    public List<Exemplar> listarPorEdicao(@PathVariable Long edicaoId) {
        return exemplarService.listarPorEdicao(edicaoId);
    }

    @GetMapping("/{id}")
    public Exemplar buscarPorId(@PathVariable Long id) {
        return exemplarService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Exemplar atualizar(@PathVariable Long id,
                              @RequestBody Exemplar exemplar) {
        return exemplarService.atualizar(id, exemplar);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        exemplarService.excluir(id);
    }
}