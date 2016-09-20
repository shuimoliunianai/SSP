//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gameloft.ssp.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.gameloft.ssp.core.models.PartnerResponse;

public class PartnerResponses {
    private List<Future> responses = new ArrayList();
    private PartnerResponse winningResponse = new PartnerResponse();

    public PartnerResponses() {
    }

    public void addResponse(Future partnerResponse) {
        this.responses.add(partnerResponse);
    }

    public PartnerResponse getWinningResponse() {
        Iterator var1 = this.responses.iterator();

        while(var1.hasNext()) {
            Future response = (Future)var1.next();

            try {
                PartnerResponse e = (PartnerResponse)response.get();
                if(e.getStatus().equals("success") && e.getPrice().doubleValue() > this.winningResponse.getPrice().doubleValue()) {
                    this.winningResponse = e;
                }
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        return this.winningResponse;
    }
}
