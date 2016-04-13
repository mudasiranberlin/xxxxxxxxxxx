package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS SetPrice1)
 */

public class SetPrice1 extends SetPrice {
	
	public void SetPrice(DS ds,int temp_value)
	{
		DS ds1 = new DS_1();	
		
		if(temp_value==1)
		{
			((DS_1)ds).setprice(((DS_1)ds1).temp_a);	
		}
	}

}