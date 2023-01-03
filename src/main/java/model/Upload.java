package model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Upload")
public class Upload extends HttpServlet {
    private final int maxFileSize = 1024*1024*100000;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //MultipartRequest m = new MultipartRequest(req, "src/main/webapp/users_files/" + req.getSession().getAttribute("user")); 
            DiskFileItemFactory factory = new DiskFileItemFactory(maxFileSize, new File("src/main/webapp/users_files/" + req.getSession().getAttribute("user")));
            
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            upload.setSizeMax(maxFileSize);

            // Parse the request
            List<FileItem> items = upload.parseRequest(req);
                        
            for(FileItem fi : items) {
                File uploadedFile = new File("src/main/webapp/users_files/" + req.getSession().getAttribute("user") +"/"+fi.getName());
                fi.write(uploadedFile);
            }
            
            RequestDispatcher rd = req.getRequestDispatcher("files.jsp");
            rd.forward(req, resp);
            
        } catch(Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("files.jsp?error=error");
            rd.forward(req, resp);
        }
    }
}