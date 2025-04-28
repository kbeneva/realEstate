package com.kriNad.backend.exception;

import com.kriNad.backend.model.DemandeSoumission.Demande.RequestRent;
import com.kriNad.backend.model.DemandeSoumission.Demande.RequestSale;

public class RequestAppliedSaleException extends RuntimeException {
  public RequestAppliedSaleException(RequestSale requestSale){
    super( requestSale.getCustomer().getId() + " have already applied for this property");
  }
}
