//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gameloft.ssp.core.handlers;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import org.gameloft.ssp.core.lib.HttpClient;
import org.gameloft.ssp.core.models.PartnerRequest;
import org.gameloft.ssp.core.models.PartnerResponse;
import org.gameloft.ssp.core.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class PartnerHandler implements Callable<PartnerResponse> {
    @Autowired
    private Request request;
    private Class<?> partnerClass;
    private Object partnerObject;
    private final String partnerName;

    public PartnerHandler(String partnerName, Request request) {
        this.partnerName = partnerName;
        this.request = request;
    }

    private String getClassDirectory() {
        return "org.gameloft.ssp.partners." + this.partnerName.toLowerCase() + ".Partner";
    }

    private void loadClass() {
        try {
            this.partnerClass = Class.forName(this.getClassDirectory());
            this.partnerObject = this.partnerClass.newInstance();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private PartnerRequest prepareRequest() {
        if(this.partnerClass == null || this.partnerObject == null) {
            this.loadClass();
        }

        PartnerRequest preparedRequest = null;

        try {
            Method e = this.partnerClass.getMethod("prepareRequest", new Class[]{Request.class});
            preparedRequest = (PartnerRequest)e.invoke(this.partnerObject, new Object[]{this.request});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return preparedRequest;
    }

    private PartnerResponse processResponse(String response) {
        if(this.partnerClass == null || this.partnerObject == null) {
            this.loadClass();
        }

        PartnerResponse processedResponse = null;

        try {
            Method e = this.partnerClass.getMethod("processResponse", new Class[]{String.class});
            processedResponse = (PartnerResponse)e.invoke(this.partnerObject, new Object[]{response});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return processedResponse;
    }

    public PartnerResponse call() {
        PartnerRequest request = this.prepareRequest();
        String response = null;
        try {
            response = HttpClient.post(request.getUrl(), request.getContent());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return response != null && !response.isEmpty()?this.processResponse(response):new PartnerResponse("failed");
    }
}
