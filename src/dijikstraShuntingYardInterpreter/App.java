package dijikstraShuntingYardInterpreter;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijikstraShuntingYardAlgo algo = new DijikstraShuntingYardAlgo();
		algo.interpretExpression("( ( 2 + 3 ) * 5 )");
		algo.result();
	}

}
