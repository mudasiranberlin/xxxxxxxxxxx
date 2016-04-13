package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 * Strategy (Abstract CLASS SetPrice3)
 */

public class SetPrice3 extends SetPrice {
	
	
		public void SetPrice(DS ds,int temp_value)
		{	
			DS ds3 = new DS_3();	
			if(temp_value==1)
			{
				((DS_3)ds).setPrice(((DS_3)ds3).temp_a);	
			}
			else if(temp_value==2)
			{
				((DS_3)ds).setPrice(((DS_3)ds3).temp_b);	
			}
			
		}
		
	}