package fordFulkersonForMaxFlow;

public class Vertex {
	
	private int id;
	private String name;					//BFS implementation
	private boolean visited;
	public Vertex(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public String toString() {
		return this.id + "-" + this.name;
	}

}
