package org.mastertheboss.resteasy.resources;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.mastertheboss.resteasy.controller.TrigonometryController;
import org.mastertheboss.resteasy.model.RightTriangle;

@Path("trigonometry")
public class TrigonometryService {

	/**
	 * A RPC function to calculate the basic trigonometric functions for the
	 * given parameters
	 * 
	 * @param hypotenusa
	 * @param adjacent
	 * @param opposite
	 * @return
	 */
	@Path("calculate")
	@POST
	public RightTriangle calculateAllBasicTrigonometricFunctions(
			@FormParam("hypotenusa") double hypotenusa,
			@FormParam("adjacent") double adjacent,
			@FormParam("opposite") double opposite) {
		return TrigonometryController.calculate(hypotenusa, adjacent, opposite);
	}

	@Path("history")
	@GET
	public List<RightTriangle> history() {
		return TrigonometryController.getHistory();
	}

	@Path("history")
	// @DELETE it could be delete, but we are using post for ease the WEB page
	@POST
	public String clearAll() {
		TrigonometryController.clearHistory();
		// will return 200
		return "History cleaned with success";
	}
}