package pharma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addmedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><center><link rel=\"stylesheet\" href=\"styles/style1.css\">\r\n"
				+ "<body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma", "root", "balaji123");

			String Quantity = request.getParameter("quant");
			String Name = request.getParameter("name");
			String Cost = request.getParameter("cost");
			String ID = request.getParameter("unique");


			// String query = "INSERT INTO addmedicine " + "VALUES(?,?,?)";
			// query.setString(1,Quantity);
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO addmedicine " + "VALUES(?,?,?,?)");

			preparedStatement.setString(1, Quantity);
			preparedStatement.setString(2, Name);
			preparedStatement.setString(3, Cost);
			preparedStatement.setString(4, ID);


			// String query = "INSERT INTO addmedicine " + "VALUES(?,?,?)";
			preparedStatement.executeUpdate();
//			     query="INSERT INTO addmedicine " + "VALUES(2,'DOLO','20')";
//			     preparedStatement.executeUpdate(query);
			// pw.println("success");
			String medz = "select * from addmedicine";
			ResultSet result = preparedStatement.executeQuery(medz);
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
		pw.println("<center><u><b><br><a href='addmedicine.jsp'>Back</a></b></u><center>");
	}
}