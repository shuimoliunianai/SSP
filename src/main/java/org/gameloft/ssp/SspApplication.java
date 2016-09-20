package org.gameloft.ssp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class SspApplication extends SpringBootServletInitializer {
    public SspApplication() {
    }

    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(new RequestContextListener());
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(new Class[]{SspApplication.class});
    }

    public static void main(String[] args) {
        SpringApplication.run(SspApplication.class, args);
    }
}
