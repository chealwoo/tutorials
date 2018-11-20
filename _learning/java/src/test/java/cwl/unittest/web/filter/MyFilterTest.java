package cwl.unittest.web.filter;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyFilterTest {

    @Test
    public void testDoFilter() {
    }

    /*
    import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlockTraceMethodFilterTest {

    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private PrintWriter writer;
    private FilterChain filterChain;
    private BlockTraceMethodFilter filterUnderTest;

    @Before
    public void setup() throws Exception {
        httpServletRequest = mock(HttpServletRequest.class);
        httpServletResponse = mock(HttpServletResponse.class);
        writer = mock(PrintWriter.class);
        filterChain = mock(FilterChain.class);
        filterUnderTest = new BlockTraceMethodFilter();

        when(httpServletRequest.getRequestURI()).thenReturn("/KPN-CustomerCare_NL-Dutch-WebBotRouter/jbotservice.asmx/TalkAgent");
        when(httpServletResponse.getWriter()).thenReturn(writer);
        doNothing().when(httpServletResponse).setStatus(405);
        doNothing().when(writer).write("TRACE is not not allowed");
    }

    @Test
    public void testDoFilterWithTrace() throws Exception {
        when(httpServletRequest.getMethod()).thenReturn(RequestMethod.TRACE.name());

        filterUnderTest.doFilter(httpServletRequest, httpServletResponse, filterChain);

        verify(httpServletResponse, times(1)).setStatus(405);
        verify(writer, times(1)).write("TRACE is not not allowed");
    }

    @Test
    public void testDoFilterWithPost() throws Exception {
        when(httpServletRequest.getMethod()).thenReturn(RequestMethod.POST.name());

        BlockTraceMethodFilter filterUnderTest = new BlockTraceMethodFilter();
        filterUnderTest.doFilter(httpServletRequest, httpServletResponse, filterChain);

        verify(httpServletResponse, never()).setStatus(405);
        verify(writer, never()).write("TRACE is not not allowed");
    }
}
     */
}