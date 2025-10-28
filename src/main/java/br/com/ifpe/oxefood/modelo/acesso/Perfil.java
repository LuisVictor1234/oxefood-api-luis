package br.com.ifpe.oxefood.modelo.acesso;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Perfil")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil extends EntidadeNegocio implements GrantedAuthority {

    public static final String ROLE_CLIENTE = "CLIENTE";
    public static final String ROLE_FUNCIONARIO_ADMIN = "ROLE_FUNCIONARIO_ADMIN";
    public static final String ROLE_FUNCIONARIO_USER = "ROLE_FUNCIONARIO_USER";

    @Column
    private String nome;

    @Override
    public String getAuthority() {
        return this.nome;
    }
}
