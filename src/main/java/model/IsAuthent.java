package model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class IsAuthent implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	HttpSession session = ((HttpServletRequest) request).getSession();
    	RequestDispatcher rd;
    	if(null != session.getAttribute("user")) {
    		rd = ((HttpServletRequest) request).getRequestDispatcher("files.jsp?login=" + session.getAttribute("user"));
    		rd.forward(request, response);
    	} else {
    		rd = ((HttpServletRequest) request).getRequestDispatcher("login.jsp");
    		rd.forward(request, response);
    		chain.doFilter(request, response);
    	}
    	
    }
    
}
