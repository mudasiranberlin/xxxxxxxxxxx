package Pac_Mda_Efsm;
/*
 * State: Start1 which has only the implementation of PAyCredit and Pay cash
 */
public class State1 implements States{

	MDAEFSM mdaefsm = null;

	public State1(MDAEFSM mdaefsm)
	{
		this.mdaefsm=mdaefsm;
	}
	public void Activate() {
		
	}

	
	public void Start() {
		
	}

	//Option of Payment by credit
	public void PayCredit() {
		mdaefsm.setState(mdaefsm.getS2State());
		
	}

	//Option of Payment by Cash
	public void PayCash() {
		
		mdaefsm.output.StoreCash();
		mdaefsm.output.SetW(0);
		mdaefsm.output.DisplayMenu();	
		mdaefsm.setState(mdaefsm.getS3State());
		
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
