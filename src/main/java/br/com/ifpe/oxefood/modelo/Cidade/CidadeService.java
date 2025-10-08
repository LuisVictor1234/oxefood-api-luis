package br.com.ifpe.oxefood.modelo.Cidade;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifpe.oxefood.modelo.Estado.EstadoService;
import jakarta.transaction.Transactional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Autowired
    private EstadoService estadoService; 

    @Transactional
    public Cidade save(Cidade request) { 
        request.setHabilitado(true);
        request.setVersao(Long.valueOf(1));
        request.setDataCriacao(LocalDate.now());

        request.setEstado(estadoService.findById(request.getEstado().getId())); 
        return repository.save(request);
    }

    public List<Cidade> findAll() { 
        return repository.findAll();
    }

    public Cidade findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Long id, Cidade request) { 
        Cidade cidade = repository.findById(id).orElse(null);

        if (cidade != null) {
            cidade.setNome(request.getNome());
            cidade.setQtdPopulacao(request.getQtdPopulacao());
            cidade.setEhCapital(request.getEhCapital());
            cidade.setDataFundacao(request.getDataFundacao());

            cidade.setEstado(estadoService.findById(request.getEstado().getId()));

            cidade.setVersao(cidade.getVersao() + 1);
            cidade.setDataUltimaModificacao(LocalDate.now());
            repository.save(cidade);
        }
    }

    @Transactional
    public void delete(Long id) { 
        Cidade cidade = repository.findById(id).orElse(null);

        if (cidade != null) {
            cidade.setHabilitado(false);
            cidade.setVersao(cidade.getVersao() + 1);
            cidade.setDataUltimaModificacao(LocalDate.now());
            repository.save(cidade);
        }
    }
}