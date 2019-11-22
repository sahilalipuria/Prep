package mazeSolving;

public class App {

	public static void main(String[] args) {
		FileReader fileReader = new FileReader(5, 5, "/Users/salipuri/Workspaces/XMP SDK for PI/Prep/src/mazeSolving/maze");
		fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartRowPos(), fileReader.getStartColPos());
		mazeSolver.findWayOut();

	}

}
