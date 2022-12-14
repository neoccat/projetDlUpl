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
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 @WebServlet("/Authent")
public class Authent extends HttpServlet {

	private final static String url = "jdbc:postgresql://localhost/dluplproject";
	private final static String dbLogin = "postgres";
	private final static String dbPassword = "postgres";
	private static Connection con;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, dbLogin, dbPassword);

			String login = req.getParameter("login");
			String password = req.getParameter("password");
			
			RequestDispatcher rd;

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE login= ?");
			stmt.setString(1, login);
			System.out.println("[DEBUG] " + stmt);
			ResultSet rs = stmt.executeQuery();
			try {
				rs.next();
				if(password.equals(rs.getObject("password"))) {
					HttpSession session = req.getSession();
					session.setAttribute("user", login);
					resp.sendRedirect("files.jsp");
				} else {
					resp.sendRedirect("login.jsp?error=error");
				}
			} catch(Exception e) {
				e.printStackTrace();
				resp.sendRedirect("login.jsp?error=error");
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

}
