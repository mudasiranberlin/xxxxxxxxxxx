package Pac_Mda_Efsm;
/*
 * State: Start4 which has only the implementation of Start Pump
 */
public class State4 implements States{

	MDAEFSM mdaefsm = null;

	public State4(MDAEFSM mdaefsm)
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

	//Starts Pump
	public void StartPump() {
		mdaefsm.output.SetInitialValues();
		mdaefsm.output.ReadyMsg();	
		mdaefsm.setState(mdaefsm.getS5State());
		
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
