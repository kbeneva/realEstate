package com.kriNad.backend.repositories;

import com.kriNad.backend.model.DemandeSoumission.Demande.RequestSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RequestSaleRepository extends JpaRepository<RequestSale, Long> {


    public boolean existsByCustomer_IdAndPropertySale_IdProperty(Long customerId, Long propertySaleId);


    public List<RequestSale> getRequestSaleByAgent_Id(Long agentId);

    public List<RequestSale> getRequestSaleByCustomer_Id(Long customerId);

    public void deleteRequestSaleByPropertySale_IdProperty(Long propertySaleId);

    @Query("select rs from RequestSale rs where rs.propertySale.idProperty = ?1")
    public List<RequestSale> getRequestSaleByPropertySale(Long idDemande);

}
