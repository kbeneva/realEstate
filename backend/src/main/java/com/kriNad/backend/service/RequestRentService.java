package com.kriNad.backend.service;

import com.kriNad.backend.model.DemandeSoumission.Demande.RequestRent;
import com.kriNad.backend.repositories.RequestRentRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestRentService {


    private final RequestRentRepository requestRentRepository;

    public RequestRentService(RequestRentRepository requestRentRepository) {
        this.requestRentRepository = requestRentRepository;
    }


    public RequestRent createRequest(RequestRent requestRent){
        requestRentRepository.save(requestRent);
        return requestRent;
    }
}
