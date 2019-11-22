package dijikstraShuntingYardInterpreter;

import java.util.Stack;

public class DijikstraShuntingYardAlgo {
	
	private Stack<String> operatorStack;
	private Stack<Double> valueStack;
	
	public DijikstraShuntingYardAlgo() {
		super();
		this.operatorStack = new Stack<>();
		this.valueStack = new Stack<>();
	}
	
	@SuppressWarnings("boxing")
	public void interpretExpression(String expression) {
	
		String[] expressionArray = expression.split(" ");
		for(String value: expressionArray) {
			if(value.equals("("))
				continue;
			else if(value.equals("+"))
				this.operatorStack.push(value);
			else if(value.equals("*"))
				this.operatorStack.push(value);
			else if(value.equals(")")) {
				String operation = this.operatorStack.pop();
				if(operation.equals("+")) {
					this.valueStack.push(this.valueStack.pop()+ this.valueStack.pop());
				}
				else if(operation.equals("*")) {
					this.valueStack.push(this.valueStack.pop()* this.valueStack.pop());
				} 
			}
			else {
				this.valueStack.push(Double.parseDouble(value));
			}
		}
	}
	
	public void result() {
		System.out.println(this.valueStack.pop());
	}
	
}
