package Pac_Gas_Pump;

import Pac_Data_Store.DS;
import Pac_Data_Store.DS_2;
import Pac_Mda_Efsm.MDAEFSM;
import Pac_Strategy.SetPrice2;
/*
 * Class Gaspump-2 its the implementation of Gaspump-2 functionality
 */
public class Gas_Pump_2 
{
	MDAEFSM mdaefsm = null;
	DS datastore = null;
	SetPrice2 sp2;
	/*
	 * Constructor to set the object values
	 */
	public Gas_Pump_2 (MDAEFSM mdaefsm, DS dataStore) 
	{
		this.mdaefsm = mdaefsm;
		this.datastore = dataStore;
		this.Activate(((DS_2)dataStore).temp_a, ((DS_2)dataStore).temp_b);
	}
	

	/*
	 * Activate to activate the pump-2
	 */
	public void Activate(float a, float b)
	{
		if (a>0 && b>0) 
		{
			((DS_2)datastore).temp_a = a;
			((DS_2)datastore).temp_b = b;
			((DS_2)datastore).flag = 2;
	    	mdaefsm.activate();
		}
	}
	
	//Start to start the pump-2
	public void Start ()
	{
		mdaefsm.Start();
	}
	
	//Method to Credit Paayment
	public void PayCredit()
	{
		mdaefsm.PayCredit();
	}
	
	//Rejects transaction
	public void Reject()
	{
		mdaefsm.Reject();
		
	}
	
	//Cancel transaction
	public void Cancel()
	{
		mdaefsm.Cancel();
	}
	
	//Approves Card
	public void Approved()
	{
		mdaefsm.Approved();
	}
	
	//Selecting GAs type Super
	public void Super()
	{
		mdaefsm.SelectGas(2);
		((DS_2)datastore).flag = 2; 	
		
	}
	
	//Selecting Gas type Regular
	public void Regular()
	{
		mdaefsm.SelectGas(1);
		((DS_2)datastore).flag = 1;
	}
	
	//Starts Pump
	public void StartPump()
	{
		mdaefsm.StartPump();
		
	}
	
	//Pumps fuel in Gallon
	public void PumpGallon()
	{
		 mdaefsm.Pump();
	}
	
	//Stops Pump
	public void StopPump()
	{
		mdaefsm.StopPump();
		mdaefsm.Receipt();
	}
}
