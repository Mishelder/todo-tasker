package com.miaskor.todo.spring.filter;

import static com.miaskor.todo.spring.util.URLs.LOGIN;
import static com.miaskor.todo.spring.util.URLs.getAllPublicURL;

import by.miaskor.token.connector.connector.TokenConnector;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 2)
@Component
public class MainFilter extends HttpFilter {

  private static final Set<String> PUBLIC_PAGES = getAllPublicURL();
  private final TokenConnector tokenConnector;

  public MainFilter(TokenConnector tokenConnector) {
    this.tokenConnector = tokenConnector;
  }

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    String requestURI = req.getRequestURI();
    if (requestURI.contains("about")) {
      req.getSession().setAttribute("about", true);
    } else {
      req.getSession().removeAttribute("about");
    }
    Cookie token = Optional.ofNullable(req.getCookies())
        .flatMap(cookies -> Arrays.stream(cookies).filter(cookie -> "token".equals(cookie.getName())).findFirst())
        .orElse(null);

    if (token != null &&
        Boolean.TRUE.equals(tokenConnector.validateToken(token.getValue()))
    ) {
      req.setAttribute("token", token);
      chain.doFilter(req, res);
    } else if (PUBLIC_PAGES.stream().anyMatch(requestURI::startsWith)) {
      chain.doFilter(req, res);
    } else {
      res.sendRedirect(req.getHeader("referer") == null
          ? LOGIN : req.getHeader("referer"));
    }
  }
}
