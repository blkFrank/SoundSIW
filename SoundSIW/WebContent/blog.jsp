<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>SoundSiw</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

</head>

<body>
<form action="MostraNewsServlet" method="get">
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="lds-ellipsis">
           
        </div>
    </div>

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">
        <!-- Navbar Area -->
        <div class="oneMusic-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="oneMusicNav">

                        <!-- Nav brand -->
                        <a href="index.jsp" class="nav-brand"><img src="img/core-img/logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                             <div class="classynav">
                                <ul>
                                    <c:if test="${ loggatoAdmin or loggato }">
                                        <li><a href="playlist.jsp">PlayList</a></li>
                                        <li><a href="contact.jsp">Contattaci</a></li>
	                                    <c:if test="${loggato }">
	                                    	<li><a href="MostraNewsServlet">News</a></li>
	                                    </c:if>
                                    </c:if>
                                    <c:if test="${loggatoAdmin }"> 
                                		<li><a href="GestioneNews.jsp">Gestione news</a></li>
                                    </c:if>
                                </ul>

                                <!-- Login/Register & Cart Button -->
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <!-- Login/Register -->
                                    <div class="login-register-btn mr-50">
                                        <a href="registrazione.jsp" id="RegistratiBtn">Registrati</a>
                                    </div>
									<c:if test="${not loggato }">
	                                    <!-- Login -->
	                                    <div class="login-register-btn mr-50">
	                                        <a href="login.jsp" id="loginBtn">Login</a>
	                                    </div>
                                    </c:if>
                                    <c:if test="${loggato }"> 
                                    	<div class="login-register-btn mr-50">
                                    	
                                        <a href="Logout">Logout</a>
                                    	</div>
                                    </c:if>
                                 </div>

								 
                                    <!-- Cart Button -->
                                    <div class="cart-btn">
                                        
                                    </div>
                                </div>
                            </div>
                            		

                                   </nav>
                                </div>
                            </div>
                            <!-- Nav End -->

                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
</form>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/deAndre.jpg);">
        <div class="bradcumbContent">
            
            <h2>News</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Blog Area Start ##### -->
    <div class="blog-area section-padding-100">
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-12">
	                
		                <c:forEach items="${newss}" var="item">
			                <!-- Single Post Start -->
		                    <div class="single-blog-post mb-100 wow fadeInUp" data-wow-delay="100ms">
					                <!-- Post Thumb -->
		                        <div class="blog-post-thumb mt-30">
		                            <a href="#"><img src="img/bg-img/blog2.jpg" alt=""></a>
		                            <!-- Post Date -->
		                            <div class="post-date">
		                                <h6>${item.data}</h6>
		                            </div>
		                        </div>
	                        	<!-- Blog Content -->
		                        <div class="blog-content">
		                            <!-- Post Title -->
		                            <a href="#" class="post-title">${item.titolo}</a>
		                            <!-- Post Meta -->
		                            <div class="post-meta d-flex mb-30">
		                                <p class="post-author">By<a href="#"> Admin</a></p>
		                            </div>
		                            <!-- Post Excerpt -->
		                            <p> ${item.contenuto} </p>
		                        </div>
		                    </div>
						</c:forEach>
	                </div>
            </div>
        </div>
    </div>
    <!-- ##### Blog Area End ##### -->

    

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">
        <div class="container">
            <div class="row d-flex flex-wrap align-items-center">
                <div class="col-12 col-md-6">
                    <a href="#"><img src="img/core-img/logo.png" alt=""></a>
                    <p class="copywrite-text"><a href="#"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>

                
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area Start ##### -->

    <!-- ##### All Javascript Script ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
    
    <script src="js/MostraNews.js"></script>
    
</body>

</html>