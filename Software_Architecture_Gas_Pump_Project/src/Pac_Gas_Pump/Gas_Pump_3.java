package Pac_Gas_Pump;

import Pac_Data_Store.DS;
import Pac_Mda_Efsm.MDAEFSM;
import Pac_Strategy.SetPrice3;
import Pac_Data_Store.DS_3;


/*
 * Class Gaspump-3 its the implementation of Gaspump-3 functionality
 */
public class Gas_Pump_3 {
	
	MDAEFSM mdaefsm = null;
	DS datastore = null;
	SetPrice3 sp3 ;
	/*
	 * Constructor to set the object values
	 */
	public Gas_Pump_3 (MDAEFSM mdaefsm, DS dataStore) 
	{
		this.mdaefsm = mdaefsm;
		this.datastore = dataStore;
		this.Activate(((DS_3)dataStore).temp_a, ((DS_3)dataStore).temp_b);
	}
	
	// Selecting fuel type Premium
	public void Premium()
	{
		mdaefsm.SelectGas(2);
		((DS_3)datastore).flag = 2;
	}
	
	//Selecting fuel type Regular 
	public void Regular()
	{
		mdaefsm.SelectGas(1);
		((DS_3)datastore).flag = 1;
	}
	
	
	// stops pump
	public void StopPump()
	{
		mdaefsm.StopPump();
	}

	/*
	 * Activate to activate the pump-3
	 */
	public void Activate(float a, float b)
	{
		if (a>0 && b>0) 
		{
			((DS_3)datastore).temp_a = a;
			((DS_3)datastore).temp_b = b;
	    	mdaefsm.activate();
		}
	}
	//Starts Pump
	public void Start ()
	{
		mdaefsm.Start();
	}
	
	//Pay by Cash
	public void PayCash(float c)
	{
		if(c>0)
		{
			((DS_3)datastore).cash = c;
			mdaefsm.PayCash();
		}
		
	}
	
	
	//Cancels transaction
	public void Cancel()
	{
		mdaefsm.Cancel();
	}
	
	
	//Prints Receipt
	public void Receipt()
	{
		mdaefsm.Receipt();
	}
	
	//No receipt
	public void NoReceipt()
	{
		mdaefsm.NoReceipt();
	}
	//Starts Pump
	public void StartPump()
	{
		mdaefsm.StartPump();
		
	}
	
	//Pumps fuel in liters
	public void PumpLiter()
	{
		if ( ((DS_3)datastore).cash >= ((((DS_3)datastore).L+1) * ((DS_3)datastore).price  ))
		{
			mdaefsm.Pump();
		}
		else if ( ((DS_3)datastore).cash < ((((DS_3)datastore).L+1) * ((DS_3)datastore).price  ))
		{
			mdaefsm.StopPump();
		}
	}
}
