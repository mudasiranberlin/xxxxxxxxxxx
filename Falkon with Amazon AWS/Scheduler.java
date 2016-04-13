import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Scheduler 
{
	public static float start;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args)
	{ 
		
		try 
		{
	        int az=1,count=1;
	        int port=Integer.parseInt(args[2]);
	        String type =  args[3];
 	
	        	
	        	 int n  =  Integer.parseInt(args[4]);
		        ServerSocket servSock = new ServerSocket(port);
		        Socket con = null;
		        String jobs,file;
		        ObjectOutputStream out;
		        ObjectInputStream in;
		       while(true){

			        System.out.println("Connecting Please Wait ");
			        con = servSock.accept();
			        System.out.println("Connected to " + con.getInetAddress().getHostName());
			   
			        out = new ObjectOutputStream(con.getOutputStream());
			        in = new ObjectInputStream(con.getInputStream());
			        
			        System.out.println("connection Established");
			        Queue q = new Queue();
			        
			        boolean count1 = true;
					jobs = (String)in.readUTF();
			        System.out.println("job from Client is : " + jobs);
			        String[] d3 = jobs.split("%");
			  	    int j =0;
			  	    while(!d3[j].equals("END")){
			  	        	HashMap<String, Integer> a = new HashMap<String, Integer>();
			  	        	a.put(d3[j], j);
			  	        	q.insert(a);
			  	        	j++;
			  	     }
			  	    out.writeInt(1);
			  	    out.flush();
					System.out.println("File Recieved");
			       
			        System.out.println("Acknowledge Sent");

			        if(type.equals("lw")){
			        	
				         start = System.currentTimeMillis();
				        System.out.println(start);
				        PoolingService.init(n);
				      Queue res =  BckEndLWorkers.ProcessTask(q);
				       res.display();
				        
			        }else{
			        	q.processElement();
			        	start = System.currentTimeMillis();
			        	int size = SimpleQueueService.ResultQueue();
			        	if(size > 0)
			        		System.out.println("Result Queue received "+size);
			      			        	
			        }
		       }
	        
		} 
	    catch (Exception e) 
	    {
	        System.out.println(e);
	    }
		}
}
