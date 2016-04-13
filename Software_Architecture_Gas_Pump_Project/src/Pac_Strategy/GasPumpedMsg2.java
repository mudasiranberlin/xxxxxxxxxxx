package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *   Strategy (Abstract CLASS GasPumpedMsg2)
 */

public class GasPumpedMsg2 extends GasPumpedMsg {
	
	public void GasPumpedMsg(DS ds)
	{
		System.out.println("No. of Gallons Pumped : "+ ((DS_2)ds).getG());
	}
	
}

