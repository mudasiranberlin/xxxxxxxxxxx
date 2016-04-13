package Pac_Mda_Efsm;
/*
 * State: Start5 which has only the implementation of Pump and Stop Pump
 */
public class State5 implements States {

	MDAEFSM mdaefsm = null;

	public State5(MDAEFSM mdaefsm)
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

	//Starts the Pump
	public void Pump() {
		
		mdaefsm.output.PumpGasUnit();
		mdaefsm.output.GasPumpedMsg();
		mdaefsm.setState(mdaefsm.getS5State());
		
	}

	//Stops the Pump
	public void StopPump() {
		mdaefsm.output.StopMsg();	
		mdaefsm.setState(mdaefsm.getS6State());
	}

	
	public void SelectGas(int g) {
		
	}

	
	public void Receipt() {
		
	}

	
	public void NoReceipt() {
		
	}

}
