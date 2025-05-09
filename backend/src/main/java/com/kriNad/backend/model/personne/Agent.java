package com.kriNad.backend.model.personne;

import jakarta.persistence.*;

@Entity
public class Agent extends Personne {
    private Boolean agentAcces = true;


    @Override
    public Boolean getAgentAcces() {
        return agentAcces;
    }

    @Override
    public void setAgentAcces(Boolean agentAcces) {
        this.agentAcces = agentAcces;
    }
}
