package pharma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Removemedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><center><link rel=\"stylesheet\" href=\"styles/style1.css\">\r\n"+"<body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma", "root", "balaji123");

			String Uniq = request.getParameter("unique");

			
			PreparedStatement preparedStatement = con.prepareStatement(Uniq);

			//preparedStatement.setString(1, Unique);
			String Rmedz="delete from addmedicine where UniqueId='"+Uniq+"';";
			//ResultSet result1 = preparedStatement.executeUpdate(Rmedz);
			preparedStatement.executeUpdate(Rmedz);
			

			String Amedz = "select * from addmedicine";
			ResultSet result = preparedStatement.executeQuery(Amedz);
			pw.println("<table border=1 width=50% height=50%>");
			pw.println("<tr><th>Quantity</th><th>Medicine</th><th>Cost</th><th>UniqueId</th></tr>");

			while (result.next()) {
				int quantity1 = result.getInt(1);
				String name1 = result.getString(2);
				int cost1 = result.getInt(3);
				String ID1=result.getString(4);
				pw.println("<tr><td>" + quantity1 + "</td><td>" + name1 + "</td><td>" + cost1 + "</td><td>"+ ID1 +"</td></tr>");
			}
			pw.println("</table></center>");
			pw.println("</html></body>");

		}

		catch (ClassNotFoundException | SQLException cfe) {
			System.out.println(cfe);
		}
		pw.println("<center><u><b><br><a href='removemedicine.jsp'>Back</a></b></u><center>");
	}
}