package br.com.acervus.repository;

import br.com.acervus.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExemplarRepository
        extends JpaRepository<Exemplar, Long> {

    List<Exemplar> findByEdicaoId(Long edicaoId);
}