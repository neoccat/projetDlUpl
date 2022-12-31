package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/Upload")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Upload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MultipartRequest m = new MultipartRequest(req, "src/main/webapp/users_files/" + req.getSession().getAttribute("user")); 
			
			RequestDispatcher rd = req.getRequestDispatcher("files.jsp");
			rd.forward(req, resp);
			
		} catch(Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("files.jsp?error=error");
			rd.forward(req, resp);
		}
	}
}
