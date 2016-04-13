package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *  Strategy (Abstract CLASS SetPrice2)
 */

public class SetPrice2 extends SetPrice {
	
	public void SetPrice( DS ds,int temp_value)
	{	
		DS ds2 = new DS_2();	
		if(temp_value==1)
		{
			((DS_2)ds).setPrice(((DS_2)ds2).temp_a);	
		}
		else if(temp_value==2)
		{
			((DS_2)ds).setPrice(((DS_2)ds2).temp_b);	
		}
	}

}