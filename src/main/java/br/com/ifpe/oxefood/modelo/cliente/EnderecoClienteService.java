package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoClienteService {

    @Autowired
    private EnderecoClienteRepository repository;

    public List<EnderecoCliente> listarTodos() {
        return repository.findAll();
    }

    public EnderecoCliente obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public EnderecoCliente save(EnderecoCliente endereco) {
        endereco.setHabilitado(Boolean.TRUE);
        return repository.save(endereco);
    }

    @Transactional
    public void update(Long id, EnderecoCliente enderecoAlterado) {
        EnderecoCliente endereco = repository.findById(id).get();

        endereco.setLogradouro(enderecoAlterado.getLogradouro());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setUf(enderecoAlterado.getUf());
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setComplemento(enderecoAlterado.getComplemento());

        repository.save(endereco);
    }

    @Transactional
    public void delete(Long id) {
        EnderecoCliente endereco = repository.findById(id).get();
        endereco.setHabilitado(Boolean.FALSE);
        repository.save(endereco);
    }
}
