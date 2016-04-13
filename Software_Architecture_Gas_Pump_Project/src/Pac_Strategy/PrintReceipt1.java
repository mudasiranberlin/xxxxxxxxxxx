package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS PrintReceipt1)
 */

public class PrintReceipt1 extends PrintReceipt {
	
	public void PrintReceipt(DS ds)
	{
		System.out.println("Total : "+ ((DS_1)ds).getTotal());
	}

}