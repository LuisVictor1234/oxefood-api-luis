package br.com.ifpe.oxefood.api.entregador;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {
    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {
    entregadorService.update(id, request.build());
    return ResponseEntity.ok().build();
}
    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
        Entregador entregador = entregadorService.save(request.build());
        return new ResponseEntity<>(entregador, HttpStatus.CREATED);
    }
}
