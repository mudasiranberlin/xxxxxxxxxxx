package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS StoreData1)
 */

public class StoreData1 extends StoreData {
	
	public void StoreData(DS ds, DS ds1) {
		
	}
	
	public void StoreData(DS ds)
	{
		((DS_1)ds).settemp_a(((DS_1)ds).temp_a);
	}

	
}
