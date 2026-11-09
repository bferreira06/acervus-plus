
package br.com.acervus.controller;

import br.com.acervus.model.Obra;
import br.com.acervus.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @PostMapping
    public Obra cadastrar(@Valid @RequestBody Obra obra) {
        return obraService.cadastrar(obra);
    }

    @GetMapping
    public List<Obra> listarTodas() {
        return obraService.listarTodas();
    }

    @GetMapping("/{id}")
    public Obra buscarPorId(@PathVariable Long id) {
        return obraService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Obra atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Obra obra) {
        return obraService.atualizar(id, obra);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        obraService.excluir(id);
    }
}
