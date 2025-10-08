package br.com.ifpe.oxefood.api.Cidade;

import java.time.LocalDate;
import br.com.ifpe.oxefood.modelo.Cidade.Cidade;
import br.com.ifpe.oxefood.modelo.Estado.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeRequest {
    
    private String nome;
    private Long idEstado; 
    private Integer qtdPopulacao;
    private Boolean ehCapital;
    private LocalDate dataFundacao;

    public Cidade buildCidade() {

        Estado estado = new Estado();
        estado.setId(idEstado);
        
        return Cidade.builder()
                .nome(nome)
                .estado(estado) 
                .qtdPopulacao(qtdPopulacao)
                .ehCapital(ehCapital)
                .dataFundacao(dataFundacao)
                .build();
    }
}