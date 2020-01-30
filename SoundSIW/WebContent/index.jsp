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
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="lds-ellipsis">
            <div></div>
            <div></div>
            <div></div>
            <div></div>
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
                                    <c:if test="${not loggatoAdmin and loggato }">
                                    <li><a href="#">La tua libreria</a>
                                        <ul class="dropdown">
                                           
                                           
                                            <li><a href="MostraPlaylistServlet">PlayList</a></li>
                                            <li><a href="contact.jsp">Contattaci</a></li>
                                           
                                            </li>
                                        </ul>
                                    </li>
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
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <!-- Login -->
                                    <div class="login-register-btn mr-50">
                                        <a href="login.jsp" id="loginBtn">Login</a>
                                    </div>
                                    </div>
                                    </c:if>

								 <c:if test="${loggato }"> 
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <!-- Logout -->
                                    <div class="login-register-btn mr-50">
                                    	
                                        <a href="Logout">Logout</a>
                                    </div>
                                    </div>
                                    </c:if>
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
        <c:if test="${loggato and not loggatoAdmin }">
        
	         <form method="post" action="YoutubeSearchServlet">
	            <div class="container">
             		<div class="row justify-content-lg-center">
                 		<div class="col-lg-5">
	             			<input type="text" id="search" name="search" placeholder="Cerca la tua canzone..." autocomplete="off" class="form-control" size="20" />
	             		</div>
	         		</div>
	         		<div class="row justify-content-lg-center">
	             		<div class="col-sm-12 col-lg-3">
	         			<input type="submit" value="Cerca" class="btn oneMusic-btn mt-30">
	         			</div>
	         		</div>
	         	</div>
	        </form>
		
        </c:if>
    </header>
    
    <!-- ##### Header Area End ##### -->
		
    <!-- ##### Hero Area Start ##### -->
    <section class="hero-area">
    	
        <div class="hero-slides owl-carousel">
       <!-- <jsp:useBean id="YoutubeVideoSearch" scope="page" class="servlet.YoutubeSearchServlet" /> -->
            <!-- Single Hero Slide -->
            <div class="single-hero-slide d-flex align-items-center justify-content-center">
                <!-- Slide Img -->
                <div class="slide-img bg-img" style="background-image: url(img/bg-img/Celentano.jpg);"></div>
                <!-- Slide Content -->                
                <div class="container">
                    <div class="row">
                        <div class="col-12">                        		
                            <div class="hero-slides-content text-center">
                            		<c:if test="${loggato }">
                                <h2 data-animation="fadeInUp" data-delay="300ms">SoundSiw<span>SoundSiw</span></h2>
                                	</c:if>
                                		<c:if test="${not loggato }">
                          <h2 data-animation="fadeInUp" data-delay="300ms">Iscriviti o accedi a SoundSiw<span>Iscriviti o accedi a SoundSiw</span></h2>
                                	</c:if>
                                <!-- <a data-animation="fadeInUp" data-delay="500ms" href="#" class="btn oneMusic-btn mt-50">Discover <i class="fa fa-angle-double-right"></i></a>-->
								<!--<c:if test="${not loggatoAdmin }">
	                            <form method="post" action="YoutubeSearchServlet">
		                        	<input type="text" id="search" name="search" placeholder="Type something..." autocomplete="off" class="form-control" size="20" />
		                    			<input type="submit" value="Search" class="form-control btn btn-primary w100">
	                    		</form>
	                    		</c:if>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		
            <!-- Single Hero Slide -->
            <div class="single-hero-slide d-flex align-items-center justify-content-center">
                <!-- Slide Img -->
                <div class="slide-img bg-img" style="background-image: url(img/bg-img/Ligabue.jpg);"></div>
                <!-- Slide Content -->
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="hero-slides-content text-center">                               
                                <c:if test="${not loggato }">
                          <h2 data-animation="fadeInUp" data-delay="300ms">Iscriviti o accedi a SoundSiw<span>Iscriviti o accedi a SoundSiw</span></h2>
                                	</c:if>
                                <!--  <a data-animation="fadeInUp" data-delay="500ms" href="#" class="btn oneMusic-btn mt-50">Discover <i class="fa fa-angle-double-right"></i></a> -->
	                           <!--  <c:if test="${not loggatoAdmin }">
	                            <form method="post" action="YoutubeSearchServlet">
	                                <input type="text" id="search" name="search" placeholder="Type something..." autocomplete="off" class="form-control" size="20" />
	                    				<input type="submit" value="Search" class="form-control btn btn-primary w100">
                    			</form>
                    			</c:if> -->
                                <!--  <a data-animation="fadeInUp" data-delay="500ms" href="#" class="btn oneMusic-btn mt-50">Discover <i class="fa fa-angle-double-right"></i></a>
                            -->    
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
   

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">
        <div class="container">
            <div class="row d-flex flex-wrap align-items-center">
                <div class="col-12 col-md-6">
                    <a href="#"><img src="img/core-img/logo.png" alt=""></a>
                    <p class="copywrite-text">
						Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
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
</body>

</html>