package sadptut7;

import java.util.Map;

public class Numbers implements ExpressionIntf{
 private double num;
 public Numbers(double number)
 {
	 this.num=number;
 }
	@Override
	public double interpret(Map<String, ExpressionIntf> variablesMap) {
		// TODO Auto-generated method stub
		return num;
	}
	public String toString()
	{
		return String.valueOf(num);
	}
}
