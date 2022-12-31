package model;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File fileToDelete = new File("src/main/webapp/users_files/" + req.getSession().getAttribute("user") + "/" + req.getParameter("file"));
		
		if(fileToDelete.delete()) {
			RequestDispatcher rd = req.getRequestDispatcher("files.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("files.jsp?error=error1");
			rd.forward(req, resp);
		}
	}
}
