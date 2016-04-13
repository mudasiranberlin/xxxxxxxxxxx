package Pac_Data_Store;
/*
 * DS_1 is the database for the Gas Pump-1
 */
public class DS_1 extends DS
{
	public int price = temp_a;
	public int G;
	public static int temp_a;
	public int temp_w;
	public int total;
	public int flag;
	public int cash;
	
	/*
	 * All the implementation methods consists of getter and setter methods returns the updated values for gaspump-1 variable also sets it
	 */
	public int getcash()
	{
		return cash;
	}
	
	public void setcash(int c_temp)
	{
		cash = c_temp;
	}
	
	public int getprice()
	{
		return price;
	}
	
	public int getG()
	{
		return G;
	}
	
	public void setG()
	{
		G = G+1;
	}
	
	public int getTotal()
	{
		return total;
	}
	public void setprice(int p_temp)
	{
		price = p_temp;
	}
	public int gettemp_a()
	{
		return temp_a;
	}
	
	public void settemp_a(int t_a)
	{
		temp_a=t_a;
	}
	
	
	public int gettemp_w()
	{
		return temp_w;
	}
	
	public void settemp_w(int t_w)
	{
		temp_w=t_w;
	}
	
	public void setTotal()
	{
		total = price*G;
	}
}
