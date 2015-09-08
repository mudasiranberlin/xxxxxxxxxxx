package com.sjb;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.channels.Channels;
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
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;



public class RemoveTheFile extends HttpServlet {
	
		private BlobstoreService bStore = BlobstoreServiceFactory.getBlobstoreService();
		 public void doPost(HttpServletRequest q, HttpServletResponse s)
			        throws ServletException, IOException {
			 
			 List<BlobInfo> blobs = new LinkedList<BlobInfo>();
		        Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
	    	  long stmem = System.nanoTime();
			
			 
			 String fn = q.getParameter("Remove"); 		   
			 s.getWriter().println("name =" + fn);
			 
		      while(itr.hasNext())
		        	blobs.add(itr.next());
		        
		        s.setContentType("text/plain");
		        int check = 0;
		        int count=0;
		        String n = null;
		       		        	
		            while (count<blobs.size()) 
		            {
						n = blobs.get(count).getFilename();
						if (n.equals(fn)) 
						{
							check = 1;
							break;
						}

						else 
						{
							check = 0;
						}
						count++;
					}
				rem(s, n, blobs, check, count);		
		        
		        timeCalc(s, stmem); 
			   
		
	}
		private void timeCalc(HttpServletResponse s, long stmem) throws IOException {
			long smem = System.nanoTime();
			long tot = (smem - stmem)/1000000;
			
			s.getWriter().println("Elapsed Time [Blobstore] " + tot + " ms");
			
  	
			
			
			 long stp = System.nanoTime();
			    long e = (stp - stmem)/1000000;
			    
			    s.getWriter().println("ELapsed Time [Memcache] " + e + " ms");
		}
		private void rem(HttpServletResponse s, String n, List<BlobInfo> blobs,
				int check2, int i) throws IOException 
		{
			if(check2==1)
			{
				bStore.delete(blobs.get(i).getBlobKey());
				s.getWriter().println("File Found & Removed [Blobstore]");
				
				MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();        		                				
				boolean y=memcache.delete(n);
				if(y==true)
				{
					s.getWriter().println("File Found & Removed [Memcache]");
				}
				else
				{
					s.getWriter().println("File not Present [Memcache]");
				}
					
					        	
			}
			else
			{
				s.getWriter().println("File not found in blobstore & memcache");
			}
		}

}

