package org.mastertheboss.resteasy.resources.interceptors;

import java.lang.reflect.Method;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.AcceptedByMethod;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor,
		AcceptedByMethod {

	@SuppressWarnings("rawtypes")
	public boolean accept(Class c, Method m) {
		return m.getName().equals("clearAll");
	}

	public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
			throws Failure, WebApplicationException {
		ServerResponse response = null;

		String username = request.getFormParameters().get("username").get(0);
		// very simple security validation
		if (username == null || username.isEmpty()) {
			response = new ServerResponse(
					"To access this method you need to inform an username",
					401, new Headers<Object>());
		} else if (!"john".equals(username)) {
			response = new ServerResponse("User \"" + username
					+ "\" is not authorized to access this method.", 403,
					new Headers<Object>());
		}
		return response;
	}
}