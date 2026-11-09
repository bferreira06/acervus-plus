
package br.com.acervus.service;

import br.com.acervus.model.Obra;
import br.com.acervus.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public Obra cadastrar(Obra obra) {
        return obraRepository.save(obra);
    }

    public List<Obra> listarTodas() {
        return obraRepository.findAll();
    }

    public Obra buscarPorId(Long id) {
        return obraRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Obra não encontrada: " + id));
    }

    public Obra atualizar(Long id, Obra dados) {
        Obra obra = buscarPorId(id);
        obra.setTitulo(dados.getTitulo());
        return obraRepository.save(obra);
    }

    public void excluir(Long id) {
        Obra obra = buscarPorId(id);
        obraRepository.delete(obra);
    }
}
