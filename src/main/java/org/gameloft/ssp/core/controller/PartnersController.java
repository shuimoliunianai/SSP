package org.gameloft.ssp.core.controller;

import org.gameloft.ssp.core.handlers.AdvertisementHandler;
import org.gameloft.ssp.core.handlers.PartnerHandler;
import org.gameloft.ssp.core.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ningzhen.ge on 2016/9/20.
 */
@RestController
@RequestMapping({"/partners"})
public class PartnersController {
    private final AdvertisementHandler advertisementHandler;

    @Autowired
    public PartnersController(AdvertisementHandler advertisementHandler) {
        this.advertisementHandler = advertisementHandler;
    }
    @RequestMapping(
            value = {"/getAdvertisement"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public Response getAdvertisement(@RequestBody Payload payload) {
        Integer totalPartners = Integer.valueOf(25);
        ExecutorService executorService = Executors.newFixedThreadPool(totalPartners.intValue());
        PartnerResponses partnerResponses = new PartnerResponses();

        for(int winningResponse = 0; winningResponse < totalPartners.intValue(); ++winningResponse) {
            Partner response = (Partner)payload.getPartners().get(0);
            PartnerHandler worker = new PartnerHandler(response.getName(), payload.getRequest());
            partnerResponses.addResponse(executorService.submit(worker));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(500L, TimeUnit.MILLISECONDS);
            executorService.shutdownNow();
        } catch (InterruptedException var8) {
            var8.printStackTrace();
        }

        PartnerResponse var9 = partnerResponses.getWinningResponse();
        Response var10 = new Response();
        if(var9.getStatus().equals("success")) {
            var10.setStatus(var9.getStatus());
            var10.setContent(var9.getPartnerObject().parseResponse(var9));
        }

        return var10;
    }
}
