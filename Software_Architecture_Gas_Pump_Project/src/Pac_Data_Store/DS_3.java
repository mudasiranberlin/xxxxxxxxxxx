package Pac_Data_Store;
/*
 * DS_3 is the database for the Gas Pump-3
 */
public class DS_3 extends DS{
	public float cash;
	public static float temp_a;
	public int flag;
	public float total;
	
	public float price;
	public float L;
	public static float temp_b;
	
	/*
	 * All the implementation methods consists of getter and setter methods returns the updated values for gaspump-3 variable also sets it
	 */
	public float gettemp_a()
	{
		return temp_a;
	}
	
	public void settemp_a(float t_a)
	{
		temp_a=t_a;
	}
	
	
	
	public float getL()
	{
		return L;
	}
	
	public void setL()
	{
		L=L+1;
	}
	
	public float gettotal()
	{
		return total;
	}
	
	public void settotal()
	{
		total =  price*L;
	}
	
	
	
	public void setPrice(float a_t)
	{
		
			price = a_t;
		
	}
	
	public float getCash()
	{
		return cash;
	}
	
	public void setCash(float c_t)
	{
		
			cash = c_t;
		
	}
	public float gettemp_b()
	{
		return temp_b;
	}
	
	public void settemp_b(float t_b)
	{
		temp_b=t_b;
	}
	public float getPrice()
	{
		return price;
	}
	
}
