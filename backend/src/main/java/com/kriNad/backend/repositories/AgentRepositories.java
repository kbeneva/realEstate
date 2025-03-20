package com.kriNad.backend.repositories;

import com.kriNad.backend.model.personne.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepositories extends JpaRepository<Agent, Long> {
}
