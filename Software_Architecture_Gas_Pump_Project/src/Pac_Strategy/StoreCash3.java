package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS StoreCash3)
 */

public class StoreCash3 extends StoreCash {
	
	public void StoreCash(DS ds)
	{
		((DS_3)ds).setCash(((DS_3)ds).cash);
	}
	
}
