package sadptut7;

import java.util.*;

public class CalculatorF 
{
	private Stack<ExpressionIntf> stack =null;
	private Map<String,ExpressionIntf> variablesMap = null;
	private StringBuffer variablesExpression;
	public CalculatorF parse(String expression)
	{
		variablesMap = new HashMap<String,ExpressionIntf>();
		variablesExpression = new StringBuffer();
		StringTokenizer stringTokenizer = new StringTokenizer(expression," ");
		int i=0;
		String token = null;
		//In case of numbers we have to just store the values
		//apend them to the StringBuffer
		while(stringTokenizer.hasMoreTokens())
		{
			token = stringTokenizer.nextToken();
			if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/") )
			{
				variablesExpression.append("x"+i+" ");
				variablesMap.put("x"+i++, new Numbers(Double.valueOf(token)));
			} else variablesExpression.append(token+ " ");
		}
		return this;
	}
	public double calculate()
	{
		stack = new Stack<ExpressionIntf>();
		// Here we use String Tokenizer
		//We convert String Buffer to String and 
		//tokens separated by space are added to
		//tokenizer
		StringTokenizer st =new StringTokenizer(variablesExpression.toString()," ");
		
		String token=null;
		//Now checking all tokens one by one
		while(st.hasMoreTokens())
		{
			token= st.nextToken();
			//pop numbers if the token is an operator
			if(token.equals("+"))
				stack.push(new AddExpr(stack.pop(),stack.pop()));
			else if(token.equals("-"))
				stack.push(new SubExpr(stack.pop(),stack.pop()));
			else if(token.equals("*"))
				stack.push(new MultExpr(stack.pop(),stack.pop()));
			else if(token.equals("/"))
				stack.push(new DivExpr(stack.pop(),stack.pop()));
			
			//else push the number onto the stack
			else stack.push(new VarExpr(token));
		}
		
		//return the final answer
		return stack.pop().interpret(variablesMap);
	}
	}