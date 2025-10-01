package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntregadorService {

    @Transactional
public void delete(Long id) {
    repository.deleteById(id);
}

@Transactional
    public void update(Long id, Entregador entregadorAlterado) {
    Entregador entregador = repository.findById(id).get();

    entregador.setNome(entregadorAlterado.getNome());
    entregador.setCpf(entregadorAlterado.getCpf());
    entregador.setRg(entregadorAlterado.getRg());
    entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
    entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
    entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
    entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
    entregador.setValorFrete(entregadorAlterado.getValorFrete());
    entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
    entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
    entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
    entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
    entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
    entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
    entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
    entregador.setAtivo(entregadorAlterado.getAtivo());

    repository.save(entregador);
}
    @Autowired
    private EntregadorRepository repository;

    public List<Entregador> listarTodos() {
        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Entregador save(Entregador entregador) {
        entregador.setHabilitado(Boolean.TRUE);
        return repository.save(entregador);
    }
    
}
