import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			ObjectOutputStream outP; 
			Socket sock;
	        
			String file;
	        ObjectInputStream inP;
	        
	        
	        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
	        
	        int port=Integer.parseInt(args[1]);
	        String hostname=args[0];
	        sock = new Socket(hostname,port);
	        
	       
	        inP = new ObjectInputStream(sock.getInputStream());
	        outP = new ObjectOutputStream(sock.getOutputStream());
	        
	        System.out.println("Please feed the Job file");
	        file = (String)buff.readLine();
	       
	 	    BufferedReader buff_file = new BufferedReader(new FileReader(file));
	        
	 	    String ln="" , inf = "";
	        ln = buff_file.readLine();
	        
	        while(ln != null){
	       			        inf = inf + "%" + ln;
	       			     ln = buff_file.readLine();
	        }
	        inf = inf +"%END";
	        outP.writeUTF(inf);
	        outP.flush();
	        
	        System.out.println(inf);
	        System.out.println("File Sending Successfull");
	        
	        int count = inP.read();	        
	        if(count == 1){
			inP.close();
	        outP.close();
	        buff.close();         
	        sock.close();
	        System.out.println("Acknowledged");
	        System.out.println("Terminate Connection..!");
	        }
		} 
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
	}
}
