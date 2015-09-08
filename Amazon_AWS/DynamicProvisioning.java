import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;


public class DynamicProvisioning {
	
public static void cloudWatch() {
		
		String id = null;
		String key = null;
		InputStream credStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("AwsCredentials.properties");
		AWSCredentials creds = null;
		try {
			creds = new PropertiesCredentials(credStream);
			id =(creds.getAWSAccessKeyId());
			key =(creds.getAWSSecretKey());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		AmazonCloudWatchClient cwClient = new AmazonCloudWatchClient((AWSCredentials) new BasicAWSCredentials(id, key));
		    cwClient.setEndpoint("monitoring.eu-west-1.amazonaws.com");
		   
		   int instances = CreateAwsInstance.getNumberOfInstances();
		   int size =  SimpleQueueService.getNumberOFTasksRunning();
		   
		  
		   if(size >1000  && size <=3000 && instances <=2)
			   CreateAwsInstance.launch(2);
		   else if(size > 3000 && size <= 5000 && instances <= 4)
			   CreateAwsInstance.launch(4);
		   else if(size > 5000 && size <= 20000 && instances <= 8)
			   CreateAwsInstance.launch(8);
		   else if(size > 20000 && size <= 30000 && instances <= 16)
			   CreateAwsInstance.launch(16);
		   else if(size > 50000 && instances <= 32)
			   CreateAwsInstance.launch(32);

		  
		
	}

public static void main(String args[]){
	
	
	while(true){
	cloudWatch();
	try {
		System.out.println("try again later");
		Thread.currentThread().sleep(100000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}

}
