import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;


public class Animoto 
{
	private static String bucket;
	private static String key;
	private static String file_name;
	static AmazonS3 s3client = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
	public static void createAnimoto()
	{
		
		try 
		{
            System.out.println(" Uploading to S3 ");
            File file = new File(file_name);
            s3client.putObject(new PutObjectRequest(bucket, key, file));

        } 
		catch (AmazonServiceException ase) 
		{
            System.out.println(" Amazon Service Exception ");
            System.out.println(" Message:    " + ase.getMessage());
            System.out.println(" Status Code: " + ase.getStatusCode());
            System.out.println(" AWS Error Code:   " + ase.getErrorCode());
            System.out.println(" Error Type:       " + ase.getErrorType());
            System.out.println(" Request ID:       " + ase.getRequestId());
        } 
		catch (AmazonClientException ace) 
		{
            System.out.println(" Amazon Client Exception ");
            System.out.println(" Message: " + ace.getMessage());
        }	
	}
	
	
	public static Object fetchAnimoto(String key)
	{
		
		S3Object obj = s3client.getObject(new GetObjectRequest(bucket, key));
        System.out.println("The ContentType is : "  + obj.getObjectMetadata().getContentType());
        GetObjectRequest obj_req = new GetObjectRequest(bucket, key);
        obj_req.setRange(0, 10);
        S3Object obj_part = s3client.getObject(obj_req); 
        System.out.println("Bytes Retrived");
		return obj_part;
	}
	
	 public static void main(String[] args) throws IOException 
	 {
		 BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		 String fn = (String)buf.readLine();
	     BufferedReader buf_fn = new BufferedReader(new FileReader(fn));
	     String ln="" , data = "";
	     ln = buf_fn.readLine();
	     while(ln != null)
	     {
	    	 data = data + "%" + ln;
	    	 ln = buf_fn.readLine();
	     }
	     data = data +"%END";
	     
	    String url = data;
	    URL u;
	    InputStream inp = null;
	    DataInputStream st;
	    String sam;
	    try
	    {
	      u = new URL(url);
	      inp = u.openStream();
	      st = new DataInputStream(new BufferedInputStream(inp));
	      while ((sam = st.readLine()) != null)
	      {
	        System.out.println("Sample :"+sam);
	      }
	    }
	    catch (MalformedURLException z)
	    {
	      System.err.println("Exception Occured");
	      z.printStackTrace();
	      System.exit(2);
	    }
	    catch (IOException q)
	    {
	      System.err.println("IO Exception");
	      q.printStackTrace();
	      System.exit(3);
	    }
	    finally
	    {
	      try
	      {
	        inp.close();
	      }

	      catch (IOException ioe)
	      {
	    	  System.err.println(" Exception Caught ");
	      }
	    }
	  }
}