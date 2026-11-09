package br.com.acervus.service;

import br.com.acervus.model.Edicao;
import br.com.acervus.model.Exemplar;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ExemplarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplarService {

    private final ExemplarRepository exemplarRepository;
    private final EdicaoRepository edicaoRepository;

    public ExemplarService(ExemplarRepository exemplarRepository,
                           EdicaoRepository edicaoRepository) {
        this.exemplarRepository = exemplarRepository;
        this.edicaoRepository = edicaoRepository;
    }

    public Exemplar cadastrar(Long edicaoId, Exemplar exemplar) {
        Edicao edicao = edicaoRepository.findById(edicaoId)
                .orElseThrow(() -> new RuntimeException("Edição não encontrada: " + edicaoId));

        exemplar.setEdicao(edicao);
        return exemplarRepository.save(exemplar);
    }

    public List<Exemplar> listarPorEdicao(Long edicaoId) {
        if (!edicaoRepository.existsById(edicaoId)) {
            throw new RuntimeException("Edição não encontrada: " + edicaoId);
        }
        return exemplarRepository.findByEdicaoId(edicaoId);
    }

    public Exemplar buscarPorId(Long id) {
        return exemplarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemplar não encontrado: " + id));
    }

    public Exemplar atualizar(Long id, Exemplar dados) {
        Exemplar exemplar = buscarPorId(id);

        exemplar.setCondicao(dados.getCondicao());
        exemplar.setSituacaoPosse(dados.getSituacaoPosse());
        exemplar.setDataAquisicao(dados.getDataAquisicao());
        exemplar.setObservacoes(dados.getObservacoes());

        return exemplarRepository.save(exemplar);
    }

    public void excluir(Long id) {
        exemplarRepository.delete(buscarPorId(id));
    }
}