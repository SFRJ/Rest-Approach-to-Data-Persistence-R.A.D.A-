package com.persistence.rada.person;

import domain.Address;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Service
@Path("insertperson")
public class InsertAddressResource {

    private final services.nosqlcrud.CreateService noSqlcreateService;
    private final services.sqlcrud.CreateService sqlCreateService;

    @Inject
    public InsertAddressResource(services.nosqlcrud.CreateService noSqlcreateService,
                                 services.sqlcrud.CreateService sqlCreateService) {
        this.noSqlcreateService = noSqlcreateService;
        this.sqlCreateService = sqlCreateService;
    }

    @POST
    @Consumes({"application/json"})
    public void insert(Address address) {
//        noSqlcreateService.create(address);
        sqlCreateService.create(address);
    }

    /*
        A Sample Json to POST:
        URL: http://localhost:9998/insertperson
        Content Type: application/json

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
