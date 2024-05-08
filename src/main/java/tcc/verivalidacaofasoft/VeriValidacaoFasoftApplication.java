package tcc.verivalidacaofasoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tcc.verivalidacaofasoft.models.Reserva;
import tcc.verivalidacaofasoft.models.TipoPagamento;
import tcc.verivalidacaofasoft.models.Veiculo;
import tcc.verivalidacaofasoft.repository.ReservaRepository;
import tcc.verivalidacaofasoft.repository.VeiculoRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class VeriValidacaoFasoftApplication implements CommandLineRunner {

    @Autowired
    private  VeiculoRepository veiculoRepository;

    @Autowired
    private  ReservaRepository reservaRepository;


    public static void main(String[] args) {
        SpringApplication.run(VeriValidacaoFasoftApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        Veiculo veiculo1 = new Veiculo(null, "Volkswagen", "Golf", 2015, "ABC123");
        veiculoRepository.save(veiculo1);

        Veiculo veiculo2 = new Veiculo(null, "Honda", "Civic", 2018, "DEF456");
        veiculoRepository.save(veiculo2);

        Veiculo veiculo3 = new Veiculo(null, "Toyota", "Corolla", 2019, "GHI789");
        veiculoRepository.save(veiculo3);

        Veiculo veiculo4 = new Veiculo(null, "Volkswagen", "Polo", 2017, "JKL012");
        veiculoRepository.save(veiculo4);

        Veiculo veiculo5 = new Veiculo(null, "Honda", "Fit", 2016, "MNO345");
        veiculoRepository.save(veiculo5);


        //Criar uma reserva
        Date dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-10");
        Date dataTermino = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-15");

        Reserva reserva = new Reserva();
        reserva.setVeiculo(veiculo5);
        reserva.setDataInicio(dataInicio);
        reserva.setDataTermino(dataTermino);
        reserva.setTipoPagamento(TipoPagamento.CREDITO);

        // Calcular o valor total da reserva
        reserva.calcularValorTotal();

        // Salvar a reserva
        reservaRepository.save(reserva);


    }
}
