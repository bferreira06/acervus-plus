
package br.com.acervus.service;

import br.com.acervus.model.Edicao;
import br.com.acervus.model.Exemplar;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ExemplarRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExemplarServiceTest {

    // CT04 - Cadastrar exemplar vinculado a uma edição existente
    @Test
    void deveCadastrarExemplarVinculadoAEdicaoExistente() {

        ExemplarRepository exemplarRepository = mock(ExemplarRepository.class);
        EdicaoRepository edicaoRepository = mock(EdicaoRepository.class);

        ExemplarService service = new ExemplarService(
                exemplarRepository,
                edicaoRepository
        );

        Edicao edicao = new Edicao();
        edicao.setEditora("Editora Exemplo");
        edicao.setNumeroEdicao(1);

        Exemplar exemplar = new Exemplar();
        exemplar.setCondicao("Novo");
        exemplar.setSituacaoPosse("Tenho");
        exemplar.setDataAquisicao(LocalDate.of(2026, 11, 23));
        exemplar.setObservacoes("Primeiro exemplar");

        when(edicaoRepository.findById(1L)).thenReturn(Optional.of(edicao));
        when(exemplarRepository.save(exemplar)).thenReturn(exemplar);

        Exemplar resultado = service.cadastrar(1L, exemplar);

        assertNotNull(resultado);
        assertEquals(edicao, resultado.getEdicao());
        assertEquals("Novo", resultado.getCondicao());
        assertEquals("Tenho", resultado.getSituacaoPosse());

        verify(edicaoRepository, times(1)).findById(1L);
        verify(exemplarRepository, times(1)).save(exemplar);
    }
}
