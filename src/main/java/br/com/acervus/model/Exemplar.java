
package br.com.acervus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Exemplar{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String condicao;
    private String situacaoPosse;
    private LocalDate dataAquisicao;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "edicao_id", nullable = false)
    private Edicao edicao;

    public Exemplar() {
    }

    public Long getId() {
        return id;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getSituacaoPosse() {
        return situacaoPosse;
    }

    public void setSituacaoPosse(String situacaoPosse) {
        this.situacaoPosse = situacaoPosse;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
}
