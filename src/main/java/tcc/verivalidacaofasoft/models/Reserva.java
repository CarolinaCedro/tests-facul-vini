package tcc.verivalidacaofasoft.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Reserva {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    private Veiculo veiculo;
    private Date dataInicio;
    private Date dataTermino;
    private BigDecimal valorDiaria = new BigDecimal("150.00");
    private BigDecimal valorTotal = new BigDecimal(0);


    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;


    public void calcularValorTotal() {
        // Calcula a diferença em milissegundos entre as datas de início e término
        long diff = dataTermino.getTime() - dataInicio.getTime();
        // Converte a diferença de milissegundos para dias
        long dias = diff / (1000 * 60 * 60 * 24);

        // Calcula o valor total multiplicando o número de dias pelo valor da diária (R$150,00)
        BigDecimal totalBigDecimal = valorDiaria.multiply(new BigDecimal(dias));

        // Define a escala e o modo de arredondamento
        this.valorTotal = totalBigDecimal = totalBigDecimal.setScale(2, RoundingMode.HALF_UP);

    }


}
