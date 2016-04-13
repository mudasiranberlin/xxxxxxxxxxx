import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.services.cloudwatch.model.Metric;
import com.amazonaws.services.cloudwatch.model.StandardUnit;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupResult;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.services.ec2.model.MonitorInstancesRequest;
import com.amazonaws.services.ec2.model.Monitoring;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;


public class CreateAwsInstance {

	public static void launch(int noAmazonInstances){
		
		AmazonEC2Client awsClient = createClient();
		
	    
						  RunInstancesRequest req = new RunInstancesRequest();
							  
						        	
						  req.withImageId("ami-9eaa1cf6")
						                     .withInstanceType("t2.micro")
						                     .withMinCount(1)
						                     .withMaxCount(noAmazonInstances)
						                     .withKeyName("HI")
						                     .withSecurityGroups("HELLO");
						  
						  RunInstancesResult runInstancesResult =  awsClient.runInstances(req);
						  
						  System.out.println("Launch Successfull");
							
	}
	
	public static void main(String args[]){
				
		AmazonEC2Client ec2 = createClient();
		securityInfo(ec2);
		launch(5);
		//EnableClouWathc();
		getNumberOfInstances();
		
	}

	

	private static AmazonEC2Client createClient() {
		
		InputStream credStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("AwsCredentials.properties");
		AWSCredentials creds = null;
		try {
			creds = new PropertiesCredentials(credStream);
			System.out.println(creds.getAWSAccessKeyId());
			System.out.println(creds.getAWSSecretKey());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
				
				AmazonEC2Client amazClient=   new AmazonEC2Client(creds);
						amazClient.setEndpoint("ec2.us-east-1.amazonaws.com");
					
		return amazClient;
	}

	private static void securityInfo(AmazonEC2Client amazonEC2Client) {
		
			CreateSecurityGroupRequest csgReq = 
				new CreateSecurityGroupRequest();
			        	
			csgReq.withGroupName("HELLO")
				.withDescription("SJB SECURITY GROUP");
			
			

			  CreateSecurityGroupResult csgRes = amazonEC2Client.createSecurityGroup(csgReq);
	

				  IpPermission ipPerm =  new IpPermission();
				      	
				  ipPerm.withIpRanges("111.111.111.111/32", "150.150.150.150/32")
				              .withIpProtocol("tcp")
				              .withFromPort(22)
				              .withToPort(22);
				  
				  AuthorizeSecurityGroupIngressRequest securityGroupReq =
				  	new AuthorizeSecurityGroupIngressRequest();
				      	
				  securityGroupReq.withGroupName("HELLO")
				                                      .withIpPermissions(ipPerm);
				 

				  amazonEC2Client.authorizeSecurityGroupIngress(securityGroupReq);
				  
	
				CreateKeyPairRequest keyReq = 	new CreateKeyPairRequest();
				keyReq.withKeyName("HI");					
				
				CreateKeyPairResult keyRes = amazonEC2Client.createKeyPair(keyReq);

				KeyPair keyPair = new KeyPair();
				keyPair = keyRes.getKeyPair();
				String pKey = keyPair.getKeyMaterial();
				
	}

	public static int getNumberOfInstances() {
		

		AmazonEC2Client ec2 = createClient();
		
		
            DescribeInstancesResult instRes = ec2.describeInstances();
            Set<Instance> inst = new HashSet<Instance>();
            List<Reservation> res = instRes.getReservations();
            

            for (Reservation reserve : res) {
                inst.addAll(reserve.getInstances());
            }
            
            System.out.println( inst.size() + "Instances are launched");
		return inst.size();
		}
	
}
