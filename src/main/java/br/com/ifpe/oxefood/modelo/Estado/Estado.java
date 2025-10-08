package br.com.ifpe.oxefood.modelo.Estado;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Estado")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado extends EntidadeAuditavel {
    private Long id;
    @Column(nullable = false, length = 60)
    private String nome; 

    @Column(nullable = false, length = 2)
    private String sigla; 
}