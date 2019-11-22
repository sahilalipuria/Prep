package kruskalForMST;

public class Edge implements Comparable<Edge>{
	
	private Double weight;
	private Vertex sourceVertex;
	private Vertex targetVertex;
	public Edge(Double weight, Vertex sourceVertex, Vertex targetVertex) {
		this.weight = weight;
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Vertex getSourceVertex() {
		return sourceVertex;
	}
	public void setSourceVertex(Vertex sourceVertex) {
		this.sourceVertex = sourceVertex;
	}
	public Vertex getTargetVertex() {
		return targetVertex;
	}
	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
	@Override
	public int compareTo(Edge e) {
		return Double.compare(this.weight,e.getWeight());
	}
	
	

}
