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
					<div class="col-7 col-md-4 d-flex justify-content-around">
						 <button class="btn btnOffcanvas" type="button" data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                                <i class="fa-solid fa-list"></i>
                            </button>

                            <div class="offcanvas offcanvas-start bg-light" tabindex="-1" id="offcanvasExample"
                                aria-labelledby="offcanvasExampleLabel">
                                <div class="offcanvas-header">
                                    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Manager</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas"
                                        aria-label="Close"></button>
                                </div>
                                <div class="offcanvas-body fs-1 ">
                                    <div class="mt-5">
                                        <a href="./Videos" class="text-dark" style="text-decoration: none;"><i class="fa-solid fa-film"></i><span class="ms-2">Videos</span></a>
                                    </div>
                                    <div class="mt-5">
                                        <a href="./user" class="text-dark" style="text-decoration: none;"><i class="fa-solid fa-users"></i><span class="ms-2">Users</span></a>
                                    </div>
                                    <div class="mt-5">
                                        <a href="./Report" class="text-dark" style="text-decoration: none;"><i class="fa-regular fa-newspaper"></i><span class="ms-2">Reports</span></a>
                                    </div>
                                </div>
                            </div>
                            <c:choose>
						<c:when test="${not empty sessionScope.currentUser }">
							<a href="./HomeControler" class="tm-bg-black text-center tm-logo-container"> 
                            	 <span>Welcome ${sessionScope.currentUser.id}!</span><br> <span>Quanr trị viên!</span>
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
												<span class="sr-only"></span>
											</a>
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