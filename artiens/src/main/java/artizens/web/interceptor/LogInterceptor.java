package artizens.web.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import artizens.web.session.SessionConst;

public class LogInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(SessionConst.LOG_ID, uuid); //로그 암호화
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            LOGGER.info("handlerMethod = {}", hm);
        }
        LOGGER.info("REQUEST_preHandle [{}][{}][{}]", uuid, requestURI, handler); // 로그id, uri, controller
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	LOGGER.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String logId = (String) request.getAttribute(SessionConst.LOG_ID);
        LOGGER.info("RESPONSE_afterCompletion [{}][{}]", logId, requestURI);
        if (ex != null){
        	LOGGER.error("afterCompletion error!!", ex);
        }
    }
}
