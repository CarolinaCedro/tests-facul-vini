package tcc.verivalidacaofasoft.service;

import org.springframework.stereotype.Service;
import tcc.verivalidacaofasoft.models.Veiculo;
import tcc.verivalidacaofasoft.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoServiceImpl {

    private final VeiculoRepository veiculoRepository;


    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }


    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }


}
