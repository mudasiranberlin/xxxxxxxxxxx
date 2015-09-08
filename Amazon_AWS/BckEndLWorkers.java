import java.util.HashMap;


public class BckEndLWorkers {
	public static Queue ProcessTask(Queue q) {			
    	while(!q.isEmpty()){
    			HashMap<String, Integer> work =  q.deQueue();
    			PoolingService.insertTasKInLW(work);
    			System.out.println("Work Inserted"+work);
    	}
    	PoolingService.stop();
    	return PoolingService.res_queue;
   		}
}
