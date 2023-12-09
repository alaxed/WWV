<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Video Catalog</title>
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<!--TemplateMo 552 Video Catalog https://templatemo.com/tm-552-video-catalog -->
</head>
<body>
	<div class="tm-page-wrap mx-auto">
		<%@ include file="header.jsp"%>

		<!-- Page content -->
		<div class="container-fluid">
			<div class="mx-auto tm-content-container">
				<main>
					<div class="row  pb-4">
						<div class="col-12 ">
							<!-- Video player 1422x800 -->
							<iframe width="1422" height="800"
								src="https://www.youtube.com/embed/${v.id }" frameborder="0"
								allow="autoplay; encrypted-media" allowfullscreen></iframe>
						</div>
					</div>
					<div class="col-xl-6 d-flex  align-item-center ">
						<a><i class="me-2 fs-2 fa-sharp fa-solid fa-eye"></i>${v.views}</a> 
						<c:if test="${not empty sessionScope.currentUser }">
							<c:choose>
								<c:when test="${flagLiked == false}">
									<a href="./video?action=like&idV=${v.id}" class="text-dark text-decoration-none"><i class="ms-5 me-2 fs-2 fas fa-thumbs-up"></i>${r.like }</a>
								</c:when>
								<c:otherwise>
									<a href="./video?action=like&idV=${v.id}" class="text-dark text-decoration-none"><i class="ms-5 me-2 fs-2 fa-solid fa-thumbs-down"></i>${r.like }</a>
								</c:otherwise>
							</c:choose>
							
							
						</c:if>
					</div>
					

					<div class="row mb-5 pb-5">
						<div class="col-xl-8 col-lg-7">
							<!-- Video description -->
							<div class="tm-video-description-box mt-5">
								<span>${v.description }</span>
							</div>

						</div>
						<div class="col-xl-4 col-lg-5">
							<!-- Share box -->
							<div class="tm-bg-gray tm-share-box">
								<c:if test="${not empty sessionScope.currentUser }">
									<h6 class="tm-share-box-title mb-4">Share this video</h6>
										<form action="" method="GET">
											<!-- class="tm-subscribe-form"  -->
											<div class="form-group">
												<input type="text" class="form-control" name="email"
													placeholder="Your Email..." required>
													<span class="fs-6 text-center text-danger">${mess}</span>
		
											</div>
											<button formaction="./share?idV=${v.id}" formmethod="post" type="submit"
												class=" float-end btn rounded-0 btn-primary tm-btn-small">Share</button>
											<br>
		
										</form>
								</c:if>
								



							</div>
						</div>
					</div>
					<div class="row pt-4 pb-5">
						<div class="col-12">
							<h2 class="mb-5 tm-text-primary">Related Videos for You</h2>
							<div class="row tm-catalog-item-list">
								<c:forEach var="rdV" items="${rdV}" begin="0" end="5">

									<div class="col-lg-4 col-md-6 col-sm-12 tm-catalog-item">
										<div class="position-relative tm-thumbnail-container">
											<img
												src="https://img.youtube.com/vi/${rdV.poster}/maxresdefault.jpg"
												alt="Image" class="img-fluid tm-catalog-item-img"> <a
												href="./video?action=watch&idV=${rdV.id}"
												class="position-absolute tm-img-overlay"> <i
												class="fas fa-play tm-overlay-icon"></i>
											</a>
										</div>
										<div class="p-3 tm-catalog-item-description">
											<h3 class="tm-text-gray text-center tm-catalog-item-title">${rdV.title}</h3>
										</div>
									</div>
								</c:forEach>
							</div>

						</div>
					</div>
			</div>
			</main>

			<!-- Subscribe form and footer links -->
			<div class="row mt-5 pt-3">
				<div class="col-xl-6 col-lg-12 mb-4">
					<div class="tm-bg-gray p-5 h-100">
						<h3 class="tm-text-primary mb-3">Do you want to get our
							latest updates?</h3>
						<p class="mb-5">Please subscribe our newsletter for upcoming
							new videos and latest information about our work. Thank you.</p>
						<form action="" method="GET" class="tm-subscribe-form">
							<input type="text" name="email" placeholder="Your Email..."
								required>
							<button type="submit"
								class="btn rounded-0 btn-primary tm-btn-small">Subscribe</button>
						</form>
					</div>
				</div>
				<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 col-12 mb-4">
					<div class="p-5 tm-bg-gray">
						<h3 class="tm-text-primary mb-4">Quick Links</h3>
						<ul class="list-unstyled tm-footer-links">
							<li><a href="#">Duis bibendum</a></li>
							<li><a href="#">Purus non dignissim</a></li>
							<li><a href="#">Sapien metus gravida</a></li>
							<li><a href="#">Eget consequat</a></li>
							<li><a href="#">Praesent eu pulvinar</a></li>
						</ul>
					</div>
				</div>
				<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 col-12 mb-4">
					<div class="p-5 tm-bg-gray h-100">
						<h3 class="tm-text-primary mb-4">Our Pages</h3>
						<ul class="list-unstyled tm-footer-links">
							<li><a href="#">Our Videos</a></li>
							<li><a href="#">License Terms</a></li>
							<li><a href="#">About Us</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Privacy Policies</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- row -->

			<footer class="row pt-5">
				<div class="col-12">
					<p class="text-right">
						Copyright 2020 The Video Catalog Company - Designed by <a
							href="https://templatemo.com" rel="nofollow" target="_parent">TemplateMo</a>
					</p>
				</div>
			</footer>
		</div>
		<!-- .tm-content-container -->
	</div>
	</div>
	
	
	<script>
		$(document).ready(function() {
			$('.tm-likes-box').click(function(e) {
				e.preventDefault();
				$(this).toggleClass('tm-liked');

				if ($(this).hasClass('tm-liked')) {
					$('#tm-likes-count').html('486 likes');
				} else {
					$('#tm-likes-count').html('485 likes');
				}
			});
		});
	</script>
</body>
</html>