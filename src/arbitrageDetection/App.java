package arbitrageDetection;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		
		vertexList.add(new Vertex("USD"));
		vertexList.add(new Vertex("EUR"));
		vertexList.add(new Vertex("GBP"));
		vertexList.add(new Vertex("CHF"));
		vertexList.add(new Vertex("CAD"));
		
		List<Edge> edgeList = new ArrayList<>();
		
		edgeList.add(new Edge(-1*Math.log(0.741), vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(-1*Math.log(0.657), vertexList.get(0), vertexList.get(2)));
		edgeList.add(new Edge(-1*Math.log(1.061), vertexList.get(0), vertexList.get(3)));
		edgeList.add(new Edge(-1*Math.log(1.005), vertexList.get(0), vertexList.get(4)));
		
		edgeList.add(new Edge(-1*Math.log(1.349), vertexList.get(1), vertexList.get(0)));
		edgeList.add(new Edge(-1*Math.log(0.888), vertexList.get(1), vertexList.get(2)));
		edgeList.add(new Edge(-1*Math.log(1.433), vertexList.get(1), vertexList.get(3)));
		edgeList.add(new Edge(-1*Math.log(1.366), vertexList.get(1), vertexList.get(4)));
		
		edgeList.add(new Edge(-1*Math.log(1.521), vertexList.get(2), vertexList.get(0)));
		edgeList.add(new Edge(-1*Math.log(1.126), vertexList.get(2), vertexList.get(1)));
		edgeList.add(new Edge(-1*Math.log(1.614), vertexList.get(2), vertexList.get(3)));
		edgeList.add(new Edge(-1*Math.log(1.538), vertexList.get(2), vertexList.get(4)));
		
		edgeList.add(new Edge(-1*Math.log(0.942), vertexList.get(3), vertexList.get(0)));
		edgeList.add(new Edge(-1*Math.log(0.698), vertexList.get(3), vertexList.get(1)));
		edgeList.add(new Edge(-1*Math.log(0.619), vertexList.get(3), vertexList.get(2)));
		edgeList.add(new Edge(-1*Math.log(0.953), vertexList.get(3), vertexList.get(4)));
		
		edgeList.add(new Edge(-1*Math.log(0.995), vertexList.get(4), vertexList.get(0)));
		edgeList.add(new Edge(-1*Math.log(0.732), vertexList.get(4), vertexList.get(1)));
		edgeList.add(new Edge(-1*Math.log(0.650), vertexList.get(4), vertexList.get(2)));
		edgeList.add(new Edge(-1*Math.log(0.049), vertexList.get(4), vertexList.get(3)));
		
		BellmanFord bellman = new BellmanFord(vertexList, edgeList);
		bellman.bellmanFordAlgo(vertexList.get(0));
		
		bellman.printCycle();

	}

}
