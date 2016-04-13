package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS PumpGasUnit2)
 */

public class PumpGasUnit2 extends PumpGasUnit {

	public void PumpGasUnit(DS ds)
	{
		((DS_2)ds).setG();
		((DS_2)ds).settotal();
	}
	
}
