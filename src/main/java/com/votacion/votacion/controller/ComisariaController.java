package com.votacion.votacion.controller;

import com.votacion.votacion.model.Comisaria;
import com.votacion.votacion.service.ComisariaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comisarias")
@CrossOrigin(origins = "*")
public class ComisariaController {

    private final ComisariaService comisariaService;

    public ComisariaController(ComisariaService comisariaService) {
        this.comisariaService = comisariaService;
    }

    @GetMapping
    public List<Comisaria> getAll() {
        return comisariaService.findAll();
    }

    @PostMapping
    public Comisaria create(@RequestBody Comisaria comisaria) {
        return comisariaService.save(comisaria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        comisariaService.delete(id);
    }
}
