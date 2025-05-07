package com.kriNad.backend.service;

import com.kriNad.backend.exception.CustomerNotFoundException;
import com.kriNad.backend.exception.RequestAppliedRentException;
import com.kriNad.backend.exception.RequestNotFoundException;
import com.kriNad.backend.model.DemandeSoumission.Demande.RequestRent;
import com.kriNad.backend.model.DemandeSoumission.Demande.RequestSale;
import com.kriNad.backend.model.personne.Customer;
import com.kriNad.backend.model.property.PropertySale;
import com.kriNad.backend.repositories.CustomerRepository;
import com.kriNad.backend.repositories.PropertySaleRepository;
import com.kriNad.backend.repositories.RequestRentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RequestRentService {

    List<String> requestStatus = Arrays.asList("accepted", "rejected", "pending");

    private final RequestRentRepository requestRentRepository;
    private final PropertySaleRepository propertySaleRepository;
    private final CustomerRepository customerRepository;

    public RequestRentService(RequestRentRepository requestRentRepository, PropertySaleRepository propertySaleRepository, CustomerRepository customerRepository) {
        this.requestRentRepository = requestRentRepository;
        this.propertySaleRepository = propertySaleRepository;
        this.customerRepository = customerRepository;
    }


    //////Get

    public RequestRent getRequestRentById(Long IdDemande) {
        return requestRentRepository.findById(IdDemande).orElseThrow(() -> new RequestNotFoundException());
    }

    public List<RequestRent> getAllRequestByCustomerId(Long customerId) {
        return requestRentRepository.getRequestRentByCustomer_Id(customerId);
    }

    public List<RequestRent> getAllRequestByAgentId(Long agentId) {
        return requestRentRepository.getRequestRentByAgent_Id(agentId);
    }
    public Customer getCustomerById(Long idUser) {
        return customerRepository.findById(idUser).orElseThrow(() -> new CustomerNotFoundException(idUser));
    }

    ////Verify
    public boolean isApplied(Long customerId, Long propertyRentId) {
        return requestRentRepository.existsByCustomer_IdAndPropertyRent_IdProperty(customerId, propertyRentId);

    }


    /////Create

    public RequestRent createRequest(RequestRent requestRent){
        if (isApplied(requestRent.getCustomer().getId(), requestRent.getPropertyRent().getIdProperty())){
            throw new RequestAppliedRentException(requestRent);
        }
        return requestRentRepository.save(requestRent);
    }

    ////////////////update////////////////////////////////////
    public RequestRent updateRequest(Long IdDemande, String status) {

        return requestRentRepository.findById(IdDemande).map(requestRent -> {
            requestRent.setStatusDemande(status);
            return requestRentRepository.save(requestRent);

        }).orElseThrow(() -> new RequestNotFoundException());
    }

    public RequestRent acceptRequest(Long IdDemande) {
        return updateRequest(IdDemande, requestStatus.get(0));
    }

    public RequestRent rejectRequest(Long IdDemande) {
        return updateRequest(IdDemande, requestStatus.get(1));
    }

    public PropertySale updatePropertyOwner(Long IdDemande, Long idUser){
        Customer customer = getCustomerById(idUser);

        return propertySaleRepository.findById(IdDemande).map(propertySale -> {
            propertySale.setCustomer(customer);
            propertySale.setIsAccepted(true);
            return propertySaleRepository.save(propertySale);
        }).orElseThrow(() -> new RequestNotFoundException());
    }

//    public PropertySale acceptPropertyOwner(Long IdDemande, Long idUser){
//        RequestRent requestRent = getRequestRentById(IdDemande);
//
//        if (!requestRent.getStatusDemande().equals(requestStatus.get(0))){
//            throw new RuntimeException("Cannot change the owner of a request that has been not accepted");
//
//        }
//
//        PropertySale propertySale = updatePropertyOwner(IdDemande, idUser);
//        return propertySale;
//    }




    /////////////////Delete//////////////////////////////////////
    public void deleteRequestWithId(Long IdDemande) {

        RequestRent requestRent = getRequestRentById(IdDemande);

        if (requestRent.getStatusDemande().equals(requestStatus.get(0))) {
            throw new RuntimeException("Cannot delete a request that has been accepted");
        } else {
            requestRentRepository.deleteById(IdDemande);
        }

    }


}
