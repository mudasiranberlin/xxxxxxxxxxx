
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/MyServlet")
public class MyServlet implements Servlet {

	Connection con=null;
	int flag=0, flag1=0;
	int randnum=0;
	
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
		flag1=0;
		PrintWriter out = response.getWriter();
			
		String usrname = request.getParameter("name");
		String usrage = request.getParameter("age");
		String usremail = request.getParameter("email");
		String gender = request.getParameter("radio");
		String dob = request.getParameter("birthday");
		
		int i = Integer.parseInt(usrage);
		
		check(usremail);
	
		if(flag==0)
		{
			compute(usrname,i,gender,usremail,dob);
			if(flag1==0)
			{
				out.print("<h1>Record of <b>"+usrname+ "</b> added Successfully</h1>");
				out.println();
				out.print("<h1>YOUR AUTO GENERATED PASSWORD IS : <b>" + randnum+"</b></h1>" );	
			}
			
			else
			{
				out.print("<h1><b>INTERNAL EXCEPTION OCCURED!!!!!!!!!!!!!!!!!</b></h1>");
			}
			
		}
		else
		{
			out.print("<h1><b>MAIL ID EXSITS !!!! PLEASE TRY WITH DIFFERENT ID</b></h1>");
		}

		
		out.close();
		
	}
	
	public void check(String usremail)
	{
		Driver d = new oracle.jdbc.driver.OracleDriver();
		try
		{
		DriverManager.registerDriver(d);

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "DATTA1234");

		PreparedStatement pstmt = con.prepareStatement("select * from reg");
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next())
		{
			String temp = rs.getString("MAILADDR");
			
			if(temp.equals(usremail))
			{
				flag=1;
			}
		}
		con.close();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception In CHECK!!!!!!!!!!!");
		}
	}
	public void compute(String usrname, int i, String gen, String usremail, String dob) {
		
		Driver d = new oracle.jdbc.driver.OracleDriver();
		try 
		{
			DriverManager.registerDriver(d);
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "DATTA1234");

			Statement stmt = con.createStatement();
	
		
			Random rnd = new Random();
			randnum = 100000 + rnd.nextInt(900000);
		
		
			String sql = "insert into reg values('"+usrname+"',"+i+",TO_DATE('"+dob+"', 'YYYY-MM-DD'),'"+gen+"','"+usremail+"',"+randnum+")";
			stmt.executeUpdate(sql);
			con.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag1=1;
		}
		
	}

}
