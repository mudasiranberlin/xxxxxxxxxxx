package com.sjb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class Insert extends HttpServlet {
    private BlobstoreService bStore = BlobstoreServiceFactory.getBlobstoreService();
    private MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
    private AppEngineFile f;
	
    public void doPost(HttpServletRequest q, HttpServletResponse s)
        throws ServletException, IOException 
    {  
    	long start = System.nanoTime();
       	Map<String, List<BlobKey>> blobs = bStore.getUploads(q);
        List<BlobKey> blobKey = blobs.get("Insert");
        
        List<BlobInfo> blobr = new LinkedList<BlobInfo>();
        Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
        	
        	do{ 
    	       	
        		blobr.add(itr.next()); 
        	}while(itr.hasNext());
        	
        	putMem(blobr);
        	PrintWriter out =s.getWriter();
        	out.println("Upload Successfull"+"<br>");
         
         writer(q, s, start);
        	
    }
    
	private void putMem(List<BlobInfo> blobr) {
		
		
		for(int i=0;i<blobr.size();i++)
		{
			FileService fServ = FileServiceFactory.getFileService();
			if(blobr.get(i).getSize() <= 102400){
				this.f = fServ.getBlobFile(blobr.get(i).getBlobKey());
				this.memcache.put(blobr.get(i).getFilename(), this.f); 
			}
		}

	}

	private void writer(HttpServletRequest q, HttpServletResponse s, long sed)
			throws IOException {
		final long end = System.nanoTime();
		
		PrintWriter out = s.getWriter();
		out.println("Elapsed Time " + ((end - sed) / 1000000) + "ms" + "<br>");
	}
  
}
