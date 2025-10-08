package br.com.ifpe.oxefood.modelo.Cidade;

import java.time.LocalDate;
import br.com.ifpe.oxefood.modelo.Estado.Estado;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cidade")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cidade extends EntidadeAuditavel {

    @Column(nullable = false, length = 100)
    private String nome; 
    @ManyToOne 
    private Estado estado; 

    @Column
    private Integer qtdPopulacao; 

    @Column
    private Boolean ehCapital; 

    @Column
    private LocalDate dataFundacao; 
}