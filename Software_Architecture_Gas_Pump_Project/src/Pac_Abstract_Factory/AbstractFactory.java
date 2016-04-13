package Pac_Abstract_Factory;
import Pac_Data_Store.*;
import Pac_Strategy.*;


/*
 * Abstract Factory Interface consists of all the methods overridden in the concrete factory
 */
public interface AbstractFactory 
{
	public DS CreateDataStoreObj();
	public StoreData CreateStoreDataObj();
	public PayMsg CreatePayMsgObj();
	public StoreCash CreateStoreCashObj();
	public DisplayMenu CreateDisplayMenuObj();
	public RejectMsg CreateRejectMsgObj();
	public SetW CreateSetWObj(int k);
	public SetPrice CreateSetPriceObj(int g);
	public ReadyMsg CreateReadyMsgObj();
	public SetInitialValues CreateSetIntialValuesObj();
	public PumpGasUnit CreatePumpGasUnitObj();
	public GasPumpedMsg CreateGasPumpedmsgObj();
	public StopMsg CreateStopMsgObj();
	public PrintReceipt CreatePrintReceiptObj();
	public CancelMsg CreateCancelMsgObj();
	
	
}
