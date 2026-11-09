package br.com.acervus.repository;

import br.com.acervus.model.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdicaoRepository
        extends JpaRepository<Edicao, Long> {

    List<Edicao> findByObraId(Long obraId);
    
}
