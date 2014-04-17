/**
 * $Id: JsonExceptionResolver.java 5075 2012-10-18 07:11:36Z you.zhou $ Copyright (c) 2012 Qunar.com. All Rights
 * Reserved.
 */
package me.peterae86.demo.web.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.peterae86.demo.web.view.JsonAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

/**
 * <p>
 * 
 * @author you.zhou@qunar.com Initial Created at 2012-4-24
 *         <p>
 */
public class JsonExceptionResolver extends
		AbstractHandlerMethodExceptionResolver implements Ordered {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(JsonExceptionResolver.class);

	private static final String DEFAULT_VIEW_NAME = "jsonView";

	private final String checkErrorFormat = "%s at %s.%s:%s";

	private int order = Ordered.LOWEST_PRECEDENCE;

	private String viewName = DEFAULT_VIEW_NAME;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	protected boolean shouldApplyTo(HttpServletRequest request, Object handler) {
		// 只处理MethodName为Json结尾的或者返回类型为JsonResponseView的handler
		if (super.shouldApplyTo(request, handler)) {
			if (handler != null) {
				HandlerMethod handlerMethod = (HandlerMethod) handler;

				if (handlerMethod.getMethod().getName().endsWith("Json")
						|| JsonAndView.class.isAssignableFrom(handlerMethod
								.getMethod().getReturnType())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected ModelAndView doResolveHandlerMethodException(
			HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception ex) {
		ModelAndView mv = new ModelAndView(viewName);
		String errorMessage;
		logger.error(ex.getMessage(), ex);
		errorMessage = "亲，后台错误了，快和管理员联系……";
		JsonAndView jav = new JsonAndView(500, errorMessage);
		mv.addObject(JsonAndViewMethodReturnValueHandler.JAV_MODEL_KEY, jav);
		return mv;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
