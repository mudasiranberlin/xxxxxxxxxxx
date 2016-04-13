package Pac_Strategy;
import Pac_Data_Store.*;

/* 
 *   Strategy (Abstract CLASS SetW1)
 */

public class SetW1 extends SetW {
	
	public void SetW(DS ds)
	{
		((DS_1)ds).settemp_w(((DS_1)ds).temp_w);
	}

}