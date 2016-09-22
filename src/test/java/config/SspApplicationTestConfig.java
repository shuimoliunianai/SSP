package config;

import config.redis.redisConfig;
import org.gameloft.ssp.core.interceptors.RequestProcessingTimeInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by apple on 16/9/21.
 */
@Configuration
@ComponentScan({"org.gameloft.ssp"})
@Import({redisConfig.class})
@ImportResource({"classpath:spring.xml"})
public class SspApplicationTestConfig {
    public SspApplicationTestConfig() {
    }
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new RequestProcessingTimeInterceptor());
//    }
}
