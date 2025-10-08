package br.com.ifpe.oxefood.api.Cidade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ifpe.oxefood.modelo.Cidade.Cidade;
import br.com.ifpe.oxefood.modelo.Cidade.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody CidadeRequest request) {
        Cidade cidade = service.save(request.buildCidade());
        return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cidade> findAll() { 
        return service.findAll();
    }

    @GetMapping("/{id}") 
    public Cidade findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody CidadeRequest request) {
        service.update(id, request.buildCidade());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}