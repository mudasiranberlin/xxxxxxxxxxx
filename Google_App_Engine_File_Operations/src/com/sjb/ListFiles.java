package com.sjb;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;



public class ListFiles extends HttpServlet {
	
		private BlobstoreService bStore = BlobstoreServiceFactory.getBlobstoreService();
		 public void doPost(HttpServletRequest q, HttpServletResponse s)
			        throws ServletException, IOException {
			 Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
			 List<BlobInfo> blobs = new LinkedList<BlobInfo>();
						 			 
			 	while(itr.hasNext())			        	
					blobs.add(itr.next());
		        
					s.setContentType("text/plain"); 
         	        writer(s,blobs);
		    
		 }
		private void writer(HttpServletResponse s, List<BlobInfo> blobs) {
			for(int i=0;i<blobs.size();i++)
			{
				String num = blobs.get(i).getFilename();
				PrintWriter out=null;
				try 
				{
					out = s.getWriter();
				} 
				catch (IOException e) 
				{
					System.err.println(e);
				}
				out.println(num + " is the file number " + (i+1));
			}
		}

}

