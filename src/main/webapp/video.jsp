<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- https://fontawesome.com/ -->
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<!-- https://fonts.google.com/ -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/dashboard.css">
<!-- css raido button -->
<link rel="stylesheet" href="./css/video.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
	
	
<title>Insert title here</title>
</head>
<body>
	<%@ include file="headerM.jsp"%>
	<div class="warpper mt-3">
		<input class="radio" id="one" name="group" type="radio" checked>
		<input class="radio" id="two" name="group" type="radio"> <input
			class="radio" id="three" name="group" type="radio">
		<div class="tabs">
			<label class="tab" id="one-tab" for="one">Edit video</label> <label
				class="tab" id="two-tab" for="two">List Video</label>
		</div>
		<div class="panels">
			<div class="panel" id="one-panel">
				<div class="col-lg-12 col-12 mt-0">
					<div class="container mt-5">
						<form action="" class=""
							style="border: 1px darkgray solid; border-radius: 10px; width: 100%; margin: 0 auto; padding: 20px; height: 820px;">
							<div class="fs-4 text-center text-danger">${mess}</div>
							<div class="row">
								<div class="col-md-6 ">
									<img id="videoImage" class="w-100 mt-5"
										src="https://img.youtube.com/vi/${e.id }/maxresdefault.jpg"
										alt="">
								</div>
								<div class="col-md-6">
									<div class="mb-3">
										<label for="exampleInputEmail1" class="form-label fs-6">Youtube Id </label> 
										<input type="text" name="id"   class="form-control rounded-3 " id="yId" aria-describedby="emailHelp" value="${e.id}">
									</div>

									<div class="mb-3">
										<label for="exampleInputEmail1" class="form-label fs-6">
											Video title
										</label> 
										<input type="text" class="form-control rounded-3 " id="exampleInputEmail1"
											aria-describedby="emailHelp" name="title" value="${e.title}">
									</div>
									<div class="mb-3">
										<label for="exampleInputEmail1"  class="form-label fs-6">View
											count</label> <input type="number"
											class="form-control rounded-3 " id="exampleInputEmail1"
											aria-describedby="emailHelp" name="views" value="${e.views}" >
									</div>
									<div class="form-group row ">

										<div class="radio d-flex col-12 fs-6">
											<label class="checkbox-inline"> <input type="radio"
												class="option-input radio" name="active" ${e.active == true ? 'checked' : '' } /> Active
											</label> 
											<label class="ms-3 checkbox-inline"> <input
												type="radio" class="option-input radio" name="active"  ${e.active != true ? 'checked' : '' }  />
												Inacvtive
											</label>
										</div>
									</div>
								</div>
								<div class="col-md-6 fs-6" >
									<label for="">Discription</label>
									<textarea name="description" id="myTextarea" cols="70" rows="3" >${e.description }</textarea>
								</div>
							</div>


							<div class="float-end fs-6">
								<button formaction="./insert" class="playstore-button">Create</button>
								<button formaction="./update" class="playstore-button">Update</button>
								<button formaction="./delete" class="playstore-button">Delete</button>
								<button formaction="./new" class="playstore-button">Reset</button>
							</div>

						</form>


					</div>
				</div>
			</div>
			<div class="panel" id="two-panel">
				<div class="container">
				
					 <div class="container mt-5 ">
            <table class="table fs-6 table-hover table-bordered border-3 border-dark rounded-3" >
                <thead>
                    <tr>
                        <th>Video id</th>
                        <th>Video title</th>
                        <th>View count</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="v" items="${video}">
                    <tr>
                        <td>${v.id}</td>
                        <td>${v.title}</td>
                        <td>${v.views}</td>
                        <td>${v.active}</td>
                        <td>
                            <a href="./edit?idV=${v.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
					<div class="row">
						<div class="d-flex justify-content-center">
							<button class="btn btn-outline-dark me-2">
								<i class="fa-solid fa-backward-step"></i>
							</button>
							<button class="btn btn-outline-dark me-2">
								<i class="fa-solid fa-backward"></i>
							</button>
							<button class="btn btn-outline-dark me-2">
								<i class="fa-solid fa-forward"></i>
							</button>
							<button class="btn btn-outline-dark me-2">
								<i class="fa-solid fa-forward-step"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	
	
	<script>
    // Lấy tham chiếu đến thẻ <textarea> bằng ID
    var textarea = document.getElementById("myTextarea");
    
    // Set giá trị cho thẻ <textarea>
    textarea.value = ${e.description};
</script>
</body>
</html>