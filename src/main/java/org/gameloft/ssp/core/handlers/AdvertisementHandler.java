//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gameloft.ssp.core.handlers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.gameloft.ssp.core.handlers.PartnerHandler;
import org.gameloft.ssp.core.models.Partner;
import org.gameloft.ssp.core.models.PartnerResponse;
import org.gameloft.ssp.core.models.PartnerResponses;
import org.gameloft.ssp.core.models.Payload;
import org.gameloft.ssp.core.models.Response;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementHandler {
    private Payload payload;

    public AdvertisementHandler() {
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Response getAd() {
        Integer totalPartners = Integer.valueOf(1);
        ExecutorService executorService = Executors.newFixedThreadPool(totalPartners.intValue());
        PartnerResponses partnerResponses = new PartnerResponses();

        for(int winningResponse = 0; winningResponse < totalPartners.intValue(); ++winningResponse) {
            Partner response = (Partner)this.payload.getPartners().get(0);
            PartnerHandler worker = new PartnerHandler(response.getName(), this.payload.getRequest());
            partnerResponses.addResponse(executorService.submit(worker));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(500L, TimeUnit.MILLISECONDS);
            executorService.shutdownNow();
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        }

        PartnerResponse var8 = partnerResponses.getWinningResponse();
        Response var9 = new Response();
        if(var8.getStatus().equals("success")) {
            var9.setStatus(var8.getStatus());
            var9.setContent(var8.getPartnerObject().parseResponse(var8));
        }

        return var9;
    }
}
