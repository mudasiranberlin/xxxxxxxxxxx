package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *   Strategy (Abstract CLASS GasPumpedMsg1)
 */

public class GasPumpedMsg1 extends GasPumpedMsg {
	
	public void GasPumpedMsg(DS ds)
	{
		System.out.println(" No. of Gallons Pumped : "+ ((DS_1)ds).getG());
	}
	
}

