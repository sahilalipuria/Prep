package dagShortestPathAlgo;

public class Edge {

	private Double distance;
	private Vertex sourceVertex;
	private Vertex destinationVertex;
	public Edge(Double distance, Vertex sourceVertex, Vertex destinationVertex) {
		this.distance = distance;
		this.sourceVertex = sourceVertex;
		this.destinationVertex = destinationVertex;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
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
