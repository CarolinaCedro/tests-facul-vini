package tcc.verivalidacaofasoft.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VEICULO")
public class Veiculo {

    @Id
    @UuidGenerator
    private String id;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
}
