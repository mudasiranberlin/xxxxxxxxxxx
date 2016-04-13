import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Pac_Abstract_Factory.CF_1;
import Pac_Abstract_Factory.CF_2;
import Pac_Abstract_Factory.CF_3;
import Pac_Gas_Pump.Gas_Pump_1;
import Pac_Gas_Pump.Gas_Pump_2;
import Pac_Gas_Pump.Gas_Pump_3;
import Pac_Mda_Efsm.MDAEFSM;
import Pac_Output.Output;
/* 
 * Execution Starts from this file
 * Default package Main Driver Class (Main Method)
 */
public class DriverClass
{
    public static void main( String[] args) throws IOException
    {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String in = null;
    	int choice = 1;
    	
    	System.out.println(" *** CS 586 ***" );
    	System.out.println(" *** Project ***" );
    	System.out.println(" *** Demo ***" );
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();

    	System.out.println("Press Enter key to continue");
    	in = bufferedReader.readLine();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	
		System.out.println(" *** Select GP-1, GP-2 or GP-3 ***" );
		System.out.println("          1. GP-1" );
		System.out.println("          2. GP-2" );
		System.out.println("          3. GP-3" );
		 
		in = bufferedReader.readLine();
		if(in.equalsIgnoreCase("1"))
		{
			int a,c,pay;
	    	CF_1 fact = new CF_1();
	    	Output output = new Output(fact,fact.GetDataStore());
	    	MDAEFSM mdaefsm = new MDAEFSM(fact,output);
	    	Gas_Pump_1 gp_1 = new Gas_Pump_1(mdaefsm,fact.GetDataStore());
    	
	        System.out.println("*** Menu of Operations ***" );	
	        System.out.println("          0. Activate(int)" );
	        System.out.println("          1. Start()" );
	        System.out.println("          2. PayCredit()" );
	        System.out.println("          3. Reject()" );
	        System.out.println("          4. Cancel()" );
	        System.out.println("          5. Approved()" );
	        System.out.println("          6. PayCash(int)" );
	        System.out.println("          7. StartPump()" );
	        System.out.println("          8. PumpGallon()" );
	        System.out.println("          9. StopPump()" );
	        System.out.println("          q. Quit the demo program" );
	        System.out.println();
	        System.out.println("  Please make a note of these operations" );	  	    	
	        System.out.println("           GP-1 Execution" );
	          
	        while (true) 
	        {
	        	
	        	System.out.println("  Select Operation: ");
	        	System.out.println("0-Activate,1-Start,2-PayCredit,3-Reject,4-Cancel,5-Approved,6-PayCash,7-StartPump,8-PumpGallon,9-StopPump,q-Quit");
	             
				in = bufferedReader.readLine();
	
	            if(in.isEmpty()) continue;
	            if(in.equalsIgnoreCase("q"))
	            	break;
	            
	            choice = Integer.parseInt(in);
	            
	            switch(choice)
	            {
	             case 0:   //Activating
	      			System.out.println("  Operation:  Activate(int a)\n");
	      			System.out.println("  Enter value of the parameter a:");
	      			in = bufferedReader.readLine();
	      			a = Integer.parseInt(in);
	      			gp_1.Activate(a);
	      			break;
	      			
		      	 case 1:   //Start operation
		      			System.out.println("  Operation:  Start()");
		      			gp_1.Start();
		      			break;
	
		      	   case 2:  //PayCredit
		      			System.out.println("  Operation: PayCredit()");
		      			System.out.println("  Waiting for approval of Credit Card");
		      			gp_1.PayCredit();
		      			break;
	
		      	    case 3:  //Reject
		      			System.out.println("  Operation:  Reject()");
		      			gp_1.Reject();
		      			break;
		      				
		      	  case 4:  //Cancel
		      			System.out.println("  Operation:  Cancel()");
		      			gp_1.Cancel();
		      			break;
	
		      	    case 5:  // Approved
		      			System.out.println("  Operation:  Approved()");
		      			gp_1.Approved();
		      			break;
	
		      	    case 6:  // PayCash
		      			System.out.println("  Operation:  PayCash(int c)");
		      			System.out.println(" Enter the Amount:");
		      			in = bufferedReader.readLine();
		      			c = Integer.parseInt(in);
		      			gp_1.PayCash(c);
		      			break;
	
		      	    case 7:  // StartPump
		      			System.out.println("  Operation:  StartPump()");		
		      			gp_1.StartPump();
		      			break;
	
		      	    case 8:  // PumpGallon
		      			System.out.println("  Operation:  PumpGallon()");
		      			gp_1.PumpGallon();
		      			break;
		      		
		      	  case 9:  // StopPump
		      			System.out.println("  Operation:  StopPump()");
		      			gp_1.StopPump();
		      			break;
		      			
		      		default:
		      			System.out.println("Invalid Choice!!! Enter a Valid Choice");
		      			break;
	            }
	        }
	        System.out.println("Thanks for using Gas Pump - 1" );
		}
		else if(in.equalsIgnoreCase("2"))
		{
			float a,b,c;
			CF_2 fact = new CF_2();
	    	Output output = new Output(fact,fact.GetDataStore());
	    	MDAEFSM mdaefsm = new MDAEFSM(fact,output);
	    	Gas_Pump_2 gp_2 = new Gas_Pump_2(mdaefsm,fact.GetDataStore());
    	
	    	System.out.println("*** Menu of Operations ***" );	
	        System.out.println("          0. Activate(float, float)" );
	        System.out.println("          1. Start()" );
	        System.out.println("          2. PayCredit()" );
	        System.out.println("          3. Reject()" );
	        System.out.println("          4. Cancel()" );
	        System.out.println("          5. Approved()" );
	        System.out.println("          6. Super()" );
	        System.out.println("          7. Regular()" );
	        System.out.println("          8. StartPump()" );
	        System.out.println("          9. PumpGallon()" );
	        System.out.println("          10. StopPump()" );
	        System.out.println("          q. Quit the demo program" );	
	        System.out.println("  Please make a note of these operations" );	  	    	
	        System.out.println("           GP-2 Execution" );
	          
	        while (true) 
	        {
	        	System.out.println("  Select Operation: ");
	        	System.out.println("0-Activate,1-Start,2-PayCredit,3-Reject,4-Cancel,5-Approved,6-Super,7-Regular,8-StartPump,9-PumpGallon,10-StopPump,q-Quit");
				in = bufferedReader.readLine();
	            if(in.isEmpty()) continue;
	            if(in.equalsIgnoreCase("q"))
	            	break;
	            
	            choice = Integer.parseInt(in);
	            
	            switch(choice)
	            {
	             case 0:   //Activating
	      			System.out.println(" Operation:  Activate(float a, float b)");
	      			System.out.println("   Enter value of the parameter a:");
	      			in = bufferedReader.readLine();
	      			a = Integer.parseInt(in);
	      			
	      			System.out.println("   Enter value of the parameter b:");
	      			in = bufferedReader.readLine();
	      			b = Integer.parseInt(in);
	      			gp_2.Activate(a,b);
	      			break;
	      			
		      	 case 1:   //Start Operation
		      			System.out.println("  Operation:  Start()");
		      			gp_2.Start();
		      			break;
	
		      	   case 2:  //PayCredit Operation
		      			System.out.println("  Operation:  PayCredit()");
		      			System.out.println("  Waiting for approval");
		      			gp_2.PayCredit();
		      			break;
	
		      	    case 3:  //Reject Operation
		      			System.out.println("  Operation:  Reject()");
		      			gp_2.Reject();
		      			break;
		      				
		      	  case 4:  //Cancel Operation
		      			System.out.println("  Operation:  Cancel()");
		      			gp_2.Cancel();
		      			break;
	
		      	    case 5:  // Approved Operation
		      			System.out.println("  Operation:  Approved()");
		      			gp_2.Approved();
		      			break;
	
		      	  case 6:  // Super Operation
		      			System.out.println("  Operation:  Super()");
		      			gp_2.Super();
		      			break;
		      			
		      	  case 7:  // Regular
		      		  	System.out.println("  Operation:  Regular()");
		      		  	gp_2.Regular();
		      		  	break;
		     
	
		      	    case 8:  // StartPump
		      			System.out.println("  Operation:  StartPump()");		
		      			gp_2.StartPump();
		      			break;
	
		      	    case 9:  // PumpGallon
		      			System.out.println("  Operation:  PumpGallon()");
		      			gp_2.PumpGallon();
		      			break;
		      		
		      	  case 10:  // StopPump
		      			System.out.println("  Operation:  StopPump()");
		      			gp_2.StopPump();
		      			break;
		      			
		      		default:
		      			System.out.println("Invalid Choice!!! Enter a Valid Choice");
		      			break;
	            }
	        }
	        System.out.println("Thanks for using Gas Pump - 2" );
		}
		else if(in.equalsIgnoreCase("3"))
		{
			float a,b,c;
			CF_3 fact = new CF_3();
	    	Output output = new Output(fact,fact.GetDataStore());
	    	MDAEFSM mdaefsm = new MDAEFSM(fact,output);
	    	Gas_Pump_3 gp_3 = new Gas_Pump_3(mdaefsm,fact.GetDataStore());
	    	
	        System.out.println("*** Menu of Operations ***" );	
	        System.out.println("          0. Activate(float, float)" );
	        System.out.println("          1. Start()" );
	        System.out.println("          2. PayCash(float c)" );
	        System.out.println("          3. Cancel()" );
	        System.out.println("          4. Premium()" );
	        System.out.println("          5. Regular()" );
	        System.out.println("          6. StartPump()" );
	        System.out.println("          7. PumpLiter()" );
	        System.out.println("          8. StopPump()" );
	        System.out.println("          9. Receipt()" );
	        System.out.println("          10.No-Receipt()" );
	        System.out.println("          q. Quit the demo program" );	
	        System.out.println("  Please make a note of these operations" );	  	    	
	        System.out.println("           GP-3 Execution" );
	          
	        while (true) 
	        {
	        	
	        	System.out.println("  Select Operation: ");
	        	System.out.println("0-Activate,1-Start,2-PayCash,3-Cancel,4-Premium,5-Regular,6-StartPump,7-PumpLiter,8-StopPump,9-Receipt,10-No-Receipt,q-Quit");
	             
				in = bufferedReader.readLine();
	            if(in.isEmpty()) continue;
	            if(in.equalsIgnoreCase("q"))
	            	break;
	            
	            choice = Integer.parseInt(in);
	            
	            switch(choice)
	            {
	             case 0:   //Activating Operation
	      			System.out.println(" Operation:  Activate(float a, float b)");
	      			System.out.println("   Enter value of the parameter a:");
	      			in = bufferedReader.readLine();
	      			a = Integer.parseInt(in);
	      			System.out.println("   Enter value of the parameter b:");
	      			in = bufferedReader.readLine();
	      			b = Integer.parseInt(in);
	      			gp_3.Activate(a,b);
	      			break;
	      			
		      	 case 1:   //Start Operation
		      			System.out.println(" Operation:  Start()");
		      			gp_3.Start();
		      			break;
	
		      	   case 2:  //PayCash
		      			System.out.println("  Operation:  PayCash(float c)");
		      			System.out.println(" Enter the Amount:");
		      			in = bufferedReader.readLine();
		      			c = Integer.parseInt(in);
		      			gp_3.PayCash(c);
		      			break;
	
		      				
		      	  case 3:  //Cancel Operation
		      			System.out.println("  Operation:  Cancel()");
		      			gp_3.Cancel();
		      			break;
	
		      	  case 4:  // Premium
		      			System.out.println("  Operation:  Premium()");
		      			gp_3.Premium();
		      			break;
		      			
		      	  case 5:  // Regular Operation
		      		  	System.out.println("  Operation:  Regular()");
		      		  	gp_3.Regular();
		      		  	break;
		     
	
		      	    case 6:  // StartPump
		      			System.out.println("  Operation:  StartPump()");		
		      			gp_3.StartPump();
		      			break;
	
		      	    case 7:  // PumpLiter
		      			System.out.println("  Operation:  PumpLiter()");
		      			gp_3.PumpLiter();
		      			break;
		      		
		      	  case 8:  // StopPump Operation
		      			System.out.println("  Operation:  StopPump()");
		      			gp_3.StopPump();
		      			break;
		      			
		      	 case 9:  // Receipt Operation
		      			System.out.println("  Operation:  Receipt()");
		      			gp_3.Receipt();
		      			break;
		      			
		      	 case 10:  // No-Receipt Operation
		      			System.out.println("  Operation:  NoReceipt()");
		      			gp_3.NoReceipt();
		      			break;
		      			
		      		default:
		      			System.out.println("Invalid Choice");
		      			break;
	            }
	        }
	        System.out.println("Thanks for using Gas Pump - 3" );
		}
    }
}
	       
