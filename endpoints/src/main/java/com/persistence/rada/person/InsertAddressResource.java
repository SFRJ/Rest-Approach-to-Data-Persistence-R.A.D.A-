package com.persistence.rada.person;

import domain.Address;
import domain.Person;
import org.jvnet.hk2.annotations.Service;
import services.AddressInsertService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Service
@Path("insertperson")
public class InsertAddressResource {

    private final AddressInsertService addressInsertService;

    @Inject
    public InsertAddressResource(AddressInsertService addressInsertService) {
        this.addressInsertService = addressInsertService;
    }

    @POST
    @Consumes({"application/json"})
    public void insert(Address address) {
        addressInsertService.insert(address);
    }

    /*
        A Sample Json to POST:
        {
          "firstline": "street bla bla",
          "secondline": "town of bla bla",
          "postcode": "ble ble ble",
          "persons": [
                {"firstname":"Armin","secondname":"Josef"},
                {"firstname":"Johan","secondname":"Uhgler"}
            ]
        }
    */
}
