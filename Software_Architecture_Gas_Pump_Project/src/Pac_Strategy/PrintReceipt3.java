package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS PrintReceipt3)
 */

public class PrintReceipt3 extends PrintReceipt {
	
	public void PrintReceipt(DS ds)
	{
		System.out.println("Total : "+ ((DS_3)ds).gettotal());
		System.out.println("Liters Pumped : "+ ((DS_3)ds).getL());
	}

}