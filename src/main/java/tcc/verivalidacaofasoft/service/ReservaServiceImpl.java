package tcc.verivalidacaofasoft.service;

import org.springframework.stereotype.Service;
import tcc.verivalidacaofasoft.models.Reserva;
import tcc.verivalidacaofasoft.models.Veiculo;
import tcc.verivalidacaofasoft.repository.ReservaRepository;
import tcc.verivalidacaofasoft.repository.VeiculoRepository;

import java.util.List;

@Service
public class ReservaServiceImpl {

    private final ReservaRepository reservaRepository;


    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        // Verificar se as datas de início e término são válidas
        if (reserva.getDataInicio() == null || reserva.getDataTermino() == null ||
                reserva.getDataInicio().after(reserva.getDataTermino())) {
            throw new IllegalArgumentException("As datas de início e término devem ser válidas e a data de término deve ser posterior à data de início.");
        }

        // Definir a data de término para a reserva antes de calcular o valor total
        reserva.calcularValorTotal();

        // Verificar se o veículo está disponível para o período selecionado
        // Implemente a lógica de verificação da disponibilidade do veículo aqui (não fornecida neste contexto)

        // Salvando a reserva
        return reservaRepository.save(reserva);
    }



}
