package br.com.ifpe.oxefood.api.Estado;

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
import br.com.ifpe.oxefood.modelo.Estado.Estado;
import br.com.ifpe.oxefood.modelo.Estado.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @PostMapping 
    public ResponseEntity<Estado> save(@RequestBody EstadoRequest request) {
        Estado estado = service.save(request.buildEstado());
        return new ResponseEntity<Estado>(estado, HttpStatus.CREATED);
    }

    @GetMapping 
    public List<Estado> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}") 
    public Estado findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Estado> update(@PathVariable("id") Long id, @RequestBody EstadoRequest request) {
        service.update(id, request.buildEstado());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}