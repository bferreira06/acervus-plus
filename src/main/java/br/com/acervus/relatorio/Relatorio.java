package br.com.acervus.relatorio;

public class Relatorio {

    private String titulo;
    private long totalObras;
    private long totalEdicoes;
    private long totalExemplares;

    private Relatorio() {}

    public String getTitulo() { return titulo; }
    public long getTotalObras() { return totalObras; }
    public long getTotalEdicoes() { return totalEdicoes; }
    public long getTotalExemplares() { return totalExemplares; }

    public static class Builder {
        private final Relatorio relatorio = new Relatorio();

        public Builder titulo(String titulo) {
            relatorio.titulo = titulo;
            return this;
        }

        public Builder totalObras(long total) {
            relatorio.totalObras = total;
            return this;
        }

        public Builder totalEdicoes(long total) {
            relatorio.totalEdicoes = total;
            return this;
        }

        public Builder totalExemplares(long total) {
            relatorio.totalExemplares = total;
            return this;
        }

        public Relatorio build() {
            return relatorio;
        }
    }
}