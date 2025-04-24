package com.kriNad.backend.controller;


import com.kriNad.backend.model.DemandeSoumission.Demande.RequestRent;
import com.kriNad.backend.service.RequestRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/RequestRent")
@CrossOrigin
public class RequestRentController {


    @Autowired
     RequestRentService requestRentService;


    @PostMapping("/createRequest")
    public RequestRent createRequest(@RequestBody RequestRent requestRent){
        return requestRentService.createRequest(requestRent);
    }
}
