package org.bond.ghost.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharsetCodingFilter
 */
public class CharsetCodingFilter implements Filter {

	private String charset;

	/**
	 * Default constructor.
	 */
	public CharsetCodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if (this.charset == null || this.charset.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
		} else {
			request.setCharacterEncoding(this.charset);
			response.setContentType("text/html;charset=" + this.charset);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.charset = fConfig.getInitParameter("charset");
	}

}
