package tcc.verivalidacaofasoft.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tcc.verivalidacaofasoft.models.Reserva;
import tcc.verivalidacaofasoft.models.TipoPagamento;
import tcc.verivalidacaofasoft.models.Veiculo;
import tcc.verivalidacaofasoft.repository.ReservaRepository;
import tcc.verivalidacaofasoft.repository.VeiculoRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservaServiceImplTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllReservas() {
        List<Reserva> reservasMock = new ArrayList<>();

        // Definindo comportamento do mock
        when(reservaRepository.findAll()).thenReturn(reservasMock);

        List<Reserva> reservas = reservaService.getAllReservas();

        // Verificando se o método retornou o resultado esperado
        assertEquals(reservasMock, reservas);
        // Verificando se o método findAll() do repository foi chamado uma vez
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    void testSalvar() throws ParseException {


        Veiculo veiculo1 = new Veiculo(null, "Volkswagen", "Golf", 2015, "ABC123");
        veiculoRepository.save(veiculo1);


        // Mockando dados
        Date dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-10");
        Date dataTermino = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-15");

        Reserva reservaMock = new Reserva();
        reservaMock.setVeiculo(veiculo1);
        reservaMock.setDataInicio(dataInicio);
        reservaMock.setDataTermino(dataTermino);
        reservaMock.setTipoPagamento(TipoPagamento.CREDITO);

        reservaMock.calcularValorTotal();
        // Defina aqui um exemplo de reserva mockada

        when(reservaRepository.save(reservaMock)).thenReturn(reservaMock);

        Reserva reservaSalva = reservaService.salvar(reservaMock);

        assertEquals(reservaMock, reservaSalva);
        verify(reservaRepository, times(1)).save(reservaMock);
    }

    @Test
    void testGetAllReservasListaVazia() {
        List<Reserva> reservasMock = new ArrayList<>();

        when(reservaRepository.findAll()).thenReturn(reservasMock);

        List<Reserva> reservas = reservaService.getAllReservas();

        assertTrue(reservas.isEmpty());

        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    void testGetAllReservasListaCheia() throws ParseException {
        List<Reserva> reservasMock = new ArrayList<>();

        Veiculo veiculo1 = new Veiculo(null, "Volkswagen", "Golf", 2015, "ABC123");
        veiculoRepository.save(veiculo1);


        // Mockando dados
        Date dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-10");
        Date dataTermino = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-15");

        Reserva reservaMock = new Reserva();
        reservaMock.setVeiculo(veiculo1);
        reservaMock.setDataInicio(dataInicio);
        reservaMock.setDataTermino(dataTermino);
        reservaMock.setTipoPagamento(TipoPagamento.CREDITO);


        reservasMock.add(reservaMock);

        when(reservaRepository.findAll()).thenReturn(reservasMock);

        List<Reserva> reservas = reservaService.getAllReservas();

        assertFalse(reservas.isEmpty());

        verify(reservaRepository, times(1)).findAll();
    }

}
