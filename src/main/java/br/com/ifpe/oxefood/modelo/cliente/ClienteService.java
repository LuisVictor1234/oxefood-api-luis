package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

      @Transactional
   public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoCliente endereco) {

       Cliente cliente = this.obterPorID(clienteId);
      
       //Primeiro salva o EnderecoCliente:

       endereco.setCliente(cliente);
       endereco.setHabilitado(Boolean.TRUE);
       enderecoClienteRepository.save(endereco);
      
       //Depois acrescenta o endereço criado ao cliente e atualiza o cliente:

       List<EnderecoCliente> listaEnderecoCliente = cliente.getEnderecos();
      
       if (listaEnderecoCliente == null) {
           listaEnderecoCliente = new ArrayList<EnderecoCliente>();
       }
      
       listaEnderecoCliente.add(endereco);
       cliente.setEnderecos(listaEnderecoCliente);
       repository.save(cliente);
      
       return endereco;
   }


     @Transactional
   public void delete(Long id) {

       Cliente cliente = repository.findById(id).get();
       cliente.setHabilitado(Boolean.FALSE);

       repository.save(cliente);
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
      cliente.setDataNascimento(clienteAlterado.getDataNascimento());
      cliente.setCpf(clienteAlterado.getCpf());
      cliente.setFoneCelular(clienteAlterado.getFoneCelular());
      cliente.setFoneFixo(clienteAlterado.getFoneFixo());
	    
      repository.save(cliente);
  }
   @Autowired
   private ClienteRepository repository;

   @Transactional
   public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
   }

}
