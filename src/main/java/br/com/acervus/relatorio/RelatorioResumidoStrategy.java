package br.com.acervus.relatorio;

import br.com.acervus.repository.ObraRepository;
import br.com.acervus.repository.ExemplarRepository;

public class RelatorioResumidoStrategy implements RelatorioStrategy {

    private final ObraRepository obras;
    private final ExemplarRepository exemplares;

    public RelatorioResumidoStrategy(
            ObraRepository obras,
            ExemplarRepository exemplares) {
        this.obras = obras;
        this.exemplares = exemplares;
    }

    @Override
    public Relatorio gerar() {
        return new Relatorio.Builder()
                .titulo("Resumo do acervo Acervus+")
                .totalObras(obras.count())
                .totalExemplares(exemplares.count())
                .build();
    }
}