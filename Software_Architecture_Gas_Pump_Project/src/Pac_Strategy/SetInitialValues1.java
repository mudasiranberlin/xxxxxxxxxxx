package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS SetInitialValues1)
 */

public class SetInitialValues1 extends SetInitialValues {

	public void SetInitialValues(DS ds)
	{
		 ((DS_1)ds).G = 0;
		 ((DS_1)ds).total = 0;
	}
	
}
