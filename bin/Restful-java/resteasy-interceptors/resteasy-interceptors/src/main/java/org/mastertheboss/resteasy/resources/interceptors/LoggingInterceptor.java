package org.mastertheboss.resteasy.resources.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

@Provider
@ServerInterceptor
public class LoggingInterceptor implements PreProcessInterceptor {
	Logger logger = Logger.getLogger(LoggingInterceptor.class);

	@Context
	HttpServletRequest servletRequest;

	public ServerResponse preProcess(HttpRequest request,
			ResourceMethod resourceMethod) throws Failure,
			WebApplicationException {

		String methodName = resourceMethod.getMethod().getName();
		logger.info("Receiving request from: " + servletRequest.getRemoteAddr());
		logger.info("Attempt to invoke method \"" + methodName + "\"");
		if (methodName.equals("calculateAllBasicTrigonometricFunctions")) {
			logger.info("\tCalculate will be performed with parameters:");
			logger.info("\tAdjacent: "
					+ request.getFormParameters().get("adjacent"));
			logger.info("\tOpposite: "
					+ request.getFormParameters().get("opposite"));
			logger.info("\tHypotenusa: "
					+ request.getFormParameters().get("hypotenusa"));
		}
		if (methodName.equals("history")) {
			logger.info("Retrieving history...");
		}
		if (methodName.equals("clearAll")) {
			logger.info("User " + servletRequest.getRemoteUser()
					+ " is trying to clear the history...");
		}
		return null;
	}
}