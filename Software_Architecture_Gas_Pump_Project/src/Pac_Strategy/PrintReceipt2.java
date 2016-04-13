package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS PrintReceipt2)
 */

public class PrintReceipt2 extends PrintReceipt {
	
	public void PrintReceipt(DS ds)
	{
		System.out.println("Total : "+ ((DS_2)ds).gettotal());
	}

}