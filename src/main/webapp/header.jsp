<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="position-relative headerH">
		<div class="position-absolute tm-site-header">
			<div class="container-fluid  position-relative">
				<div class="row">
					<div class="col-7 col-md-4">
					<c:choose>
						<c:when test="${not empty sessionScope.currentUser }">
							<a href="./HomeControler" class="tm-bg-black text-center tm-logo-container"> 
                            	 <span>Welcome ${sessionScope.currentUser.id}!</span>
                          	</a> 
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					</c:choose>
						
					</div>
					<div class="col-5 col-md-8 ml-auto mr-0">
						<div class="">
							<nav class="navbar navbar-expand-lg mr-0 ml-auto"
								id="tm-main-nav">
								<button
									class="navbar-toggler tm-bg-black py-2 px-3 mr-0 ml-auto collapsed"
									type="button" data-toggle="collapse" data-target="#navbar-nav"
									aria-controls="navbar-nav" aria-expanded="false"
									aria-label="Toggle navigation">
									<span> <i class="fas fa-bars tm-menu-closed-icon"></i> <i
										class="fas fa-times tm-menu-opened-icon"></i>
									</span>
								</button>
								
								
								<div class="collapse navbar-collapse tm-nav" id="navbar-nav">
									<ul class="navbar-nav text-uppercase">
										<li class="nav-item active">
											<a class="nav-link tm-nav-link" href="./HomeControler">Videos 
												
											</a>
										</li>
										
										<c:choose>
											<c:when test="${not empty sessionScope.currentUser }">
												<li class="nav-item">
													<a class="nav-link tm-nav-link"href="./Favorite">My Favorites</a>
												</li>
											</c:when>
										</c:choose>
										<li class="nav-item dropdown">
											<a class="nav-link tm-nav-link dropdown-toggle text-white" 
												href="#" id="navbarDropdown" role="button"
												data-bs-toggle="dropdown" aria-expanded="false"> My Account </a>
											<ul class="dropdown-menu  dropdown-content"
												aria-labelledby="navbarDropdown">
												
												<c:choose>
													<c:when test="${not empty sessionScope.currentUser }">
														<li><a class="dropdown-item dd" href="./forgotPass">Forgot Passowrd</a></li>
														<li><a class="dropdown-item dd" href="./register">Registration</a> </li>
														<li><a class="dropdown-item dd" href="./changePass">Change Password</a></li>
														<li><a class="dropdown-item dd" href="./editProfile">Edit Profile</a></li>
													</c:when>
													<c:otherwise>
														<li><a class="dropdown-item dd" href="./forgotPass">Forgot Passowrd</a></li>
														<li><a class="dropdown-item dd" href="./register">Registration</a> </li>

													</c:otherwise>
												</c:choose>
												
											</ul>
										</li>
										<c:choose>
											<c:when test="${not empty sessionScope.currentUser }">
												<li class="nav-item">
													<a class="nav-link tm-nav-link"href="./logout">Logout</a>
												</li>
											</c:when>
											<c:otherwise>
												<li class="nav-item">
													<a class="nav-link tm-nav-link"href="./login">Login</a>
												</li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>

</body>
</html>