package Pac_Mda_Efsm;
/*
 * State: Start2 which has only the implementation of Reject and Approved methods
 */
public class State2 implements States{

	MDAEFSM mdaefsm = null;

	public State2(MDAEFSM mdaefsm)
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

	//Option of Reject transaction
	public void Reject() {
		mdaefsm.output.RejectMsg();
		mdaefsm.setState(mdaefsm.getS0State());
		
	}

	
	public void Cancel() {
		
	}

	//Approve the card
	public void Approved() {
		mdaefsm.output.SetW(1);
		mdaefsm.output.DisplayMenu();	
		mdaefsm.setState(mdaefsm.getS3State());
		
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
