package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS SetInitialValues3)
 */

public class SetInitialValues3 extends SetInitialValues {

	public void SetInitialValues(DS ds)
	{
		 ((DS_3)ds).L = 0;
		 ((DS_3)ds).total = 0;
	}
	
}
