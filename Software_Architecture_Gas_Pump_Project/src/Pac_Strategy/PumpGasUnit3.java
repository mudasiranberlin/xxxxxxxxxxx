package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS PumpGasUnit3)
 */

public class PumpGasUnit3 extends PumpGasUnit {

	public void PumpGasUnit(DS ds)
	{
		((DS_3)ds).setL();
		((DS_3)ds).settotal();
	}
	
}
