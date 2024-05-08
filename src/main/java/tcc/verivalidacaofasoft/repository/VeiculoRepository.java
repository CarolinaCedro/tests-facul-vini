package tcc.verivalidacaofasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcc.verivalidacaofasoft.models.Reserva;
import tcc.verivalidacaofasoft.models.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
