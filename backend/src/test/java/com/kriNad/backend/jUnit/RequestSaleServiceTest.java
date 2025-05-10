package com.kriNad.backend.jUnit;

import com.kriNad.backend.model.Request.RequestSale;
import com.kriNad.backend.repositories.RequestSaleRepository;
import com.kriNad.backend.service.RequestSaleService;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.LocalForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;

public class RequestSaleServiceTest {



    @Mock
    private RequestSaleRepository  requestSaleRepository;


    @InjectMocks
    private RequestSaleService requestSaleService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllRequestsSale(){

        LocalDate localDate = LocalDate.of(2005,  Month.APRIL, 3);

        RequestSale requestSale = new RequestSale("description1", "pending", "sale");
        RequestSale requestSale2 = new RequestSale("description2", "accepted", "sale");





    }
}
