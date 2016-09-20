package org.gameloft.ssp;

/**
 * Created by ningzhen.ge on 2016/9/20.
 */
import org.gameloft.ssp.core.interceptors.RequestProcessingTimeInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({"org.gameloft.ssp"})
@EnableWebMvc
@ImportResource({"classpath:spring.xml"})
public class SspApplicationConfig extends WebMvcConfigurerAdapter {
    public SspApplicationConfig() {
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestProcessingTimeInterceptor());
    }
}
