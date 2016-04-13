package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *   Strategy (Abstract CLASS GasPumpedMsg3)
 */

public class GasPumpedMsg3 extends GasPumpedMsg {
	
	public void GasPumpedMsg(DS ds)
	{
		System.out.println("No. ofGallons Pumped : "+ ((DS_3)ds).getL());
	
	}
	
}

