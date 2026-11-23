
package br.com.acervus.service;

import br.com.acervus.model.Edicao;
import br.com.acervus.model.Obra;
import br.com.acervus.repository.EdicaoRepository;
import br.com.acervus.repository.ObraRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EdicaoServiceTest {

    // CT03 - Cadastrar edição vinculada a uma obra existente
    @Test
    void deveCadastrarEdicaoVinculadaAObraExistente() {

        EdicaoRepository edicaoRepository = mock(EdicaoRepository.class);
        ObraRepository obraRepository = mock(ObraRepository.class);

        EdicaoService service = new EdicaoService(
                edicaoRepository,
                obraRepository
        );

        Obra obra = new Obra(1L, "Dom Casmurro");

        Edicao edicao = new Edicao();
        edicao.setEditora("Editora Exemplo");
        edicao.setNumeroEdicao(1);
        edicao.setAnoPublicacao(2024);
        edicao.setNumeroPaginas(256);

        when(obraRepository.findById(1L)).thenReturn(Optional.of(obra));
        when(edicaoRepository.save(edicao)).thenReturn(edicao);

        Edicao resultado = service.cadastrar(1L, edicao);

        assertNotNull(resultado);
        assertEquals(obra, resultado.getObra());
        assertEquals("Editora Exemplo", resultado.getEditora());

        verify(obraRepository, times(1)).findById(1L);
        verify(edicaoRepository, times(1)).save(edicao);
    }
}
