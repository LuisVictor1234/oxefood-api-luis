package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoClienteRepository enderecoRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        if (cliente.getEndereco() != null && cliente.getEndereco().getId() != null) {
            EnderecoCliente endereco = enderecoRepository.findById(cliente.getEndereco().getId()).get();
            cliente.setEndereco(endereco);
        }

        cliente.setHabilitado(Boolean.TRUE);
        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
        Cliente cliente = repository.findById(id).get();

        cliente.setNome(clienteAlterado.getNome());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());
        cliente.setEndereco(clienteAlterado.getEndereco());

        repository.save(cliente);
    }

    @Transactional
    public void delete(Long id) {
        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);
        repository.save(cliente);
    }

    @Transactional
    public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoCliente endereco) {
        Cliente cliente = repository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        endereco.setCliente(cliente); 
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public EnderecoCliente atualizarEnderecoCliente(Long enderecoId, EnderecoCliente enderecoAlterado) {
        EnderecoCliente endereco = enderecoRepository.findById(enderecoId)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        endereco.setLogradouro(enderecoAlterado.getLogradouro());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setUf(enderecoAlterado.getUf());
        endereco.setComplemento(enderecoAlterado.getComplemento());

        return enderecoRepository.save(endereco);
    }

    @Transactional
    public void removerEnderecoCliente(Long enderecoId) {
        EnderecoCliente endereco = enderecoRepository.findById(enderecoId)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        enderecoRepository.delete(endereco);
    }
}
