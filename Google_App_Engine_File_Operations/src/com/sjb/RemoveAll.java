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



public class RemoveAll extends HttpServlet {
	
			private BlobstoreService bstore = BlobstoreServiceFactory.getBlobstoreService();
		 public void doPost(HttpServletRequest q, HttpServletResponse s)
			        throws ServletException, IOException {
			
			 Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
			    List<BlobInfo> blobs = new LinkedList<BlobInfo>();
			       
		       
		        while(itr.hasNext())
		        	  blobs.add(itr.next());
		        
		        MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
		        rem(s, memcache, blobs);  
	         
	}
		private void rem(HttpServletResponse s, MemcacheService memcache,
				List<BlobInfo> blobs) throws IOException {
			s.setContentType("text/plain");
   
			int count = 0;
			PrintWriter out = s.getWriter();
			
			
				while (count<blobs.size()) {
					bstore.delete(blobs.get(count).getBlobKey());
					memcache.delete(blobs.get(count).getFilename());
				count ++;
				}
			out.println("all files deleted");
		}

}

