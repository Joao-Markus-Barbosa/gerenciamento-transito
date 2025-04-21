package br.com.fiap.transito.controller;

import br.com.fiap.transito.model.Veiculo;
import br.com.fiap.transito.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/veiculo")
    public ResponseEntity<Veiculo> inserirModeloVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novo = veiculoService.inserirModeloVeiculo(veiculo);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping("/veiculo")
    public ResponseEntity<List<Veiculo>> listarTodosModelos() {
        return ResponseEntity.ok(veiculoService.saberTodosOsModelosVeiculos());
    }

    @PutMapping("/veiculo")
    public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.atualizarRegistroVeiculo(veiculo));
    }

    @DeleteMapping("/veiculo/{idVeiculo}")
    public ResponseEntity<Void> excluir(@PathVariable Long idVeiculo) {
        veiculoService.excluirRegistroVeiculo(idVeiculo);
        return ResponseEntity.noContent().build();
    }
}

