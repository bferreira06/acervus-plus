package br.com.acervus.relatorio;

import br.com.acervus.repository.ObraRepository;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ExemplarRepository;
import org.springframework.stereotype.Component;

@Component
public class RelatorioResumidoCreator extends RelatorioCreator {

    private final ObraRepository obras;
    private final EdicaoRepository edicoes;
    private final ExemplarRepository exemplares;

    public RelatorioResumidoCreator(
            ObraRepository obras,
            EdicaoRepository edicoes,
            ExemplarRepository exemplares) {
        this.obras = obras;
        this.edicoes = edicoes;
        this.exemplares = exemplares;
    }

    @Override
    protected RelatorioStrategy criarEstrategia() {
        return new RelatorioResumidoStrategy(obras, edicoes, exemplares);
    }
}
