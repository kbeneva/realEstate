package com.kriNad.backend.controller;


import com.kriNad.backend.model.DemandeSoumission.Demande.RequestSale;
import com.kriNad.backend.service.RequestSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/RequestSale")
@CrossOrigin
public class RequestSaleController {


    @Autowired
     RequestSaleService requestSaleService;


    @PostMapping("/createRequest")
    public RequestSale createRequest(@RequestBody RequestSale requestSale){
        return requestSaleService.createRequest(requestSale);
    }


    @GetMapping("/agent/{id}")
    public List<RequestSale> getAllRequestsByAgentId(@PathVariable Long id){
        return requestSaleService.getAllRequestByAgentId(id);
    }

    @GetMapping("/customer/{id}")
    public List<RequestSale> getAllRequestsByCustomerId(@PathVariable Long id){
        return requestSaleService.getAllRequestByCustomerId(id);
    }
    @GetMapping("verifyRequest/{customerId}/{propertySaleId}")
    public boolean verifyRequest(@PathVariable Long customerId,@PathVariable Long propertySaleId){
        return requestSaleService.isApplied(customerId,propertySaleId);

    }

    @GetMapping("/deleteRequest/{idProperty}")
    public void deleteRequest(@PathVariable Long idProperty){
        requestSaleService.findRequestByIdProperty(idProperty);
    }

//    @DeleteMapping("/deleteRequest/{idProperty}")
//    public void deleteRequest(@PathVariable Long idProperty){
//        requestSaleService.deleteRequestWithIdProperty(idProperty);
//    }
}
