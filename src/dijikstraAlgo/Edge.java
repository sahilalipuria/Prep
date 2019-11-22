package dijikstraAlgo;

public class Edge {

	private double weight;
	private Vertex sourceVertex;
	private Vertex destinationVertex;

	public Edge(double weight, Vertex sourceVertex, Vertex destinationVertex) {
		this.weight = weight;
		this.sourceVertex = sourceVertex;
		this.destinationVertex = destinationVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(Vertex sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public Vertex getDestinationVertex() {
		return destinationVertex;
	}

	public void setDestinationVertex(Vertex destinationVertex) {
		this.destinationVertex = destinationVertex;
	}
	
	
}
