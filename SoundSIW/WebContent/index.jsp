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
	<script src="js/CaricaBrano.js"></script>
	<script src="js/RimuoviBranoPlaylist.js"></script>
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
                                	<c:if test="${not loggato}">
                                    <li><a href="index.jsp">Home</a></li>
                                    <li><a href="registrazione.jsp">Registrati</a></li>
                                    <li><a href="login.jsp">Contattaci</a></li>
                                    <li><a href="login.jsp">News</a></li>
                                    <li><a href="login.jsp">Brani</a></li>
                                    <li><a href="login.jsp">Playlist</a></li>
                                    <!-- Login -->
                                    <li><a href="login.jsp" id="loginBtn">Login</a></li>
                                    </c:if>
                                </ul>
                            </div>
                            
                            <div class="classynav">
                                <ul>
									<c:if test="${not loggatoAdmin and loggato }">
	                                    <li><a href="index.jsp">Home</a></li>
	                                    <li><a href="MostraPlaylistServlet">Playlist</a></li>
	                                    <li><a href="contact.jsp">Contattaci</a></li>
	                                    <li><a href="MostraNewsServlet">News</a></li>
	                                    <li><a href="brani.jsp">Brani</a></li>
	                                    <!-- Logout -->
	                                    <li><a href="Logout">Logout</a></li>
	                                 </c:if>
                             	</ul>
                             </div>
                             
                             <div class="classynav">
                                <ul>
	                                 <c:if test="${loggatoAdmin }">
	                                  <li><a href="index.jsp">Home</a></li>
	                                    <li><a href="MostraPlaylistServlet">Playlist</a></li>
	                                    <li><a href="contact.jsp">Contattaci</a></li>
	                                    <li><a href="MostraNewsServlet">News</a></li>
	                                    <li><a href="GestioneNews.jsp">Gestione News</a></li>
	                                    <li><a href="statistiche.jsp">Statistiche</a></li>
	                                    <!-- Logout -->
	                                    <li><a href="Logout">Logout</a></li>
	                                 </c:if>
                                </ul>
                             </div>
						</div>
								 
                   </nav>
               </div>
           </div>
		</div>
                      <!-- Nav End -->
               
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
                                <h2 data-animation="fadeInUp" data-delay="300ms">Sound<span>Sound</span></h2>
                                	</c:if>
                                		<c:if test="${not loggato }">
                          <h2 data-animation="fadeInUp" data-delay="300ms">Iscriviti o accedi <span>Iscriviti o accedi</span></h2>
                                	</c:if>
                          
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
                          <h2 data-animation="fadeInUp" data-delay="300ms">Ascolta i tuoi brani dove vuoi e quando vuoi!<span>Ascolta i tuoi brani dove vuoi e quando vuoi!</span></h2>
                                	</c:if>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
   
   <section class="latest-albums-area section-padding-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading style-2">
                        
                        <h2>2,5 ore al giorno, 18 a settimana, la musica è parte integrante della nostra vita!</h2>
                    </div>
                </div>
            </div>
            </div>
            </section>


 <!-- ##### Featured Artist Area Start ##### -->
    <section class="featured-artist-area section-padding-100 bg-img bg-overlay bg-fixed" style="background-image: url(img/bg-img/bg-4.jpg);">
        <div class="container">
            <div class="row align-items-end">
                <div class="col-12 col-md-5 col-lg-4">
                    <div class="featured-artist-thumb">
                        <img src="img/bg-img/musica.png" alt="">
                    </div>
                </div>
                <div class="col-12 col-md-7 col-lg-8">
                    <div class="featured-artist-content">
                        <!-- Section Heading -->
                        <div class="section-heading white text-left mb-30">
                            <p>Sound</p>
                            <h2>Sound è una piattaforma online che ti offre un' esperienza musicale a 360°, puoi ascoltare musica , visualizzare notizie e creare playlist personalizzate!</h2>
                        </div>
                        
                        
                        </div>
                    </div>
                </div>
            </div>
        
    </section>
    <!-- ##### Featured Artist Area End ##### -->

  		<c:if test="${ loggato }">
            <div class="row">
                <div class="col-12">
                    <div class="albums-slideshow owl-carousel">
                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="MostraNewsServlet">
                            	<img src="img/png/news.png" alt="">
                            </a>
                            <div class="album-info">
                               <h5>NEWS</h5>
                                
                            </div>
                        </div>

                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="MostraPlaylistServlet">
                            	<img src="img/png/playlist.png" alt="">
                            </a>
                            <div class="album-info">
                                
                                    <h5>PLAYLIST</h5>
                                
                                
                            </div>
                        </div>

                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="brani.jsp">
                            	<img src="img/png/track.png" alt="">
                            </a>
                            <div class="album-info">
                               
                                    <h5>BRANI</h5>
                                
                                
                            </div>
                        </div>

                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="contact.jsp">
                            	<img src="img/png/contactus.png" alt="">
                            </a>
                            <div class="album-info">
                                
                                    <h5>CONTATTI</h5>
                               
                                
                            </div>
                        </div>
 
                    </div>
                </div>
            </div>
		</c:if>
		<c:if test="${not loggato }">
			<div class="row">
                <div class="col-12">
                    <div class="albums-slideshow owl-carousel">
                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="login.jsp">
                            	<img src="img/png/news.png" alt="">
                            </a>
                            <div class="album-info">
                               <h5>NEWS</h5>
                                
                            </div>
                        </div>

                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="login.jsp">
                            	<img src="img/png/playlist.png" alt="">
                            </a>
                            <div class="album-info">
                                
                                    <h5>PLAYLIST</h5>
                                
                                
                            </div>
                        </div>

                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="login.jsp">
                            	<img src="img/png/track.png" alt="">
                            </a>
                            <div class="album-info">
                               
                                    <h5>BRANI</h5>
                                
                                
                            </div>
                        </div>

                        <!-- Single Album -->
                        <div class="single-album">
                        	<a href="login.jsp">
                            	<img src="img/png/contactus.png" alt="">
                            </a>
                            <div class="album-info">
                                
                                    <h5>CONTATTI</h5>
                               
                                
                            </div>
                        </div>
 
                    </div>
                </div>
            </div>
		</c:if>
   
   <br>
   <br>
   <br>
    <!-- ##### Latest Albums Area End ##### -->
   

	
            
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