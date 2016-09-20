//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gameloft.ssp.core.services;

import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class RenderingService {
    @Autowired
    private VelocityEngine velocityEngine;

    public RenderingService() {
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public String renderTemplate(String template, Map<String, Object> model) {
        return VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, "templates/" + template, "UTF-8", model);
    }
}
