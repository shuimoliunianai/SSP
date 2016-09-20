//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gameloft.ssp.core.interfaces;

import org.gameloft.ssp.core.models.PartnerRequest;
import org.gameloft.ssp.core.models.PartnerResponse;
import org.gameloft.ssp.core.models.Request;

public interface PartnerInterface {
    PartnerRequest prepareRequest(Request var1);

    PartnerResponse processResponse(String var1);

    String parseResponse(PartnerResponse var1);
}
