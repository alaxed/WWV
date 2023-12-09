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
    <link rel="stylesheet" href="css/index.css">

    <!-- css raido button -->
    <link rel="stylesheet" href="css/video.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"
        integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>

</head>

<body>
<%@ include file="headerM.jsp" %>

    <div class="container mt-5">
        <span class="fs-2 fw-bold ">User Edition: </span>
        <form action="" class="p-2 bg-form "
            style="border: 1px darkgray solid; border-radius: 10px; width: 80%; margin: 0 auto; padding: 20px; height: 400px; ">
            	<div class="text-cemter text-danger fs-4">${mess }</div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="form-label fw-bold">Username?</label>
                        <input name="id" type="text" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" value="${e.id}">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="form-label fw-bold">Fullname?</label>
                        <input name="fullname" type="text" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" value="${e.fullname}">
                    </div>

                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="form-label fw-bold">Password?</label>
                        <input name="password" type="password" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" value="${e.password}">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="form-label fw-bold">Email Address?</label>
                        <input name="email" type="email" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" value="${e.email}">
                    </div>
                </div>

            </div>
            <div class="float-end p1">
                <button formaction="./updateUser" class="playstore-button">Update</button>
                <button formaction="./deleteUser" class="playstore-button">Delete</button>
            </div>
        </form>
    </div>



    <hr>
    <div class="container mt-5 ">
        <span class="fs-2 fw-bold ">User List: </span>
        <table class="mt-2 table fs-4 table-hover table-bordered border-3 border-dark rounded-3">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${user }" >
                <tr>
                    <td>${u.id}</td>
                    <td>${u.password}</td>
                    <td>${u.fullname}</td>
                    <td>${u.email}</td>
                    <td>${u.admin}</td>
                    <td>
                        <a href="./editUser?idU=${u.id}">Edit</a>
                    </td>
                </tr>
             </c:forEach>
                <tr class="bg-light">

                    <td colspan="6">
                        <div class="d-flex justify-content-between">
                            <div>
                                <span>128 User</span>
                            </div>
                            <div class="">
                                <button class="playstore-button"><i class="p1 fa-solid fa-backward-fast"></i> </button>
                                <button class="playstore-button"><i class="p1 fa-solid fa-backward"></i></button>
                                <button class="playstore-button"><i class="p1 fa-solid fa-forward"></i> </button>
                                <button class="playstore-button"><i class="p1 fa-solid fa-forward-fast"></i> </button>
                            </div>
                        </div>

                    </td>
                </tr>
            </tbody>
        </table>

    </div>
	<%@ include file="footer.jsp" %>
    <style>
        .bg-form {
            background-color: rgb(28, 172, 201);
        }
    </style>

</body>

</html>