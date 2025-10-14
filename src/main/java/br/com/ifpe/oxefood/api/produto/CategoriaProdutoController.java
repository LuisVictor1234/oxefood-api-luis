package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.produto.CategoriaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }

    @PostMapping
    public CategoriaProduto salvar(@RequestBody CategoriaProduto categoriaProduto) {
        return categoriaProdutoService.save(categoriaProduto);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody CategoriaProduto categoriaProduto) {
        categoriaProdutoService.update(id, categoriaProduto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaProdutoService.delete(id);
    }
}
