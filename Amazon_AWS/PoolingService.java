import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class PoolingService 
{
	public static Set<Callable<String>> callables = new HashSet<Callable<String>>();
	public static ExecutorService executorService;
	public static  Queue res_queue = new Queue();
	

	public static void addTask(final HashMap<String, Integer> task) 
	{
		String k = null;
		Integer val;
		HashMap<String, Integer> r = new HashMap<String, Integer>();
		for(Map.Entry<String, Integer> e : task.entrySet())
		{
			k = e.getKey();
			val = e.getValue();
		}
		System.out.println(" Task is submitted "+k);
		final String data = k;
		Future f = executorService.submit(new Runnable() {
			    public void run() {
			    	try{
						
			    		System.out.println(data);
			    		int t1 = Integer.parseInt(data.split(" ")[1]);
			    		System.out.println("Sleep time "+t1+" ms");
			    		Thread.sleep(t1);
			    		HashMap<String, Integer> s = new HashMap<String, Integer>();
			            s.put(data, 0);
			            
			    		res_queue.insert(s);
			    		
			    		System.out.println("Thread is Awake");
			    		}
			    	catch(InterruptedException e)
			    	{
			    			HashMap<String, Integer> a = new HashMap<String, Integer>();
			    			a.put(data, 1);
			    			res_queue.insert(a);
			    			e.printStackTrace();
			    		}
			    }
		});
		try {
			if(f.get() == null)
			res_queue.pushIntoSQS();	
						
				res_queue.display();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
				
	}



	public static void stop() 
	{
		PrintWriter out=null;
		try {
			out = new PrintWriter (new FileWriter("output.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println((System.currentTimeMillis() - Scheduler.start)/1000);
		// TODO Auto-generated method stub
		executorService.shutdown();
		System.out.println((System.currentTimeMillis() - Scheduler.start)/1000);
		System.out.println("Executore Stooped");
		
	}



	public static void init(int n) 
	{
		// TODO Auto-generated method stub
		executorService = Executors.newFixedThreadPool(n);
		System.out.println("Executor is Started");
	}



	public static void insertTasKInLW(HashMap<String, Integer> t) 
	{
		// /insert a task to the executer service as a runnable task which will execute the sleep method and pushes the result into result Queue
		
		String k = null;
		Integer v;
		HashMap<String, Integer> a = new HashMap<String, Integer>();
		for(Map.Entry<String, Integer> e : t.entrySet())
		{
			k = e.getKey();
			v = e.getValue();
		}
		System.out.println("Task is submittied "+k);
		final String data = k;
		Future f = executorService.submit(new Runnable() {
			    public void run() {
			    	try{
						
			    		System.out.println(data);
			    		int time = Integer.parseInt(data.split(" ")[1]);
			    		System.out.println("Sleep time "+time+" ms");
			    		Thread.sleep(time);
			    		HashMap<String, Integer> a = new HashMap<String, Integer>();
			            a.put(data, 0);
			            
			    		res_queue.insert(a);
			    		
			    		System.out.println("Thread is Awake");
			    		}catch(InterruptedException e){
			    			HashMap<String, Integer> a = new HashMap<String, Integer>();
			    			a.put(data, 1);
			    			res_queue.insert(a);
			    			e.printStackTrace();
			    		}
			    }
		});
				res_queue.display();
		
			
	}
}
