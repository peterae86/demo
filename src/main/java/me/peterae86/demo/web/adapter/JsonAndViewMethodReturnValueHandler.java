/*
 * $Id: JsonAndViewMethodReturnValueHandler.java 3972 2012-09-11 02:40:46Z you.zhou $ Copyright (c) 2012 Qunar.com. All
 * Rights Reserved.
 */
package me.peterae86.demo.web.adapter;

import me.peterae86.demo.web.view.JsonAndView;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;




// --------------------- Change Logs----------------------
// <p>@author zhou Initial Created at 2012-12-10<p>
// -------------------------------------------------------
public class JsonAndViewMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private static final String DEFAULT_VIEW_NAME = "jsonView";

    public static final String JAV_MODEL_KEY = JsonAndView.class.getName() + "-instance";

    private String viewName = DEFAULT_VIEW_NAME;

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.method.support.HandlerMethodReturnValueHandler#supportsReturnType(org.springframework
     * .core.MethodParameter)
     */
    public boolean supportsReturnType(MethodParameter returnType) {
        return JsonAndView.class.isAssignableFrom(returnType.getParameterType());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.method.support.HandlerMethodReturnValueHandler#handleReturnValue(java.lang.Object,
     * org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer,
     * org.springframework.web.context.request.NativeWebRequest)
     */
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest) throws Exception {
        if (returnValue == null) {
            return;
        }
        mavContainer.setViewName(viewName);
        JsonAndView jav = (JsonAndView) returnValue;
        mavContainer.addAttribute(JAV_MODEL_KEY, jav);
        return;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

}
