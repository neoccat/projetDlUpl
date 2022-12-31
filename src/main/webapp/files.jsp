<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>files uploader</title>
<%@ page isELIgnored = "false" %>
</head>
<body>

	<%@ page import="java.io.File" %>

	<nav class="navbar bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand">
	      <img src="./img/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
	      
	    </a>
    	<a href="Logout" type="button" class="btn btn-danger">Disconnect</a>
	  </div>
	</nav>
	<% Object user = request.getSession().getAttribute("user"); %>
    <h1>Welcome, <%= user %></h1>
    
    <br>
    
    <% File userDir = new File("src/main/webapp/users_files/" + user); %>
    <div style="margin:auto;width:80%">
    <%= userDir.getAbsolutePath() %>
    <%= userDir.isDirectory() %>
    
    <% if(null != request.getParameter("error")) { %>
    <div class="alert alert-danger" style="margin-top: 10px;" role="alert">
        <%if(request.getParameter("error").equals("error")) { %>Le fichier que vous essayez d'uploader dépasse la limite de taille imposée. <% } %>
        <%if(request.getParameter("error").equals("error1")) { %>La suppression du fichier n'as pas pu s'effectuer. <% } %>
    </div>
    <% } %>
    
    <ul class="list-group">
	 
	 <% for(File f : userDir.listFiles()) { %>
	 	<li class="list-group-item d-flex justify-content-between align-items-start">
		    <div class="ms-2 me-auto">
		      <div class="fw-bold"><%= f.getName() %></div>
		      <% if(!f.isDirectory()) { %>
		      <%= (double) f.length() / (1024) %> Ko
		      <a href="./users_files/<%= user %>/<%= f.getName() %>" download><img alt="dlIcon" src="./img/download.svg" width="20" height="20"></a>
		      <% } %>
		    </div>
		    <a href="Delete?file=<%= f.getName() %>"><img alt="dlIcon" src="./img/trash3.svg" width="20" height="20"></a>
		</li>
	 <% } %>
	  
	</ul>
	
	<div style="margin-top:10px" class="d-grid gap-2 d-md-flex justify-content-md-end">
	  <button class="btn btn-outline-primary" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">Import</button>
	</div>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">Import file</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <form action="Upload" method="POST" enctype="multipart/form-data">
		      <div class="modal-body">
		        <label for="exampleInputEmail1" class="form-label">Your file : </label>
	   			<input type="file" class="form-control" name="file" id="file">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <button type="submit" class="btn btn-primary">Import</button>
		      </div>
	      </form>
	    </div>
	  </div>
	</div>
	
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>