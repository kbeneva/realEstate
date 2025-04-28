package com.kriNad.backend.service;

import com.kriNad.backend.exception.RequestAppliedRentException;
import com.kriNad.backend.model.DemandeSoumission.Demande.RequestRent;
import com.kriNad.backend.repositories.RequestRentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestRentService {


    private final RequestRentRepository requestRentRepository;

    public RequestRentService(RequestRentRepository requestRentRepository) {
        this.requestRentRepository = requestRentRepository;
    }

    public boolean isApplied(Long customerId, Long propertyRentId) {
        return requestRentRepository.existsByCustomer_IdAndPropertyRent_IdProperty(customerId, propertyRentId);

    }


    public List<RequestRent> getAllRequestByCustomerId(Long customerId) {
        return requestRentRepository.getRequestRentByCustomer_Id(customerId);
    }

    public List<RequestRent> getAllRequestByAgentId(Long agentId) {
        return requestRentRepository.getRequestRentByAgent_Id(agentId);
    }



    public RequestRent createRequest(RequestRent requestRent){
        if (isApplied(requestRent.getCustomer().getId(), requestRent.getPropertyRent().getIdProperty())){
            throw new RequestAppliedRentException(requestRent);
        }
        return requestRentRepository.save(requestRent);
    }
}
