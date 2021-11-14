package com.miaskor.todo.spring.filter;

import static com.miaskor.todo.spring.util.URLs.LOGIN;
import static com.miaskor.todo.spring.util.URLs.getAllPublicURL;

import by.miaskor.rest.dto.ClientDtoResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class MainFilter extends HttpFilter {

  private static final Set<String> PUBLIC_PAGES = getAllPublicURL();

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    req.setCharacterEncoding(StandardCharsets.UTF_8.name());
    res.setCharacterEncoding(StandardCharsets.UTF_8.name());
    ClientDtoResponse client = (ClientDtoResponse) req.getSession().getAttribute("client");
    String requestURI = req.getRequestURI();
    Cookie[] cookies = req.getCookies();
    if (cookies != null && Arrays.stream(cookies)
        .noneMatch(cookie -> cookie.getName().equals("clientId"))
        && client != null) {
      res.addCookie(new Cookie("clientId", String.valueOf(client.getId())));
    }
    if (requestURI.contains("about")) {
      req.getSession().setAttribute("about", true);
    } else {
      req.getSession().removeAttribute("about");
    }
    if (PUBLIC_PAGES.stream().anyMatch(requestURI::startsWith)) {
      chain.doFilter(req, res);
    } else if (Objects.nonNull(client)) {
      chain.doFilter(req, res);
    } else {
      res.sendRedirect(req.getHeader("referer") == null
          ? LOGIN : req.getHeader("referer"));
    }
  }
}
