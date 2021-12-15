package pharma;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class success extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.println("<html><center><link rel=\"stylesheet\"href=\"styles/style7.css\"\r\n"+"<body>");
		pw.println("<br><br><center><font color=green size=5><b>Order successfully placed<b></font><center><br><br>");
		pw.println("<a href='order.jsp'><font color=black size=15><b>Back</b></font></a>");
	}

}