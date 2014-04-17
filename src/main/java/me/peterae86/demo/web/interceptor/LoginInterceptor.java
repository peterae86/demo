package me.peterae86.demo.web.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




public class LoginInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private Set<String> admins;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return super.preHandle(request, response, handler);
    }
 
    public void afterPropertiesSet() throws Exception {
    	
    }	

}
