import java.io.*;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
class Node{
    public HashMap<String, Integer> item;
    public Node next;
    public Node(HashMap<String, Integer> val){ 
        item = val; 
    }
    public void displayNode(){ 
        System.out.print("[" + item + "]"); 
    }
	public HashMap<String, Integer> getData() {
		return item;
	}
}
class LinkedList{
    private Node begin;
    private Node finish;
    public LinkedList(){
        begin = null;
        finish = null;
    }
    public boolean empty(){ 
        return begin==null; 
    }
    public void insertEnd(HashMap<String, Integer> val){
    	
        Node newNode = new Node(val);
        if( empty() )
            begin = newNode;
        else
            finish.next = newNode;
        finish = newNode;
    }
    public HashMap<String, Integer> deQueue(){
    	
        HashMap<String, Integer> tmp = begin.item;
        if(begin.next == null)
            finish = null;
        begin = begin.next;
        return tmp;
    }
    public void displayList(){
        Node cur = begin;
        while(cur != null)
        {
            cur.displayNode();
            cur = cur.next;
        }
        System.out.println("");
    }
	public void readandProcessElement(String qName) {
		Node cur1 = begin;
		AmazonSQS sqs = null;
        while(cur1 != null)
        {
           HashMap<String, Integer> data =  cur1.getData();
            System.out.println("element "+data);
            try {
            	 sqs =SimpleQueueService.push(data,qName);
            	
            	
			} catch (Exception e) {
				e.printStackTrace();
			}
            cur1 = cur1.next;
        }
        System.out.println();System.out.println();System.out.println();
	}
	public void push() {
		
		Node cur2 = begin;
		AmazonSQS sqs = null;
           HashMap<String, Integer> data =  cur2.getData();
            System.out.println("element "+data);
            try {
            	 sqs =SimpleQueueService.push(data, "resultQueue");            	            	
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        
	}
}
class Queue{
    private LinkedList listObj;
    public Queue(){
        listObj = new LinkedList(); 
    }
    public boolean isEmpty(){ 
        return listObj.empty(); 
    }
    public void insert(HashMap<String, Integer> k){ 
        listObj.insertEnd(k); 
    }
    public HashMap<String, Integer> deQueue(){ 
        return listObj.deQueue(); 
    }
    public void display(){
        System.out.print("Queue [FIFO]: ");
        listObj.displayList();
    }
	public void processElement() {
		listObj.readandProcessElement("taskQueue");
	}
	public void pushIntoSQS() {
		
		listObj.push();
	}
}
class CreateQueue{
	public static long start;
	public static Queue result = new Queue();
    public static void main(String[] args){ 
        Queue demo = new Queue();
        int i = 1;
        System.out.println("Elements inserted into Queue");
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        a.put("sleep 1000", i);
        i++;
        demo.insert(a);
        a.put("sleep 200", i);
        i++;
        demo.insert(a);
        a.put("sleep 300", i);
        i++;
        demo.insert(a);
        a.put("sleep 600", i);
        i++;
        demo.insert(a);
        a.put("sleep 1300", i);
        i++;
        demo.insert(a);
                
        demo.display();
        
        System.out.println("Processing elements");
     
       
       demo.processElement();
        String tasks = SimpleQueueService.show();
       tasks =  tasks.substring(1, tasks.length()-1);
        System.out.println(tasks.split(",")[4]);
            	
    }
	 
}