package Pac_Output;
import Pac_Data_Store.*;
import Pac_Strategy.*;
import Pac_Abstract_Factory.AbstractFactory;

/*
 * OutPut Processor Consists link with Abstract Factory and DataStore(DS)
 */
public class Output {
	//Objects for AF and DS
	AbstractFactory factory =null;
	DS data_store_obj = null;
	
	//Constructor for setting the object values
	public Output(AbstractFactory factory,DS dataStore) 
	{
        this.factory = factory;
        this.data_store_obj = dataStore;
    }

	//Action that stores data values
	public void StoreData()
	{
		String temp_s = data_store_obj.getClass().getName();
		
		System.out.println(" OUTPUT-> Action StoreData");
		StoreData sd = factory.CreateStoreDataObj();
		
		if(temp_s == "data_store.DataStore1")
		{
			sd.StoreData(data_store_obj);
			SetPrice(((DS_1)data_store_obj).temp_a);
		}
		
		else
		{
			sd.StoreData(data_store_obj, data_store_obj);
		}
		
	}
	
	//Action PayMsg to know the type of Paymet options
	public void Pay_Msg()
	{
		System.out.println(" OUTPUT-> Action Pay_Msg");
		PayMsg pay_msg = factory.CreatePayMsgObj();
		pay_msg.PayMsg();
	}
	
	//Action to Store Cash
	public void StoreCash()
	{
		System.out.println(" OUTPUT-> Action StoreCash");
		StoreCash store_cash = factory.CreateStoreCashObj();
		store_cash.StoreCash(data_store_obj);
	}
	
	//Action to Display menu option
	public void DisplayMenu()
	{
		System.out.println("OUTPUT-> Action DisplayMenu");
		DisplayMenu disp_menu = factory.CreateDisplayMenuObj();
		disp_menu.DisplayMenu();
	}
	
	//Action to print Reject message option
	public void RejectMsg()
	{
		System.out.println("OUTPUT-> Action RejectMsg");
		RejectMsg reject_msg = factory.CreateRejectMsgObj();
		reject_msg.RejectMsg();
	}
	
	//Action to Set W value
	public void SetW(int temp)
	{
		System.out.println("OUTPUT-> Action SetW");
		SetW set_w = factory.CreateSetWObj(temp);
	}
	
	//Action to Set price that sets price value
	public void SetPrice(int temp_price)
	{
		System.out.println("OUTPUT-> Action SetPrice ");
		SetPrice set_price = factory.CreateSetPriceObj(temp_price);
		set_price.SetPrice(data_store_obj,temp_price);
	}
	
	
	//Action ReadyMessage to print the Pump is ready to Pump
	public void ReadyMsg()
	{
		System.out.println("OUTPUT-> Action ReadyMsg ");
		ReadyMsg ready_msg = factory.CreateReadyMsgObj();
		ready_msg.ReadyMsg();
	}
	
	//Initializing the G, L and total Values
	public void SetInitialValues()
	{
		System.out.println("OUTPUT-> Action SetInitialValues ");
		SetInitialValues set_values = factory.CreateSetIntialValuesObj();
		set_values.SetInitialValues(data_store_obj);
	}
	
	//Action that disposed no. pumped gas units
	public void PumpGasUnit()
	{
		System.out.println("OUTPUT-> Action PumpGasUnit  ");
		PumpGasUnit pump_obj = factory.CreatePumpGasUnitObj();
		pump_obj.PumpGasUnit(data_store_obj);
	}
	
	//Action displays the amount of disposed gas
	public void GasPumpedMsg()
	{
		System.out.println("OUTPUT-> Action GasPumpedMsg  ");
		GasPumpedMsg gas_pump_obj = factory.CreateGasPumpedmsgObj();
		gas_pump_obj.GasPumpedMsg(data_store_obj);
	}
	
	//Action stop pump message and receipt
	public void StopMsg()
	{
		System.out.println("OUTPUT-> Action StopMsg  ");
		StopMsg stop_msg_obj = factory.CreateStopMsgObj();
		stop_msg_obj.StopMsg();
	}
	// Action print a receipt
	public void PrintReceipt()
	{
		System.out.println("OUTPUT-> Action PrintReceipt  ");
		PrintReceipt print_obj = factory.CreatePrintReceiptObj();
		print_obj.PrintReceipt(data_store_obj);
	}
	//Action Cancellation message
	public void CancelMsg()
	{
		System.out.println("OUTPUT-> Action CancelMsg  ");
		CancelMsg cancel_msg_obj = factory.CreateCancelMsgObj();
		cancel_msg_obj.CancelMsg();
	}
	
}
