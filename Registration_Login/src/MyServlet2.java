
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;



@WebServlet("/MyServlet2")
public class MyServlet2 implements Servlet {

	Connection con=null;
	int flag = 0;
	@Override
	public void destroy() 
	{
	}

	@Override
	public ServletConfig getServletConfig() 
	{
		return null;
	}

	@Override
	public String getServletInfo() 
	{
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException 
	{
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException 
	{
		flag=0;
		PrintWriter out = response.getWriter();
			
		String usrmail = request.getParameter("mailaddr");
		String usrpswd = request.getParameter("pswd");
		
		check(usrmail,usrpswd);
		
		if(flag==1)
		{
			Driver d = new oracle.jdbc.driver.OracleDriver();
			try
			{
				DriverManager.registerDriver(d);

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "DATTA1234");

				PreparedStatement pstmt = con.prepareStatement("select * from reg");
			
				ResultSet rs = pstmt.executeQuery();

				out.print("<table border=\"1\">");
				out.print("<tr><th>NAME</th><th>AGE</th><th>DOB</th><th>GENDER</th><th>EMAIL ADDRESS</th> </tr>");
				while(rs.next())
				{
					out.print("<tr><td>"+rs.getString("NAME")+"</td><td>"+rs.getString("AGE")+"</td><td>"+rs.getString("DOB")+"</td><td>"+rs.getString("GENDER")+"</td><td>"+rs.getString("MAILADDR")+"</td> </tr>");
				}
				
				con.close();
				out.close();
			}
			
			catch(Exception e)
			{
				System.out.println("Exception In Service!!!!!!!!!!!");
			}
		}
		else
		{
			out.print("<h1><b>INVALID CRENDENTIALS!!!!!!! PLEASE CHECK YOUR MAIL ID AND PASSWORD!!!!</b></h1>");
		}
		
		out.close();
		
		
	}
	
	public void check(String usrmail, String usrpswd)
	{
		String vald=null;
		Driver d = new oracle.jdbc.driver.OracleDriver();
		try
		{
			DriverManager.registerDriver(d);

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "DATTA1234");

			PreparedStatement pstmt = con.prepareStatement("select pswd from reg where mailaddr='"+usrmail+"'");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				vald = rs.getString("pswd");
			}
			
			if(vald.equals(usrpswd))
			{
				flag=1;
			}
			con.close();
			
		}
		
		catch(Exception e)
		{
			System.out.println("Invalid Mail ID");
		}
	
	}

}
