package br.com.ifpe.oxefood.modelo.Estado;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Transactional
    public Estado save(Estado request) { 
        request.setHabilitado(true);
        request.setVersao(Long.valueOf(1));
        request.setDataCriacao(LocalDate.now());
        return repository.save(request);
    }

    public List<Estado> findAll() { 
        return repository.findAll();
    }

    public Estado findById(Long id) { 
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Long id, Estado request) { 
        Estado estado = repository.findById(id).orElse(null);

        if (estado != null) {
            estado.setNome(request.getNome());
            estado.setSigla(request.getSigla());
            estado.setVersao(estado.getVersao() + 1);
            estado.setDataUltimaModificacao(LocalDate.now());
            repository.save(estado);
        }
    }

    @Transactional
    public void delete(Long id) { 
        Estado estado = repository.findById(id).orElse(null);

        if (estado != null) {
            estado.setHabilitado(false);
            estado.setVersao(estado.getVersao() + 1);
            estado.setDataUltimaModificacao(LocalDate.now());
            repository.save(estado);
        }
    }
}