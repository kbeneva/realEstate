package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRentRepository extends JpaRepository<PropertyRent, Long> {


    ///  URL devrait être : "http://localhost:9696/propertyRent/filtre?categorie=&minPrice=&maxPrice=

    @Query("select pr from PropertyRent pr" +
            " where pr.categorie = null or pr.categorie =?1" +
            "and pr.price between null and null or pr.price between ?2 and ?3" +
            "and pr.nbRooms >= null or pr.nbRooms >= ?4" +
            "and pr.nbBathrooms >= null or pr.nbBathrooms >= ?5" +
            "and pr.nbParkingSpace >= null or pr.nbParkingSpace >= ?6" +
            "and pr.nbGarages >= null or pr.nbGarages >= ?7 " +
            "and pr.area between null and null or pr.area between ?8 and ?9 " +
            "and pr.ConstructionYear between null and null or pr.ConstructionYear between ?10 and ?11 " +
            "and pr.city = null or pr.city = ?12")
    List<PropertyRent> findPropertyFilters(String categorie, Long minPrice, Long maxPrice, Long nbRooms, Long nbBathrooms, Long nbParking, Long nbGarages, Long minArea, Long maxArea, Long minYear,Long maxYear, String city);


}


