package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS StoreData2)
 */

public class StoreData2 extends StoreData {
	
	public void StoreData(DS ds)
	{
		
	}

	public void StoreData(DS ds, DS ds2) {
		((DS_2)ds).settemp_a(((DS_2)ds).temp_a);
		((DS_2)ds2).settemp_b(((DS_2)ds2).temp_b);
	}
}
