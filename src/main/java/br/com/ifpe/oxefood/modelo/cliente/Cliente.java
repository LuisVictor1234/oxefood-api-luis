package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(length = 15)
    private String foneCelular;

    @Column(length = 15)
    private String foneFixo;

    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoCliente endereco;
}

