/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
 
public class FirstFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("Test 1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        String name = request.getParameter("name1");

        System.out.println("User name intercepted by the filter......." + name);

        String uri = req.getRequestURI();
        System.out.println("uri " + uri);
        
        
        HttpSession session = req.getSession(false);
        System.out.println("----- Request ---------");
         
        
         
       Collections.list(req.getHeaderNames()).forEach(n -> System.out.println(n 
               + ": " + req.getHeader(n)));

       chain.doFilter(request, response);

        System.out.println("----- response ---------");

        resp.getHeaderNames()
                .forEach(n -> System.out.println(n + ": " + resp.getHeader(n)));

        System.out.println("response status: " + resp.getStatus());

    }
}
