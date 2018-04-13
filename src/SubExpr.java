package sadptut7;

import java.util.Map;

public class SubExpr implements ExpressionIntf{
    ExpressionIntf leftExpression;
    ExpressionIntf rightExpression;
    
    //First we define a constructor to initialize all variables
    public SubExpr(ExpressionIntf rightExpression , ExpressionIntf leftExpression)
    {
    	this.rightExpression = rightExpression;
    	this.leftExpression =leftExpression;
    }
    
    //Implementing the abstract method of the ExpressionIntf
	@Override
	public double interpret(Map<String, ExpressionIntf> variablesMap) {
		double returnval = leftExpression.interpret(variablesMap) - rightExpression.interpret(variablesMap);
		//To understand the working we will print every step
		System.out.println(leftExpression + "-" + rightExpression+"="+returnval);
		return returnval;
	}
	
	public String toString(){
		return "(" + leftExpression.toString() +"-"+ rightExpression.toString()+")";
	}

}
