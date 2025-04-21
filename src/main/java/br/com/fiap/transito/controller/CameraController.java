package br.com.fiap.transito.controller;

import br.com.fiap.transito.model.Camera;
import br.com.fiap.transito.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @PostMapping("/camera")
    public ResponseEntity<Camera> inserirPassagem(@RequestBody Camera camera) {
        Camera nova = cameraService.inserirNovasPassagens(camera);
        return ResponseEntity.status(201).body(nova);
    }

    @GetMapping("/camera")
    public ResponseEntity<List<Camera>> listarCameras() {
        return ResponseEntity.ok(cameraService.listarTodasCameras());
    }

    @PutMapping("/camera")
    public ResponseEntity<Camera> atualizarPassagem(@RequestBody Camera camera) {
        return ResponseEntity.ok(cameraService.atualizarPassagemVeiculo(camera));
    }

    @DeleteMapping("/camera/{idCamera}")
    public ResponseEntity<Void> excluir(@PathVariable Long idCamera) {
        cameraService.excluirPassagemVeiculo(idCamera);
        return ResponseEntity.noContent().build();
    }
}
