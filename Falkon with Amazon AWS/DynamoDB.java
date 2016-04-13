import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.util.Tables;


public class DynamoDB {
	 AmazonDynamoDBClient dynamoDB;
	 int num(String m,String n){
	int count=0;
	AWSCredentials creds = null;
    try {
       creds = new ProfileCredentialsProvider("aws").getCredentials();
    } catch (Exception e) {
        throw new AmazonClientException(
               "File not found exception" + " Credentials.csv file " + 
                e);
    }
    dynamoDB = new AmazonDynamoDBClient(creds);
    Region usWest2 = Region.getRegion(Regions.US_WEST_2);
    dynamoDB.setRegion(usWest2);
    
        String tab = "task-list-table";

       
        if (Tables.doesTableExist(dynamoDB, tab)) {
            System.out.println("Active Table " + tab + " plz try different one");
        } else {
           
        	CreateTableRequest tabReq = new CreateTableRequest().withTableName(tab)
                    .withKeySchema(new KeySchemaElement().withAttributeName("name").withKeyType(KeyType.HASH))
                    .withAttributeDefinitions(new AttributeDefinition().withAttributeName("name").withAttributeType(ScalarAttributeType.S))
                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
                    TableDescription tabDesc = dynamoDB.createTable(tabReq).getTableDescription();
                System.out.println("Created Table: " + tabDesc);


       
            System.out.println("Waiting for " + tab + " to become ACTIVE...");
            Tables.waitForTableToBecomeActive(dynamoDB, tab);
        }


        
        
        
        
        
        
        
        
        
        
        
        
       
        HashMap<String, Condition> filter = new HashMap<String, Condition>();
        Condition cond = new Condition()
            .withComparisonOperator(ComparisonOperator.EQ.toString())
            .withAttributeValueList(new AttributeValue().withS(n));
        filter.put("value", cond);
        ScanRequest scnReq = new ScanRequest(tab).withScanFilter(filter);
        ScanResult scnRes = dynamoDB.scan(scnReq);
        System.out.println("Result: " + scnRes); 
        int dat = scnRes.getCount();
      
        if(dat == 0)
        {

            Map<String, AttributeValue> mit = new HashMap<String, AttributeValue>();
            mit.put("name", new AttributeValue(m));
            mit.put("value", new AttributeValue(n));
        
        
        
      
        PutItemRequest itemReq = new PutItemRequest(tab, mit);
       
        dynamoDB.putItem(itemReq);
        System.out.println("Not Found" + " inserted into DynamoDB");
        count=1;
        return count;
       
        }
        
        else
        {
        	System.out.println("Task Exists");
        	return count;
        }
        
      

}
	void delete(String m)
	{
		AWSCredentials creds = null;
	    try {
	        creds = new ProfileCredentialsProvider("aws").getCredentials();
	    } catch (Exception e) {
	        throw new AmazonClientException(
	                "FIle not Found Execption" + " Credentials.csv",
	                e);
	    }
	    dynamoDB = new AmazonDynamoDBClient(creds);
	    Region usWest2 = Region.getRegion(Regions.US_WEST_2);
	    dynamoDB.setRegion(usWest2);
	    
	        String tab = "tasks2-table";
	        HashMap<String, Condition> scn = new HashMap<String, Condition>();
	        Condition cond = new Condition()
	            .withComparisonOperator(ComparisonOperator.EQ.toString())
	            .withAttributeValueList(new AttributeValue().withS(m));
	        scn.put("value", cond);
	        ScanRequest scnReq = new ScanRequest(tab).withScanFilter(scn);
	        ScanResult scnRes = dynamoDB.scan(scnReq);
	     

	            Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
	            item.put("name", new AttributeValue(m));
	            item.put("value", new AttributeValue(m));
	        
	        
	        
	      
	        DeleteItemRequest delReq = new DeleteItemRequest(tab, item);
	       
	        dynamoDB.deleteItem(delReq);
	        System.out.println("Task Deleted");
	        	
	       
	       
	        

	}
}