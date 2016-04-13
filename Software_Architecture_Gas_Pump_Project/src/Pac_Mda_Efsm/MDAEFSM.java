package Pac_Mda_Efsm;

import Pac_Abstract_Factory.AbstractFactory;
import Pac_Output.Output;
/*
 * Class MDAEFSM which consists of the methods and the implemtation of next states
 */
public class MDAEFSM {
	
	States start_state = new StartState(this);
	
	//Objects for all states
	States state0 = new State0(this);
	States state1 = new State1(this);
	States state2 = new State2(this);
	States state3 = new State3(this);
	States state4 = new State4(this);
	States state5 = new State5(this);
	States state6 = new State6(this);
	
	Output output = null;
	States efsmState = null;
	AbstractFactory factory =null;
	
	//Constructor to set the object values
	public MDAEFSM (AbstractFactory fact, Output out)
	{
		efsmState = start_state;
        this.factory = fact;
        this.output = out;
	}
	
	/*
	 * Methods implementation to the next state 
	 */
	public void activate()
	{
		efsmState.Activate();
		printCurrentState();
	}
	
	public void Start ()
	{
		efsmState.Start();
		printCurrentState();
	}
	
	public void PayCredit()
	{
		efsmState.PayCredit();
		printCurrentState();
	}
	
	public void Reject()
	{
		efsmState.Reject();
		printCurrentState();
	}
	
	public void Cancel()
	{
		efsmState.Cancel();
		printCurrentState();
	}
	
	public void Approved()
	{
		efsmState.Approved();
		printCurrentState();
	}
	
	public void PayCash()
	{
		efsmState.PayCash();
		printCurrentState();
	}
	
	public void StartPump()
	{
		efsmState.StartPump();
		printCurrentState();
	}
	
	public void Pump()
	{
		efsmState.Pump();
		printCurrentState();
	}
	
	public void StopPump()
	{
		efsmState.StopPump();
		printCurrentState();
	}
	
	public void SelectGas(int i)
	{
		efsmState.SelectGas(i);
		printCurrentState();
	}
	
	public void Receipt()
	{
		efsmState.Receipt();
		printCurrentState();
	}
	
	public void NoReceipt()
	{
		efsmState.NoReceipt();
		printCurrentState();
	}
	
    public void setState(States efsmState) 
    {
        this.efsmState = efsmState;
    }
    public States getGasPumpState() 
    {
        return efsmState;
    }
    
    public States getS0State() 
    {
        return state0;
    }
    public States getS1State() 
    {
        return state1;
    }
    public States getS2State() 
    {
        return state2;
    }
    
    public States getS3State() 
    {
        return state3;
    }
    
    public States getS4State() 
    {
        return state4;
    }
    
    public States getS5State() 
    {
        return state5;
    }
    
    public States getS6State() 
    {
        return state6;
    }
	public void printCurrentState()
	{
		System.out.println("The Current State is :"+ efsmState.getClass().getName());
	}
}
