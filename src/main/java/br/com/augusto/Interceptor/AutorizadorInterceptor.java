package br.com.augusto.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("/") ||uri.endsWith("/login")||uri.endsWith("/formUser") || uri.endsWith("/autenticacao") || uri.contains("resources")) {
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		} else {
			System.out.println(request.getContextPath());
			response.sendRedirect("/login");
			return false;
		}

	}

}
