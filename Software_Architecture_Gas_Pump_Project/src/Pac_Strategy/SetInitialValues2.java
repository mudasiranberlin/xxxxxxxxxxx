package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS SetInitialValues2)
 */

public class SetInitialValues2 extends SetInitialValues {

	public void SetInitialValues(DS ds)
	{
		 ((DS_2)ds).G = 0;
		 ((DS_2)ds).total = 0;
	}
	
}
