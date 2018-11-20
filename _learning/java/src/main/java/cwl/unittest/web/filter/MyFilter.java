package cwl.unittest.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

    /*
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;

public class BlockTraceMethodFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(BlockTraceMethodFilter.class);
    private static final String TRACE = RequestMethod.TRACE.name();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // Return 405 when request method is TRACE
        if (httpRequest.getMethod().equals(TRACE)) {
            httpResponse.setStatus(METHOD_NOT_ALLOWED.value());
            httpResponse.getWriter().write("TRACE is not not allowed");
            if (LOG.isDebugEnabled()) {
                LOG.debug(TRACE + " request is blocked on " + httpRequest.getRequestURI());
            }
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}


     */
}
