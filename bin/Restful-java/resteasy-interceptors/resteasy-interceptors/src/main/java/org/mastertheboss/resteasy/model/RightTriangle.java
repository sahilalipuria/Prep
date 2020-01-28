package org.mastertheboss.resteasy.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RightTriangle {
	private double adjacent;
	private double opposite;
	private double hypotenusa;

	private double sine;
	private double cosine;
	private double tangent;

	public double getHypotenusa() {
		return hypotenusa;
	}

	public void setHypotenusa(double hypotenusa) {
		this.hypotenusa = hypotenusa;
	}

	public double getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(double adjacent) {
		this.adjacent = adjacent;
	}

	public double getOpposite() {
		return opposite;
	}

	public void setOpposite(double opposite) {
		this.opposite = opposite;
	}

	public double getSine() {
		return sine;
	}

	public void setSine(double sine) {
		this.sine = sine;
	}

	public double getCosine() {
		return cosine;
	}

	public void setCosine(double cosine) {
		this.cosine = cosine;
	}

	public double getTangent() {
		return tangent;
	}

	public void setTangent(double tangent) {
		this.tangent = tangent;
	}
}
