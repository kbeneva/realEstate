package com.kriNad.backend.repositories;

import com.kriNad.backend.model.DemandeSoumission.Demande.RequestSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RequestSaleRepository extends JpaRepository<RequestSale, Long> {


    public boolean existsByCustomer_IdAndPropertySale_IdProperty(Long customerId, Long propertySaleId);


    public List<RequestSale> getRequestSaleByAgent_Id(Long agentId);

    public List<RequestSale> getRequestSaleByCustomer_Id(Long customerId);


}
