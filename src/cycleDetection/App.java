package cycleDetection;

import java.util.ArrayList;
import java.util.List;

import cycleDetection.*;

public class App {

	Vertex v1 = new Vertex("1");
    Vertex v2 = new Vertex("2");
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");
    Vertex v6 = new Vertex("6");
    
    v1.addNeighbour(v2);
    v1.addNeighbour(v3);
    v2.addNeighbour(v3);
    v4.addNeighbour(v1);
    v4.addNeighbour(v5);
    v5.addNeighbour(v6);
    v6.addNeighbour(v4);
    
    List<Vertex> vertexList = new ArrayList<>();
    vertexList.add(v1);
    vertexList.add(v2);
    vertexList.add(v3);
    vertexList.add(v4);
    vertexList.add(v5);
    vertexList.add(v6);
    
    CycleDetection cycleDetection = new CycleDetection();
    cycleDetection.detectCycle(vertexList);
}
