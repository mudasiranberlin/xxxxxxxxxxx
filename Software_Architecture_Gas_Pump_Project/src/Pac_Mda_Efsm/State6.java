package Pac_Mda_Efsm;
/*
 * State: Start6 which has only the implementation of Receipt and NoReceipt
 */
public class State6 implements States{

	MDAEFSM mdaefsm = null;

	public State6(MDAEFSM mdaefsm)
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

	
	public void Cancel() {
		
	}

	
	public void Approved() {
		
	}

	
	public void StartPump() {
		
	}

	
	public void Pump() {
		
	}

	
	public void StopPump() {
		
	}

	
	public void SelectGas(int g) {
		
	}

	//Prints Receipt
	public void Receipt() {
		mdaefsm.output.PrintReceipt();	
		mdaefsm.setState(mdaefsm.getS0State());
		
	}

	//No Receipt just exits the state
	public void NoReceipt() {
		mdaefsm.setState(mdaefsm.getS0State());
		
	}

}
