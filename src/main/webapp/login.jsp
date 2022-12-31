<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>

    <div style="margin: 50px; margin-left: 40%; margin-right: 40%;">
        <form action="Authent" method="POST">
            <div class="mb-3">
                <label for="login" class="form-label">Login :</label>
                <input type="text" class="form-control" id="login" name="login" aria-describedby="emailHelp">
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password :</label>
                <input type="password" class="form-control" name="password" id="password">
                <div id="emailHelp" class="form-text">No account ? Create one <a href="signin.jsp">here</a></div>
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
        </form>

		<%if(null != request.getParameter("error") && request.getParameter("error").equals("error")) {%>
        <div class="alert alert-danger" style="margin-top: 10px;" role="alert">
            Identifiants incorrects
        </div>
        <%} %>
        
        <%if(null != request.getParameter("error") && request.getParameter("error").equals("error2")) {%>
        <div class="alert alert-danger" style="margin-top: 10px;" role="alert">
            Ce login est déja pris.
        </div>
        <%} %>
        
        <%if(null != request.getParameter("info")) {%>
        <div class="alert alert-success" style="margin-top: 10px;" role="alert">
            Votre compte à été crée avec succés. Vous pouvez vous connecter.
        </div>
        <%} %>


    </div>
    

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>