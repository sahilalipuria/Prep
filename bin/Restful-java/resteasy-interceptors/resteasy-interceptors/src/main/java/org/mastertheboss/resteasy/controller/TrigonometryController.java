package org.mastertheboss.resteasy.controller;

import java.util.ArrayList;
import java.util.List;

import org.mastertheboss.resteasy.model.RightTriangle;

/**
 * 
 * A simple singleton object for storing the history of our calculations. This
 * is an example, surely it's not the best pratice when creating controllers
 * 
 * @author William Antônio
 * 
 */
public class TrigonometryController {

	private static List<RightTriangle> history;

	static {
		initialize();
	}

	public static RightTriangle calculate(double hypotenusa, double adjacent,
			double opposite) {

		RightTriangle result = searchHistory(hypotenusa, adjacent, opposite);
		if (result == null) {
			double sin = opposite / hypotenusa;
			double cos = adjacent / hypotenusa;
			double tan = opposite / adjacent;
			result = new RightTriangle();
			result.setAdjacent(adjacent);
			result.setOpposite(opposite);
			result.setHypotenusa(hypotenusa);
			result.setCosine(cos);
			result.setSine(sin);
			result.setTangent(tan);
			history.add(result);
		}

		return result;
	}

	public static void calculate(RightTriangle rightTriangle) {
		history.add(rightTriangle);
	}

	private static RightTriangle searchHistory(double hypotenusa,
			double adjacent, double opposite) {
		RightTriangle searchResult = null;
		for (RightTriangle rightTriangle : history) {
			if (rightTriangle.getAdjacent() == adjacent
					&& rightTriangle.getOpposite() == opposite
					&& rightTriangle.getHypotenusa() == hypotenusa) {
				searchResult = rightTriangle;
				// we found the solution, no need to keep iteracting
				break;
			}
		}
		return searchResult;

	}

	public static List<RightTriangle> getHistory() {
		return history;
	}

	public static void clearHistory() {
		initialize();
	}

	private static void initialize() {
		history = new ArrayList<RightTriangle>();
	}

}
