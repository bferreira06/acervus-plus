package br.com.acervus.controller;

import br.com.acervus.model.Edicao;
import br.com.acervus.service.EdicaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras/{obraId}/edicoes")
public class EdicaoController{

    private final EdicaoService edicaoService;

    public EdicaoController(EdicaoService edicaoService) {
        this.edicaoService = edicaoService;
    }

    @PostMapping
    public Edicao cadastrar(
            @PathVariable Long obraId,
            @RequestBody Edicao edicao) {
        return edicaoService.cadastrar(obraId, edicao);
    }

    @GetMapping
    public List<Edicao> listarPorObra(@PathVariable Long obraId) {
        return edicaoService.listarPorObra(obraId);
    }

    @GetMapping("/{id}")
    public Edicao buscarPorId(@PathVariable Long id) {
        return edicaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        edicaoService.excluir(id);
    }
}
