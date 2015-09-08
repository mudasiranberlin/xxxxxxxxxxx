package com.sjb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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



public class FindFile extends HttpServlet {
	
		private BlobstoreService bStore = BlobstoreServiceFactory.getBlobstoreService();
		 public void doPost(HttpServletRequest q, HttpServletResponse s)
			        throws ServletException, IOException {
			 
			 long st = System.nanoTime();	   
			
		     List<BlobInfo> blobs = new LinkedList<BlobInfo>();
		     PrintWriter out = s.getWriter();
		     out.println("Lets Find The File");
		     Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
		       
		        while(itr.hasNext())
		         blobs.add(itr.next());
		    
		         s.setContentType("text/plain");
		        String fn = q.getParameter("Findfile"); 
		        out.println("File name : "+ fn);
		        checkExist(s, fn, blobs);
		        calcTime(s,st); 
			   
	}
		private void checkExist(HttpServletResponse s, String fn,
				List<BlobInfo> blobs) throws IOException {
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
					} count++;
				}
			if(check==1)
			{
				
				s.getWriter().println("File Found [BlobStore]");
				
				MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
				AppEngineFile f;
				f = (AppEngineFile) memcache.get(n);
				if(f == null)
				{ 
					s.getWriter().println("File Not Found[Memcache]");
				}
				else
				{ 
					s.getWriter().println(" File Found [Memcache]");
				}
				
			}
			else
			{
				s.getWriter().println("File Not Found ");
			}
		}
		private void calcTime(HttpServletResponse s, long st) throws IOException {
			PrintWriter out = s.getWriter();
			
			final long stblb = System.nanoTime();
			final long tot = (stblb - st)/1000000;
			
			
			out.println("Elapsed Time [blobstore]: " + tot + " ms");
			
			final long stopmem = System.nanoTime();
			    final long e = (stopmem - st )/1000000;
			    
			 
			    out.println("Elapsed Time [Memcache]: " + e + " ms");
		}

}

