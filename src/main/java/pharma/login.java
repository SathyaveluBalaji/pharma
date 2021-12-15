package pharma;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
        
        String username=request.getParameter("user");
        String password=request.getParameter("pass");
        
        ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/Dashboard1.jsp");
        
        if(username.equals("admin") && password.equals("12345"))
        {
            rd.forward(request, response);
        }
        else
        {
           JOptionPane.showMessageDialog(null,"Username or Password is wrong","warning message",JOptionPane.WARNING_MESSAGE);
           RequestDispatcher rd1=sc.getRequestDispatcher("/login.jsp");
           rd1.forward(request, response);


        }
	}

}