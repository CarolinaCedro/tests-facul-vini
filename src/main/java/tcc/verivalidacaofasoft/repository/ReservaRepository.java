package tcc.verivalidacaofasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcc.verivalidacaofasoft.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
}
