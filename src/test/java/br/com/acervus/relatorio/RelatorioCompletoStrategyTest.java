
package br.com.acervus.relatorio;

import br.com.acervus.repository.ObraRepository;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ExemplarRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RelatorioCompletoStrategyTest {

    // CT07 - Gerar relatório completo
    @Test
    void deveGerarRelatorioCompletoComTotaisCorretos() {

        ObraRepository obras = mock(ObraRepository.class);
        EdicaoRepository edicoes = mock(EdicaoRepository.class);
        ExemplarRepository exemplares = mock(ExemplarRepository.class);

        when(obras.count()).thenReturn(5L);
        when(edicoes.count()).thenReturn(8L);
        when(exemplares.count()).thenReturn(12L);

        RelatorioCompletoStrategy strategy =
                new RelatorioCompletoStrategy(obras, edicoes, exemplares);

        Relatorio resultado = strategy.gerar();

        assertNotNull(resultado);
        assertEquals("Relatório completo do Acervus+", resultado.getTitulo());
        assertEquals(5L, resultado.getTotalObras());
        assertEquals(8L, resultado.getTotalEdicoes());
        assertEquals(12L, resultado.getTotalExemplares());

        verify(obras, times(1)).count();
        verify(edicoes, times(1)).count();
        verify(exemplares, times(1)).count();
    }
}
