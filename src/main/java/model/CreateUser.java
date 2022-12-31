package model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	
	private final static String url = "jdbc:postgresql://localhost/dluplproject";
	private final static String dbLogin = "postgres";
	private final static String dbPassword = "postgres";
	private static Connection con;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		RequestDispatcher rd;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, dbLogin, dbPassword);
			
			File f = new File("src/main/webapp/users_Files");
			for(File file : f.listFiles()) {
				if(file.getName().equals(login))
					throw new Exception();
			}
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO users (login, password) values (?, ?)");
			stmt.setString(1, login);
			stmt.setString(2, password);
			
			System.out.println("[LOG] " + stmt);
			stmt.execute();
			
			File dir = new File("src/main/webapp/users_Files/" + login);
			dir.mkdir();
			
			rd = req.getRequestDispatcher("login.jsp?info=created");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			rd = req.getRequestDispatcher("login.jsp?error=error2");
			rd.forward(req, resp);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
