//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gameloft.ssp.core.abstracts;

import org.gameloft.ssp.core.interfaces.PartnerInterface;
import org.gameloft.ssp.core.models.PartnerRequest;
import org.gameloft.ssp.core.models.PartnerResponse;
import org.gameloft.ssp.core.models.Request;
import org.gameloft.ssp.core.providers.ApplicationContextProvider;
import org.gameloft.ssp.core.services.RenderingService;

public class AbstractPartner implements PartnerInterface {
    public AbstractPartner() {
    }

    public PartnerRequest prepareRequest(Request request) {
        return null;
    }

    public PartnerResponse processResponse(String response) {
        return null;
    }

    public String parseResponse(PartnerResponse partnerResponse) {
        return null;
    }

    protected RenderingService getRenderingService() {
        return (RenderingService)ApplicationContextProvider.getContext().getBean("renderingService");
    }
}
