package Pac_Mda_Efsm;
/*
 * State: Start3 which has only the implementation of Cancel and select gas
 */
import Pac_Data_Store.DS;

public class State3 implements States {

	MDAEFSM mdaefsm = null;
	DS datastore1;

	public State3(MDAEFSM mdaefsm)
	{
		this.mdaefsm=mdaefsm;
	}
	
	public void Activate() {
		
	}

	
	public void Start() {
		
	}

	
	public void PayCredit() {
		
	}

	
	public void PayCash() {
		
	}

	
	public void Reject() {
		
	}

	//cancels transaction
	public void Cancel() {
		mdaefsm.output.CancelMsg();
		mdaefsm.setState(mdaefsm.getS0State());
		
	}

	
	public void Approved() {
		
	}

	
	public void StartPump() {
		
	}

	
	public void Pump() {
		
	}

	
	public void StopPump() {
		
	}

	//Select gas type
	public void SelectGas(int g) {
		
		mdaefsm.output.SetPrice(g);
		mdaefsm.setState(mdaefsm.getS4State());
		
	}

	
	public void Receipt() {
		
	}

	
	public void NoReceipt() {
		
	}

}
