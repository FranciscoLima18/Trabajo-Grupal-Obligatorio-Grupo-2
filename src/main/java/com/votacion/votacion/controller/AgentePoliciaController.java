package com.votacion.votacion.controller;

import com.votacion.votacion.model.AgentePolicia;
import com.votacion.votacion.service.AgentePoliciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agentes")
@CrossOrigin(origins = "*")
public class AgentePoliciaController {

    private final AgentePoliciaService agentePoliciaService;

    public AgentePoliciaController(AgentePoliciaService agentePoliciaService) {
        this.agentePoliciaService = agentePoliciaService;
    }

    @GetMapping
    public List<AgentePolicia> getAll() {
        return agentePoliciaService.findAll();
    }

    @PostMapping
    public AgentePolicia create(@RequestBody AgentePolicia agentePolicia) {
        return agentePoliciaService.save(agentePolicia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        agentePoliciaService.delete(id);
    }
}
