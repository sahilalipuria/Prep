package bellmanFordAlgo;

public class Edge {
	
	private int weight;
	private Vertex sourceVertex;
	private Vertex targetVertex;
	
	public Edge(int weight, Vertex sourceVertex, Vertex targetVertex) {
		this.weight = weight;
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
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

}
