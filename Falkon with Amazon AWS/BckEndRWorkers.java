import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class BckEndRWorkers {
	public static void ProcessTask(List<String> tasks) {
		
		PoolingService.init(5);

        Scheduler.start = System.currentTimeMillis();
        System.out.println(Scheduler.start);

	       
        Iterator<String> i = tasks.iterator();
				while(i.hasNext()){
					String a = i.next();
					String work = a.substring(1,a.length()-1 );
					String k = work.split("=")[0];
					int val = Integer.parseInt(work.split("=")[1]);
			   		System.out.println(k+ " : " + val);
			   			HashMap<String, Integer> t =  new HashMap<String, Integer>();
			   			t.put(k, val);
			   			
			   		  DynamoDB d= new DynamoDB();
				    	
				    	int c = d.num(k,k);
				    	
				if(c==1)
				{
					PoolingService.addTask(t);
				}
				else{
				System.out.println("Task Removed");
				}
				}
			
       PoolingService.stop();
   		}
 
	public static void main(String args[]){
		
				
		int  taskNo = Integer.parseInt(args[0]);
		List<String> t = new ArrayList<String>();
		boolean count = true;
		 while (count) {
				String tsk = SimpleQueueService.executeRemoteWorkers(taskNo);
		    	System.out.println(tsk);
		    	if(!tsk.equals(""))
		    		t.add(tsk);
		    	else{
		    		 if(!t.isEmpty()){
		    			 count = false;	
		    			 ProcessTask(t);
		    		 }
		    		 else{
		    			 System.out.println("Try after 2 mins");
						try {
							Thread.currentThread().sleep(12000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		    		 }
		    	}
		 }
	}
}
