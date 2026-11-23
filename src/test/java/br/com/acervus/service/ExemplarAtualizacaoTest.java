
package br.com.acervus.service;

import br.com.acervus.model.Exemplar;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ExemplarRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExemplarAtualizacaoTest {

    // CT06 - Atualizar dados de exemplar
    @Test
    void deveAtualizarDadosDoExemplar() {

        ExemplarRepository exemplarRepository = mock(ExemplarRepository.class);
        EdicaoRepository edicaoRepository = mock(EdicaoRepository.class);

        ExemplarService service = new ExemplarService(
                exemplarRepository,
                edicaoRepository
        );

        Exemplar existente = new Exemplar();
        existente.setCondicao("Usado");
        existente.setSituacaoPosse("Tenho");

        Exemplar dados = new Exemplar();
        dados.setCondicao("Novo");
        dados.setSituacaoPosse("Vendi");
        dados.setDataAquisicao(LocalDate.of(2026, 11, 23));
        dados.setObservacoes("Exemplar atualizado");

        when(exemplarRepository.findById(1L))
                .thenReturn(Optional.of(existente));

        when(exemplarRepository.save(existente))
                .thenReturn(existente);

        Exemplar resultado = service.atualizar(1L, dados);

        assertEquals("Novo", resultado.getCondicao());
        assertEquals("Vendi", resultado.getSituacaoPosse());
        assertEquals(LocalDate.of(2026, 11, 23), resultado.getDataAquisicao());
        assertEquals("Exemplar atualizado", resultado.getObservacoes());

        verify(exemplarRepository, times(1)).save(existente);
    }
}
