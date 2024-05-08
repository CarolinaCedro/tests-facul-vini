package tcc.verivalidacaofasoft.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tcc.verivalidacaofasoft.models.Veiculo;
import tcc.verivalidacaofasoft.repository.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VeiculoServiceImplTest {

    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoServiceImpl veiculoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllVeiculos() {
        // Mockando dados
        List<Veiculo> veiculosMock = new ArrayList<>();
        // Adicione aqui exemplos de veículos mockados

        // Definindo comportamento do mock
        when(veiculoRepository.findAll()).thenReturn(veiculosMock);

        // Chamando método a ser testado
        List<Veiculo> veiculos = veiculoService.getAllVeiculos();

        // Verificando se o método retornou o resultado esperado
        assertEquals(veiculosMock, veiculos);
        // Verificando se o método findAll() do repository foi chamado uma vez
        verify(veiculoRepository, times(1)).findAll();
    }

    @Test
    void testSalvar() {
        // Mockando dados
        Veiculo veiculoMock = new Veiculo();
        // Defina aqui um exemplo de veículo mockado

        // Definindo comportamento do mock
        when(veiculoRepository.save(veiculoMock)).thenReturn(veiculoMock);

        // Chamando método a ser testado
        Veiculo veiculoSalvo = veiculoService.salvar(veiculoMock);

        // Verificando se o método retornou o resultado esperado
        assertEquals(veiculoMock, veiculoSalvo);
        // Verificando se o método save() do repository foi chamado uma vez
        verify(veiculoRepository, times(1)).save(veiculoMock);
    }
}
