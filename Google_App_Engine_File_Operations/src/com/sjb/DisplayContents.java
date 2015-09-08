package com.sjb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.Channels;
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
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;



@SuppressWarnings("deprecation")
public class DisplayContents extends HttpServlet {
	
	 
	private BlobstoreService bstore = BlobstoreServiceFactory.getBlobstoreService();
		 public void doPost(HttpServletRequest q, HttpServletResponse s)
			        throws ServletException, IOException {
			
			 List<BlobInfo> blobs = new LinkedList<BlobInfo>();
		     Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
			 
			 
			 String fn = q.getParameter("display");
					s.getWriter().println("File Name: "+ fn);    
		        	while(itr.hasNext())
		        	  blobs.add(itr.next());
		        
		        s.setContentType("text/plain");
		        int check = 0;
		        int count = 0;
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
				findFile(s, n, blobs, check, count);
       
	  }
		private void findFile(HttpServletResponse s, String n,
				List<BlobInfo> blobs, int check, int i) throws IOException 
		{
			if(check==1)
			{
				 FileService fserv = FileServiceFactory.getFileService();
				 MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();	        	
				 AppEngineFile f;
				 f = (AppEngineFile) memcache.get(n);
				 if(f == null)
				 {
					 fileBlob(s, blobs, i, fserv);
				 }
				 
				 else
				 {
					 fileMem(s, fserv, f); 
				 }
				
				
			}
			else
			{
				PrintWriter out = s.getWriter();
				out.println("Sorry No Such File Exists");
			}
		}
		private void fileMem(HttpServletResponse s, FileService fserv,
				AppEngineFile f) throws IOException {
			s.getWriter().println("File Found [Memcache] ");
			 FileReadChannel rCh = fserv.openReadChannel(f, false);
			 BufferedReader r = new BufferedReader(Channels.newReader(rCh, "UTF8"));
			 String ln = null;
			 					 
			 while((ln = r.readLine()) != null){        					
				 	s.getWriter().println(ln);
			 }
			 
			 rCh.close();
		}
		private void fileBlob(HttpServletResponse s, List<BlobInfo> blobs,
				int i, FileService fserv) throws IOException {
			AppEngineFile f;
			PrintWriter out = s.getWriter();
			 out.println("File Found [Blobstore]");
			 

			 f = fserv.getBlobFile(blobs.get(i).getBlobKey());
			 		        	
			 FileReadChannel rCh = fserv.openReadChannel(f, false);
			 BufferedReader r = new BufferedReader(Channels.newReader(rCh, "UTF8"));
			 String ln = null;
								 
			 while((ln = r.readLine()) != null){        					
				 	s.getWriter().println(ln);
			 }
			 
			 rCh.close();
		}

}

