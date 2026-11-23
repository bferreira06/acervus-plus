
package br.com.acervus.service;

import br.com.acervus.model.Obra;
import br.com.acervus.repository.ObraRepository;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObraServiceTest {

    // CT01 - Cadastrar obra com título válido
    @Test
    void deveCadastrarObraComTituloValido() {
        ObraRepository repository = mock(ObraRepository.class);
        ObraService service = new ObraService(repository);

        Obra obra = new Obra(null, "Dom Casmurro");
        Obra obraSalva = new Obra(1L, "Dom Casmurro");

        when(repository.save(obra)).thenReturn(obraSalva);

        Obra resultado = service.cadastrar(obra);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Dom Casmurro", resultado.getTitulo());

        verify(repository, times(1)).save(obra);
    }

    // CT02 - Rejeitar obra sem título
    @Test
    void deveRejeitarObraSemTitulo() {
        Validator validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();

        Obra obra = new Obra(null, "");

        var violations = validator.validate(obra);

        assertFalse(violations.isEmpty());
    }

    // CT05 - Consultar obra inexistente
    @Test
    void deveLancarExcecaoAoConsultarObraInexistente() {
        ObraRepository repository = mock(ObraRepository.class);
        ObraService service = new ObraService(repository);

        when(repository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException excecao = assertThrows(
                RuntimeException.class,
                () -> service.buscarPorId(99L)
        );

        assertEquals("Obra não encontrada: 99", excecao.getMessage());

        verify(repository, times(1)).findById(99L);
    }
}
