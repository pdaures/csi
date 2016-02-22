package com.pdaures.csi.filter;


import java.util.Iterator;

import javax.servlet.FilterConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FilterUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(FilterUtils.class);
	
	static <T> T getBeanOfType(FilterConfig config, Class<T> type) throws BeansException {
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		if(ctx == null){
			LOG.error("No WebApplicationContext found");
			return null;
		}
		Iterator<T> iterator = ctx.getBeansOfType(type).values().iterator();
		if(iterator.hasNext()){
			return iterator.next();
		}
		return null;
	}

}
