package com.kriNad.backend.repositories;

import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepositories extends JpaRepository<Agent, Long> {
}
