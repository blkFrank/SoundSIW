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
    <link href="css/loader.css" rel="stylesheet" type="text/css">

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
				<div id="loading" class="loader" style="display: none;" ></div>
               </div>
           </div>
		</div>
	
                      <!-- Nav End -->	
               
    </header>
    <!-- ##### Header Area End ##### -->


    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/emma2.jpg);">
        <div class="bradcumbContent">
            
            <h2>I tuoi brani</h2>
            		
       </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
   <br>
   <br>
   
   <div class="one-music-songs-area mb-70">
        <div class="container">
        	  			 	
				<c:forEach items="${songs}" var="item" varStatus="loop">
                <div class="row">
                <!-- Start Single Song Area -->
                <div class="col-12"> 
                	<div class="single-song-area mb-30 d-flex flex-wrap align-items-end">
                        <button style="background-color:black;" class="btn single-song-area mb-10 d-flex flex-wrap align-items-end" type="submit" name="carica" onclick="CaricaBrano('${item.titolo}', '${item.id}')">
                            <img id="thumbnail-${loop.index}" src="${item.thumbnail}" alt="">
                        </button>
                        <div class="song-play-area">
                            <div class="song-name">
                                <p id="titolo-${loop.index}" value="${item.titolo}">${item.titolo}</p>
                                <!-- <p1 id="id-${loop.index}" value="${item.id}">${item.id}</p1> -->
                                
                            </div>
                           
                        </div>
                        <div>
                			<button class="btn oneMusic-btn mt-15" type="submit" name="rimuoviPlaylist" onclick="RimuoviBranoPlaylist('${item.titolo}', '${item.id}')">Rimuovi brano </button>
                		</div>
                   		
                    </div>
                </div>
                
               
                </div>
               
                <!-- End Single Song Area -->
                </c:forEach>
     
           
        </div>
    </div>

    <!-- ##### Newsletter & Testimonials Area End ##### -->
    
	<div class="container-fluid" id="containerTrack" style="position:fixed; bottom:40px; z-index:3; display:none">
		<div class="song-play-area">
			<div class="song-name">
				<p id="songName">
				</p>
			</div>
			<audio id="song" preload="auto" controls autoplay>
				<source id="srcAudio" src="audio/test.mp3">
			</audio>
		</div>
	</div>

    
    
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
</body>

</html>