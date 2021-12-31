package artizens.web.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import artizens.web.session.SessionConst;

public class LoginCheckInterceptor implements HandlerInterceptor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null){
            //로그인을 안하고 플랫폼 사용하다가 로그인 할때 쿼리 파라미터에 uri 보관 후, redirect
            String[] uriSplit = requestURI.replace("/", "/*").split("/");
            String[] path = Arrays.copyOfRange(uriSplit, 2, uriSplit.length);
            String redirectURL = String.join("",path).replace("*","/");
            response.sendRedirect("/login?redirectURL=" + redirectURL);
            LOGGER.info("interceptor_redirectURL={}",redirectURL);
            return false;
        }
        return true;
    }
}
