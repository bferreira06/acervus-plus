package br.com.acervus.relatorio;

public abstract class RelatorioCreator {

    protected abstract RelatorioStrategy criarEstrategia();

    public Relatorio gerarRelatorio() {
        RelatorioStrategy estrategia = criarEstrategia();
        return estrategia.gerar();
    }
}