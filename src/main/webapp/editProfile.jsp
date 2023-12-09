<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Video Catalog</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" /> 
    <!-- https://fontawesome.com/ -->
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
    <!-- https://fonts.google.com/ -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/index.css">
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>    
    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>

<!-- Script -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<%@ include file="header.jsp" %>


    <div class=" dHaed" >
    
    	<div class="login-box mt-5 ">
 		<span class="text-center fs-2 text-white">Edit Profile</span>
 		<span class="text-center fs-4 text-danger">${mess }</span>
        <form class="form-reg">
          <div class="user-box">
            <input type="text" name="id" value="${u.id}" required="">
            <label style="top: -20px; left: 0; color: #bdb8b8; font-size: 12px;" >Username</label>
          </div>
          <div class="user-box">
            <input type="password" name="password" value="${u.password}" required="">
            <label>Password</label>
          </div>
          <div class="user-box">
            <input type="text" name="fullname" value="${u.fullname}" required="">
            <label>Fullname</label>
          </div>
          <div class="user-box">
            <input type="email" name="email" value="${u.email}" required="">
            <label>Email address</label>
          </div>
          <center>
            <button formaction="./editProfile" formmethod="post" class="btn">Update<span></span></button>
          </center>
        </form>
      </div>
    </div>
    
    <%@ include file="footer.jsp" %>
    
    
    <style>
		.dHaed{
			height: 200px;
			background-color: #333;
			margin-bottom: 500px;
		}
	</style>
</body>
</html>