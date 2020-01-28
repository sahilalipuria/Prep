package org.mastertheboss.resteasy.resources.interceptors;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

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
public class ValidationInterceptor implements PreProcessInterceptor,
		AcceptedByMethod {

	private double adjacent;
	private double opposite;
	private double hypotenusa;

	@SuppressWarnings("rawtypes")
	public boolean accept(Class c, Method m) {
		return m.getName().equals("calculateAllBasicTrigonometricFunctions");
	}

	public ServerResponse preProcess(HttpRequest request,
			ResourceMethod resourceMethod) throws Failure,
			WebApplicationException {

		// start server response as null and perform the validations, if it gets
		// some value, it will be a valid response and the interceptor will stop
		// the request
		ServerResponse response = null;
		try {
			adjacent = parseDouble(request.getFormParameters()
					.get("adjacent").get(0));
			opposite = Double.parseDouble(request.getFormParameters()
					.get("opposite").get(0));
			hypotenusa = Double.parseDouble(request.getFormParameters()
					.get("hypotenusa").get(0));

			// Pythagoras
			boolean isValid = pow(adjacent, 2) + pow(opposite, 2) == pow(
					hypotenusa, 2);
			// If it is not valid we will create a response with an appropriated
			// HTTP Code
			if (!isValid) {
				response = new ServerResponse("Not a valid right triangle",
						400, new Headers<Object>());
			}
		} catch (Exception e) {
			response = new ServerResponse(
					"Please verify the sent parameters, can't convert for use",
					400, new Headers<Object>());
		}
		return response;
	}
}