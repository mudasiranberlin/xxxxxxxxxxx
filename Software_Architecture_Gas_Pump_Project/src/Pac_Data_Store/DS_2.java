package Pac_Data_Store;
/*
 * DS_2 is the database for the Gas Pump-2
 */
public class DS_2 extends DS{
	public int G;
	public float total;
	public static float temp_a;
	
	
	public float price;
	public int flag;
	public static float temp_b;
	
	/*
	 * All the implementation methods consists of getter and setter methods returns the updated values for gaspump-2 variable also sets it
	 */
	public float getG()
	{
		return G;
	}
	
	public void setG()
	{
		G=G+1;
	}
	
	public float gettotal()
	{
		return total;
	}
	
	public void setPrice(float p_t)
	{
		
			price = p_t;

	}
	public float gettemp_a()
	{
		return temp_a;
	}
	public void settotal()
	{
		total =  price*G;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void settemp_a(float t_a)
	{
		temp_a=t_a;
	}
	
	public float gettemp_b()
	{
		return temp_b;
	}
	
	public void settemp_b(float t_b)
	{
		temp_b=t_b;
	}
		
}
