package br.com.acervus.relatorio;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioCompletoCreator completo;
    private final RelatorioResumidoCreator resumido;

    public RelatorioController(
            RelatorioCompletoCreator completo,
            RelatorioResumidoCreator resumido) {
        this.completo = completo;
        this.resumido = resumido;
    }

    @GetMapping("/completo")
    public Relatorio gerarCompleto() {
        return completo.gerarRelatorio();
    }

    @GetMapping("/resumido")
    public Relatorio gerarResumido() {
        return resumido.gerarRelatorio();
    }
}