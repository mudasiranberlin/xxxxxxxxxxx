package Pac_Abstract_Factory;


import Pac_Data_Store.DS;
import Pac_Data_Store.DS_3;
import Pac_Strategy.*;
/*
 * Concrete Factory 3 that consists of implementations of the Gas Pump-3
 */
public class CF_3 implements AbstractFactory{

	
	DS obj_ds = new DS_3();
	StoreData obj_stda = new StoreData3();
	PayMsg obj_pmsg = new PayMsg3();
	StoreCash obj_stca = new StoreCash3();
	DisplayMenu obj_dime = new DisplayMenu3();
	ReadyMsg obj_reamsg = new ReadyMsg3();
	SetInitialValues obj_setiv = new SetInitialValues3();
	SetPrice obj_setpri = new SetPrice3();
	PumpGasUnit obj_pgu = new PumpGasUnit3();
	GasPumpedMsg obj_gpmsg = new GasPumpedMsg3();
	StopMsg obj_stmsg = new StopMsg3();
	PrintReceipt obj_prrecpt = new PrintReceipt3();
	CancelMsg obj_cmsg = new CancelMsg3();
	
	/*
	 * ALl the implemented methods will return the object for the GAspump-3
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
		return this.obj_pmsg;
	}
	public StoreCash CreateStoreCashObj(){
		return this.obj_stca;
	}
	public DisplayMenu CreateDisplayMenuObj(){
		return this.obj_dime;
	}
	public RejectMsg CreateRejectMsgObj(){
		return null;
	}
	public SetInitialValues CreateSetInitialValues(){
		return this.obj_setiv;
	}
	public PumpGasUnit CreatePumpGasUnitObj(){
		return this.obj_pgu;
	}
	public GasPumpedMsg CreateGasPumpedMsg(){
		return this.obj_gpmsg;
	}
	public StopMsg CreateStopMsgObj(){
		return this.obj_stmsg;
	}
	public PrintReceipt CreatePrintReceiptObj(){
		return this.obj_prrecpt;
	}
	public CancelMsg CreateCancelMsgObj(){
		return this.obj_cmsg;
	}
	public SetW CreateSetWObj(int k) {
		return null;
	}

	public SetPrice CreateSetPriceObj(int g) {
		return this.obj_setpri;
	}

	public ReadyMsg CreateReadyMsgObj() {
		return this.obj_reamsg;
	}

	public SetInitialValues CreateSetIntialValuesObj() {
		return this.obj_setiv;
	}

	public GasPumpedMsg CreateGasPumpedmsgObj() {
		return this.obj_gpmsg;
	}
	
	
}
