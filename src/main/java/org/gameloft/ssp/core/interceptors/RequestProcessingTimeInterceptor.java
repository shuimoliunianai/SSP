package org.gameloft.ssp.core.interceptors;

/**
 * Created by ningzhen.ge on 2016/9/20.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestProcessingTimeInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LogManager.getLogger(RequestProcessingTimeInterceptor.class);

    public RequestProcessingTimeInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        ThreadContext.put("request_id", "12345");
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        logger.info("[" + request.getRequestURL().toString() + "] Request Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
