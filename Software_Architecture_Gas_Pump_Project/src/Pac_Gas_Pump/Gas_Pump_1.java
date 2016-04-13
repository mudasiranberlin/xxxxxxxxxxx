package Pac_Gas_Pump;

import Pac_Data_Store.DS;
import Pac_Data_Store.DS_1;
import Pac_Mda_Efsm.MDAEFSM;
/*
 * Class Gaspump-1 its the implementation of Gaspump-1 functionality
 */
public class Gas_Pump_1 
{
	MDAEFSM mdaefsm = null;
	DS datastore = null;
	/*
	 * Constructor to set the object values
	 */
	public Gas_Pump_1 (MDAEFSM mdaefsm, DS dataStore) 
	{
		this.mdaefsm = mdaefsm;
		this.datastore = dataStore;
		this.Activate(((DS_1)dataStore).temp_a);
	}
	
	
	/*
	 * Activate to activate the pump-1
	 */
	public void Activate(int a)
	{
		if (a>0) 
		{
			((DS_1)datastore).temp_a = a;
	    	mdaefsm.activate();
		}
	}
	
	//Start to start the pump-1
	public void Start ()
	{
		mdaefsm.Start();
	}
	
	//Method to PayCredit
	public void PayCredit()
	{
		((DS_1)datastore).temp_w = 1;
		mdaefsm.PayCredit();
		
	}
	
	//Method to Reject the transaction
	public void Reject()
	{
		mdaefsm.Reject();
		
	}
	
	//Method to Cancel the transaction
	public void Cancel()
	{
		mdaefsm.Cancel();
	}
	
	//Method to Approve the Card
	public void Approved()
	{
		mdaefsm.Approved();
	}
	
	//Method for PayCash
	public void PayCash(int c)
	{
		if (c>0) {
			((DS_1)datastore).cash = c;
			((DS_1)datastore).temp_w = 0;
			mdaefsm.PayCash();
			}
	}
	
	//Method to StartPump
	public void StartPump()
	{
		mdaefsm.SelectGas(1);
		mdaefsm.StartPump();
		
	}
	
	//Method to PumpGallon
	public void PumpGallon()
	{
		if ( ((((DS_1)datastore).temp_w ==1) || (((DS_1)datastore).temp_w ==0)) && (((DS_1)datastore).cash >= ((((DS_1)datastore).G+1) * ((DS_1)datastore).price))  )
		{
			mdaefsm.Pump();
		}
		
		else if( (((DS_1)datastore).temp_w ==0) && (((DS_1)datastore).cash < ((((DS_1)datastore).G+1) * ((DS_1)datastore).price)) )
		{
			System.out.println("No enough Cash to Pump ");
			mdaefsm.StopPump();
			mdaefsm.Receipt();
		}
		else if(((DS_1)datastore).temp_w ==1)
		{
			mdaefsm.Pump();
		}
	}
	
	//Method to StopPump()
	public void StopPump()
	{
		mdaefsm.StopPump();
		mdaefsm.Receipt();
	}

}
