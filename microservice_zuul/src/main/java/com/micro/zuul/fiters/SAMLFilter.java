package com.micro.zuul.fiters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SAMLFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SAMLFilter.class);

	@Override
	public String filterType() {
		System.out.println("entra en filterType");
		return "pre";
	}

	@Override
	public int filterOrder() {
		System.out.println("entra en filterOrder");
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("entra en shouldFilter");
		return true;
	}

	@Override
	public Object run() {
		System.out.println("entra en fulter run");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}
