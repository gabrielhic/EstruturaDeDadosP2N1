import java.util.*;

public class Main
{
    public static void main(String[] args)
	{
		Scanner escanear = new Scanner(System.in);
		String exp;
	
		System.out.println("Informe a expressão infixa: ");
	  exp = escanear.nextLine().replace(" ", "");
		System.out.println(Conversor.conversao(exp));
    
}