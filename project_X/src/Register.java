

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
		String name = request.getParameter("user_name");
        String email = request.getParameter("mail");
        String pass = request.getParameter("user_pass");
        try{
        
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection con=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/DATABASE_NAME","root","root");

        PreparedStatement ps=con.prepareStatement
                  ("insert into user_detail values(?,?,?)");

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pass);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("You are sucessfully registered");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      
		// TODO Auto-generated method stub
	}

}
