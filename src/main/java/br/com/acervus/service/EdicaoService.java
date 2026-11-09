
package br.com.acervus.service;

import br.com.acervus.model.Edicao;
import br.com.acervus.model.Obra;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdicaoService{

    private final EdicaoRepository edicaoRepository;
    private final ObraRepository obraRepository;

    public EdicaoService(
            EdicaoRepository edicaoRepository,
            ObraRepository obraRepository) {
        this.edicaoRepository = edicaoRepository;
        this.obraRepository = obraRepository;
    }

    public Edicao cadastrar(Long obraId, Edicao edicao) {
        Obra obra = obraRepository.findById(obraId)
                .orElseThrow(() ->
                        new RuntimeException("Obra não encontrada: " + obraId));

        edicao.setObra(obra);
        return edicaoRepository.save(edicao);
    }

    public List<Edicao> listarPorObra(Long obraId) {
        if (!obraRepository.existsById(obraId)) {
            throw new RuntimeException("Obra não encontrada: " + obraId);
        }

        return edicaoRepository.findByObraId(obraId);
    }

    public Edicao buscarPorId(Long id) {
        return edicaoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Edição não encontrada: " + id));
    }

    public void excluir(Long id) {
        Edicao edicao = buscarPorId(id);
        edicaoRepository.delete(edicao);
    }
}
