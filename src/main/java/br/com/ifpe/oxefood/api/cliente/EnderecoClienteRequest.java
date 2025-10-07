package br.com.ifpe.oxefood.api.cliente;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EnderecoClienteRequest {

   private String rua;

   private String numero;

   private String bairro;

   private String cep;

   private String cidade;

   private String estado;

   private String complemento;

   public EnderecoCliente build() {

       return EnderecoCliente.builder()
               .logradouro(rua)
               .numero(numero)
               .bairro(bairro)
               .cep(cep)
               .cidade(cidade)
               .uf(estado)
               .complemento(complemento)
               .build();
   }
}
