package sadptut7;
import java.io.IOException;
import java.util.*;

public class MainClass 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		CalculatorF cal=new CalculatorF();
		String command= null;
		while(true)
		{
			System.out.println("Please enter expression , or press q to quit:");
			command=sc.nextLine();
			if(command.equals('q')) break;
			else cal.parse(command).calculate();
			System.out.println("-------------------------");
		}
	}
}
