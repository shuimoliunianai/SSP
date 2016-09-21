package config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by apple on 16/9/21.
 */
@Configuration
@Import({ RestServiceConfiguration.class})
@EnableTransactionManagement
public class AppConfiguration {
    private Logger logger = Logger.getLogger(AppConfiguration.class);
    public AppConfiguration()
    {
        logger.info("start init spring");
    }
}
