package com.pdaures.csi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pdaures.csi.service.AuthenticationService;

/**
 * Security Filter checking the request security tokens and setting the remote user
 * @author patrick
 *
 */
public class AuthenticationFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class);
	private static final String TOKEN = "token";

	private AuthenticationService service;

	//Current request's security token
	private String securityToken;

	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.info("Starting "+getClass().getSimpleName());
		service = FilterUtils.getBeanOfType(filterConfig, AuthenticationService.class);
	}

	public void destroy() {
		LOG.info("Stoping "+getClass().getSimpleName());
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		HttpServletRequest httpReq = (HttpServletRequest) req;
		ServletRequest newReq;

		try {
			newReq = authorizeUser(httpReq);
		} catch (UnauthorizedException e) {
			LOG.info("Unauthorized request for token " + e.token);
			httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		chain.doFilter(newReq, resp);
	}

	/**
	 * Check the security token in the Request and return a new Request with the
	 * remoteUser
	 * 
	 * @param request
	 * @return
	 * @throws UnauthorizedException
	 */
	public ServletRequest authorizeUser(HttpServletRequest request) throws UnauthorizedException {
		this.securityToken = request.getParameter(TOKEN);
		if (securityToken == null || securityToken.isEmpty()) {
			LOG.info("No token provided, returning Forbidden");
			throw new UnauthorizedException("");
		}
		LOG.info("Security Token : " + securityToken);
		String userId = service.getUserFromToken(securityToken);

		if (userId == null || userId.isEmpty()) {
			throw new UnauthorizedException(securityToken);

		}
		return new AuthorizedHttpServletRequest(userId, request);
	}

	/**
	 * HttpServletRequest with custom remoteUser
	 * 
	 * @author patrick
	 *
	 */
	public static class AuthorizedHttpServletRequest extends HttpServletRequestWrapper {

		private final String userId;

		public AuthorizedHttpServletRequest(String userId, HttpServletRequest request) {
			super(request);
			this.userId = userId;
		}

		@Override
		public String getRemoteUser() {
			return userId;
		}
	}

	/**
	 * Exception thrown when a request cannot be authorized
	 * @author patrick
	 *
	 */
	private class UnauthorizedException extends Exception {

		private static final long serialVersionUID = 1742688346676204767L;

		private final String token;

		public UnauthorizedException(String token) {
			super();
			this.token = token;
		}
	}

}
