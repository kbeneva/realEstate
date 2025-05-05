package com.kriNad.backend.service;

import com.kriNad.backend.exception.RequestAppliedSaleException;
import com.kriNad.backend.model.DemandeSoumission.Demande.RequestSale;
import com.kriNad.backend.repositories.RequestSaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestSaleService {


    private final RequestSaleRepository requestSaleRepository;

    public RequestSaleService(RequestSaleRepository requestSaleRepository) {
        this.requestSaleRepository = requestSaleRepository;
    }


    public boolean isApplied(Long customerId, Long propertySaleId) {
        return requestSaleRepository.existsByCustomer_IdAndPropertySale_IdProperty(customerId, propertySaleId);

    }


    public List<RequestSale> getAllRequestByCustomerId(Long customerId) {
        return requestSaleRepository.getRequestSaleByCustomer_Id(customerId);
    }

    public List<RequestSale> getAllRequestByAgentId(Long agentId) {
        return requestSaleRepository.getRequestSaleByAgent_Id(agentId);
    }


    public RequestSale createRequest(RequestSale requestSale) {
        if (isApplied(requestSale.getCustomer().getId(), requestSale.getPropertySale().getIdProperty())) {
            throw new RequestAppliedSaleException(requestSale);
        }
        return requestSaleRepository.save(requestSale);
    }


    public RequestSale findRequestByIdProperty(Long idProperty) {

        return requestSaleRepository.getRequestSaleByPropertySale(idProperty);


    }

//    public void deleteRequestWithIdProperty(Long idProperty) {
//
//
//
//        if (requestSale.getStatusDemande().equals("accepted")) {
//            throw new RuntimeException("Cannot delete a request that has been accepted");
//        } else {
//            requestSaleRepository.deleteRequestSaleByPropertySale_IdProperty(idProperty);
//        }
//
//    }

}
