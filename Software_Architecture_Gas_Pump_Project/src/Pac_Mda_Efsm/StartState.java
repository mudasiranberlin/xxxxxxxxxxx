package Pac_Mda_Efsm;
/*
 * State: Start State which has only the implemtation if Activate method
 */
public class StartState implements States{

	MDAEFSM mdaefsm = null;
	
	public StartState(MDAEFSM mdaefsm) {
		this.mdaefsm= mdaefsm;
		
	}
	
	//Activates the pump
	public void Activate() {
		mdaefsm.output.StoreData();
		mdaefsm.setState(mdaefsm.getS0State());
		
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

	
	public void Receipt() {
		
	}

	
	public void NoReceipt() {
		
	}


	public void Start() {
		
	}

}
