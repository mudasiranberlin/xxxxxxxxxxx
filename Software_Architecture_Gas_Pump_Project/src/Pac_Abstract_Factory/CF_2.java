package Pac_Abstract_Factory;

import Pac_Data_Store.DS;
import Pac_Data_Store.DS_2;
import Pac_Strategy.*;
/*
 * Concrete Factory 2 that consists of implementations of the Gas Pump-2
 */
public class CF_2 implements AbstractFactory{
	
	DS obj_ds = new DS_2();
	StoreData obj_stda = new StoreData2();
	PayMsg obj_pamsg = new PayMsg2();
	DisplayMenu obj_dime = new DisplayMenu2();
	RejectMsg obj_remsg = new RejectMsg2();
	ReadyMsg obj_readymsg = new ReadyMsg2();
	SetPrice obj_sepri = new SetPrice2();
	SetInitialValues obj_setiv = new SetInitialValues2();
	PumpGasUnit obj_pgu = new PumpGasUnit2();
	GasPumpedMsg obj_gpumsg = new GasPumpedMsg2();
	StopMsg obj_stmsg = new StopMsg2();
	PrintReceipt obj_prrec = new PrintReceipt2();
	CancelMsg obj_cmsg = new CancelMsg2();
	
	
	/*
	 * ALl the implemented methods will return the object for the GAspump-2
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
		return this.obj_pamsg;
	}
	public DisplayMenu CreateDisplayMenuObj(){
		return this.obj_dime;
	}
	public RejectMsg CreateRejectMsgObj(){
		return this.obj_remsg;
	}
	public SetInitialValues CreateSetInitialValues(){
		return this.obj_setiv;
	}
	public PumpGasUnit CreatePumpGasUnitObj(){
		return this.obj_pgu;
	}
	public GasPumpedMsg CreateGasPumpedMsg(){
		return this.obj_gpumsg;
	}
	public StopMsg CreateStopMsgObj(){
		return this.obj_stmsg;
	}
	public PrintReceipt CreatePrintReceiptObj(){
		return this.obj_prrec;
	}
	public CancelMsg CreateCancelMsgObj(){
		return this.obj_cmsg;
	}

	public SetW CreateSetWObj(int k) {
		return null;
	}


	public SetPrice CreateSetPriceObj(int g) {
		return obj_sepri;
	}


	public ReadyMsg CreateReadyMsgObj() {
		return obj_readymsg;
	}

	public SetInitialValues CreateSetIntialValuesObj() {
		return this.obj_setiv;
	}

	public GasPumpedMsg CreateGasPumpedmsgObj() {
		return this.obj_gpumsg;
	}

	public StoreCash CreateStoreCashObj() {
		return null;
	}
	

}
