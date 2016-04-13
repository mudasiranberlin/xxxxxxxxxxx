package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *   Strategy (Abstract CLASS PumpGasUnit1)
 */

public class PumpGasUnit1 extends PumpGasUnit {

	public void PumpGasUnit(DS ds)
	{
		((DS_1)ds).setG();
		((DS_1)ds).setTotal();
	}
	
}
