package com.votacion.votacion.service;

import com.votacion.votacion.model.AgentePolicia;
import com.votacion.votacion.repository.AgentePoliciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentePoliciaService {

    private final AgentePoliciaRepository agentePoliciaRepository;

    public AgentePoliciaService(AgentePoliciaRepository agentePoliciaRepository) {
        this.agentePoliciaRepository = agentePoliciaRepository;
    }

    public List<AgentePolicia> findAll() {
        return agentePoliciaRepository.findAll();
    }

    public AgentePolicia save(AgentePolicia agentePolicia) {
        return agentePoliciaRepository.save(agentePolicia);
    }

    public void delete(Long id) {
        agentePoliciaRepository.deleteById(id);
    }
}
