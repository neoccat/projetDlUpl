package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/Authent")
public class Authent extends HttpServlet {

	private final static String salt = "heheboy.";
	private static List<User> connectedUsers = new ArrayList<>();
	private final static String url = "jdbc:postgresql://psqlserv/da2i";
	private final static String dbLogin = "theotaccoenetu";
	private final static String dbPassword = "moi";
	private static Connection con;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("hello world this is compiled");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("bah ");
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, dbLogin, dbPassword);

			String login = req.getParameter("login");
			String password = req.getParameter("password");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE login= ?");
			stmt.setString(1, login);
			System.out.println("[DEBUG] " + stmt);
			ResultSet rs = stmt.executeQuery();
			try {
				rs.next();
				if(password.equals(rs.getObject("password"))) {
					resp.sendRedirect("files.jsp");
				} else {
					resp.sendRedirect("login.jsp?error=error");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<User> getConnectedUsers() {
		return this.connectedUsers;
	}
}
