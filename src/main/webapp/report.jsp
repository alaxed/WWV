<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- https://fontawesome.com/ -->
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
    <!-- https://fonts.google.com/ -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/dashboard.css">
    <link rel="stylesheet" href="./css/index.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"
        integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>

<body>
	<%@ include file="headerM.jsp" %>

     <div class="warpper mt-3"> 
        <input class="radio" id="one" name="group" type="radio" ${tabIndex == 1 ? 'checked' : ''  } >
        <input class="radio" id="two" name="group"  type="radio" ${tabIndex == 2 ? 'checked' : ''  } >
        <input class="radio" id="three" name="group" type="radio" ${tabIndex == 3 ? 'checked' : ''  } >
        
        <div class="tabs">
            <label class="tab" id="one-tab" for="one">Favorites</label>
            <label class="tab" id="two-tab" for="two">Favorite Users</label>
            <label class="tab" id="three-tab" for="three">Shared friends</label>
        </div>
        <div class="panels">
            <div class="panel" id="one-panel">
                <div class="col-lg-12 col-12 mt-0">
                    <div class="container">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Video Title</th>
                                    <th>Favorite count</th>
                                    <th>Lastest date</th>
                                    <th>Oldest date</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="r" items="${r}">
                             	<tr class="align-middle">
                                    <td>${r.group}</td>
                                    <td>${r.like}</td>
                                    <td>${r.newest}</td>
                                    <td>${r.oldest}</td>
                                </tr>
                            </c:forEach>
                               

                   
                            </tbody>
                        </table>
                       
                    </div>
                </div>
            </div>
            
            <div class="panel" id="two-panel">
                <div class="container">
                
				     <form action="./Report" method="post">    
                    <div class="d-flex row justify-content-center mx-1">
                        <p class="fs-5">Tiêu đề video</p>
                        <select class="form-select mb-3" aria-label="Default select example" name="title" onchange="this.form.submit()">
                            <option selected disabled="disabled">Video title</option>
                            <c:forEach var="v" items="${videotitle }">
                            	<option ${titleSelected eq v ?'selected':'' } value="${v}">${v}</option>
                          	</c:forEach>
							
                        </select>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>UserName</th>
                                <th>FullName</th>
                                <th>Email</th>
                                <th>Favorite Date</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="u" items="${Users}">
                            <tr class="align-middle">
                                <td>${u.id}</td>
                                <td>${u.fullname }</td>
                                <td>${u.email}</td>
                                <td>
                                	
                                	<c:forEach var="ld" items="${LikeDate }">
                               		<c:if test="${ld.user.id eq u.id }">
                               			${ld.likeDate}
                               		</c:if>
                               		</c:forEach>
                                </td>
                               	
                            </tr>
						</c:forEach>
                           
                        </tbody>
                    </table>
                    </form>
                </div>
            </div>
            <div class="panel" id="three-panel">
                <div class="container">
                <form action="./Report" method="post">    
                    <div class="d-flex row justify-content-center mx-1">
                        <p class="fs-5">Tiêu đề video</p>
                        <select class="form-select mb-3" aria-label="Default select example" name="title" onchange="this.form.submit()">
                            <option selected disabled="disabled">Video title</option>
                            <c:forEach var="v" items="${videotitle }">
                            	<option ${titleSelected eq v ?'selected':'' } value="${v}">${v}</option>
                          	</c:forEach>
							
                        </select>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Sender Name</th>
                                <th>Sender Email</th>
                                <th>Receiver Email</th>
                                <th>Sent Date</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="f" items="${fav }">
                        
                            <tr class="align-middle">
                                <td>${f.user.fullname}</td>
                                <td>${f.user.email}</td>
                                <td>${f.email}</td>
                                <td>${f.shareDate }</td>
                            </tr>
						</c:forEach>
                          
                        </tbody>
                    </table>
                   </form>
                </div>
            </div>
        </div>
       
    </div>   

    
	<%@ include file="footer.jsp" %>


</body>

</html>