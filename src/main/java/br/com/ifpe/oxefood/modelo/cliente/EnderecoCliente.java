
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.ifpe.oxefood.modelo.EntidadeAuditavel;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
public class EnderecoCliente extends EntidadeAuditavel {

   @JsonIgnore
   @ManyToOne
   private Cliente cliente;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;

   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;
  
}
