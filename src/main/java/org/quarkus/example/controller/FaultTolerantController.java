package org.quarkus.example.controller;

import org.quarkus.example.service.FaultTolerantService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/fault")
public class FaultTolerantController {

    @Inject
    private FaultTolerantService faultTolerantService;

    @GET
    @Path("/fallback")
    public String fallback() {
        return faultTolerantService.fallBack();
    }

    @GET
    @Path("/retry")
    public String retry() {
        return faultTolerantService.retry();
    }
}
