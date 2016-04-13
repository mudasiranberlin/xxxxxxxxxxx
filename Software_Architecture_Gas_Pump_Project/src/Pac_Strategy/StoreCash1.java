package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS StoreCash1)
 */

public class StoreCash1 extends StoreCash {
	
	public void StoreCash(DS ds)
	{
		((DS_1)ds).setcash(((DS_1)ds).cash);
	}

	
	
}
