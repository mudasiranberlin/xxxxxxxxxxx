package Pac_Abstract_Factory;

import Pac_Data_Store.DS;
import Pac_Data_Store.DS_1;
import Pac_Strategy.*;

/*
 * Concrete Factory 1 that consists of implementations of the Gas Pump-1
 */
public class CF_1 implements AbstractFactory{
	DS obj_ds = new DS_1();
	StoreData obj_stda = new StoreData1();
	PayMsg obj_pams = new PayMsg1();
	StoreCash obj_stca = new StoreCash1();
	DisplayMenu obj_dime = new DisplayMenu1();
	RejectMsg obj_rems = new RejectMsg1();
	SetW obj_setw = new SetW1();
	SetPrice obj_sepr = new SetPrice1();
	ReadyMsg obj_remsg = new ReadyMsg1();
	SetInitialValues obj_setiv = new SetInitialValues1();
	PumpGasUnit obj_pgu = new PumpGasUnit1();
	GasPumpedMsg obj_gpm = new GasPumpedMsg1();
	StopMsg obj_stmsg = new StopMsg1();
	PrintReceipt obj_prre = new PrintReceipt1();
	CancelMsg obj_cmsg = new CancelMsg1();
	
	/*
	 * ALl the implemented methods will return the object for the GAspump-1
	 */
	public void ConcreteFactory(){
		
	}
	
	public DS CreateDataStoreObj(){
		return this.obj_ds;
	}
	public DS GetDataStore(){
		return this.obj_ds;
	}
	public StoreData CreateStoreDataObj(){
		return this.obj_stda;
	}
	public PayMsg CreatePayMsgObj(){
		return this.obj_pams;
	}
	public StoreCash CreateStoreCashObj(){
		return this.obj_stca;
	}
	public DisplayMenu CreateDisplayMenuObj(){
		return this.obj_dime;
	}
	public RejectMsg CreateRejectMsgObj(){
		return this.obj_rems;
	}
	public SetInitialValues CreateSetInitialValues(){
		return this.obj_setiv;
	}
	public PumpGasUnit CreatePumpGasUnitObj(){
		return this.obj_pgu;
	}
	public GasPumpedMsg CreateGasPumpedMsg(){
		return this.obj_gpm;
	}
	public StopMsg CreateStopMsgObj(){
		return this.obj_stmsg;
	}
	public PrintReceipt CreatePrintReceiptObj(){
		return this.obj_prre;
	}
	public CancelMsg CreateCancelMsgObj(){
		return this.obj_cmsg;
	}


	public SetW CreateSetWObj(int k) {
		
		return this.obj_setw;
	}

	
	public SetPrice CreateSetPriceObj(int g) {
		
		return this.obj_sepr;
	}

	
	public ReadyMsg CreateReadyMsgObj() {
		
		return this.obj_remsg;
	}


	public SetInitialValues CreateSetIntialValuesObj() {
		return this.obj_setiv;
	}

	
	public GasPumpedMsg CreateGasPumpedmsgObj() {
		return obj_gpm;
	}
	
}
