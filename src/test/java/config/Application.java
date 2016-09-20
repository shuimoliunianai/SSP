package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by apple on 16/9/21.
 */
public class Application {
    @Configuration
    public class SspApplicationConfig extends WebMvcConfigurerAdapter {
        public SspApplicationConfig() {
        }
    }
}
