package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.PropertyRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRentRepository extends JpaRepository<PropertyRent, Long> {


    ///  URL devrait être : http://localhost:9696/propertyRent/filtre?categorie=&minPrice=&maxPrice=&nbRooms=&nbBathrooms=&nbParking=&nbGarages=&minArea=&maxArea=&minYear=&maxYear=&city=
    /// http://localhost:9696/propertyRent/filtre?minPrice=&maxPrice=&nbRooms=&nbBathrooms=&nbParking=&nbGarages=&minArea=&maxArea=&minYear=&maxYear=&categorie=

    @Query("select pr from PropertyRent pr" +
            " where (?1 is null or ?1 = '' or pr.categorie =?1)" +
            "and ((?2 is null or ?3 is null) or pr.price between ?2 and ?3)" +
            "and (?4 is null or pr.nbRooms >= ?4)" +
            "and (?5 is null or pr.nbBathrooms >= ?5)" +
            "and (?6 is null or pr.nbParkingSpace >= ?6)" +
            "and (?7 is null or pr.nbGarages >= ?7)" +
            "and ((?8 is null or ?9 is null) or pr.area between ?8 and ?9)" +
            "and ((?10 is null  or ?11 is null) or pr.ConstructionYear between ?10 and ?11)" +
            "and (?12 is null or ?12 = '' or pr.city = ?12)")
    List<PropertyRent> findPropertyFilters(String categorie, Long minPrice, Long maxPrice, Long nbRooms, Long nbBathrooms, Long nbParking, Long nbGarages, Long minArea, Long maxArea, Long minYear, Long maxYear, String city);


    @Query("select pr from PropertyRent pr where pr.agent.idUser =?1")
    List<PropertyRent> getPropertyByAgent(Long idUser);


    @Query("select pr from PropertyRent pr where pr.customer.idUser = ?1 and pr.isAccepted = false")
    List<PropertyRent> getPropertyByCustomer(Long customerId);


}

