package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS StoreData3)
 */

public class StoreData3 extends StoreData {
	
	public void StoreData(DS ds)
	{
		
	}

	public void StoreData(DS ds, DS ds2) {
		((DS_3)ds).settemp_a(((DS_3)ds).temp_a);
		((DS_3)ds2).settemp_b(((DS_3)ds2).temp_b);
	}
}
