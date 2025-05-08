package com.kriNad.backend.model.property;


import com.kriNad.backend.model.personne.Customer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


// plusieurs propriétés à louer pour plusieurs occupant
@Entity
public class Occupant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
