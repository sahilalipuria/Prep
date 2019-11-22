package primsLazyForMST;

public class Edge implements Comparable<Edge>{
	
	private double weight;
	private Vertex sourceVertex;
	private Vertex destinationVertex;
	public Edge(double weight, Vertex sourceVertex, Vertex destinationVertex) {
		super();
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
	@Override
	public int compareTo(Edge e) {
		return Double.compare(this.weight, e.getWeight());
	}
	

}
