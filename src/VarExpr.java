package sadptut7;

import java.util.Map;

public class VarExpr implements ExpressionIntf{
   private String symbol;
   public VarExpr(String symbol)
   {
	   this.symbol=symbol;
   }
	@Override
	public double interpret(Map<String, ExpressionIntf> variablesMap) {
		double fval=0;
		if(variablesMap.get(symbol)!=null)
			fval= variablesMap.get(symbol).interpret(variablesMap);
		return fval;
	}
	
	public String toString()
	{
		return symbol;
	}
	
}
