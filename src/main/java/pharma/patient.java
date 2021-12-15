package pharma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class patient extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><center><link rel=\"stylesheet\" href=\"styles/style1.css\">\r\n"
				+ "<body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma", "root", "balaji123");

			String ID   = request.getParameter("patid");
			String name = request.getParameter("name");
			String mob  = request.getParameter("mob");
			String addr = request.getParameter("addr");
			String date = request.getParameter("date");


			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO patients " + "VALUES(?,?,?,?,?)");

			preparedStatement.setString(1, ID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, mob);
			preparedStatement.setString(4, addr);
			preparedStatement.setString(5, date);


			preparedStatement.executeUpdate();

			String pats = "select * from patients";
			ResultSet result = preparedStatement.executeQuery(pats);
			pw.println("<table border=2 width=50% height=50%>");
			pw.println("<tr><th>Patient ID</th><th>Name</th><th>Mobile no</th><th>Address</th><th>Date</th></tr>");

			while (result.next()) {
				int ID1 =result.getInt(1);
				String name1 = result.getString(2);
				String mob1 = result.getString(3);
				String addr1 = result.getString(4);
				String date1=result.getString(5);
				
				pw.println("<tr><td>"+ ID1 +"</td><td>" + name1 + "</td><td>" + mob1 + "</td><td>" + addr1 + "</td><td>"+ date1 +"</td></tr>");
			}
			pw.println("</table></center>");
			pw.println("</html></body>");

		}

		catch (ClassNotFoundException | SQLException cfe) {
			System.out.println(cfe);
		}
		pw.println("<center><u><b><br><a href='patient.jsp'>Back</a></b></u><center>");
	}
}