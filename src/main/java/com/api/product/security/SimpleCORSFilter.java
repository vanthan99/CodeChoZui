//package com.api.product.security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class SimpleCORSFilter implements Filter {
//    private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);
//
//    public SimpleCORSFilter() {
//        log.info("SimpleCORSFilter init");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
//        res.setHeader("Access-Control-Allow-Credentials", "true");
//        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        res.setHeader("Access-Control-Max-Age", "3600");
//        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
//
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
