package Pac_Mda_Efsm;
/*
 * State: Start0 which has only the implementation of Start method
 */
public class State0 implements States{
	MDAEFSM mdaefsm = null;

	public State0(MDAEFSM mdaefsm)
	{
		this.mdaefsm=mdaefsm;
	}
	
	public void Activate() {
		
	}

	//Starts pump
	public void Start() {
		mdaefsm.output.Pay_Msg();
		mdaefsm.setState(mdaefsm.getS1State());
		
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

}
