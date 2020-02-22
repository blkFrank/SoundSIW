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
	<script src="js/AutocompleteSearch.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" type="text/css" />
	<script src="//code.jquery.com/jquery-2.1.4.js" type="text/javascript"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js" type="text/javascript"></script>
								
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
                                    <li><a href="login.jsp">Brani</a></li>
                                    <li><a href="login.jsp">Playlist</a></li>
                                    <li><a href="login.jsp">News</a></li>
                                    <li><a href="login.jsp">Contattaci</a></li>
                                    <!-- Login -->
                                    <li><a href="registrazione.jsp">Registrati</a></li>
                                    <li><a href="login.jsp" id="loginBtn">Login</a></li>
                                    </c:if>
                                </ul>
                            </div>
                            
                            <div class="classynav">
                                <ul>
									<c:if test="${not loggatoAdmin and loggato }">
	                                    <li><a href="index.jsp">Home</a></li>
	                                    <li><a href="brani.jsp">Brani</a></li>
	                                    <li><a href="MostraPlaylistServlet">Playlist</a></li>
	                                    <li><a href="MostraNewsServlet">News</a></li>
	                                    <li><a href="contact.jsp">Contattaci</a></li>
	                                    <!-- Logout -->
	                                    <li><a href="Logout">Logout</a></li>
	                                 </c:if>
                             	</ul>
                             </div>
                             
                             <div class="classynav">
                                <ul>
	                                 <c:if test="${loggatoAdmin }">
	                                  <li><a href="index.jsp">Home</a></li>
	                                    <li><a href="brani.jsp">Brani</a></li>
	                                    <li><a href="MostraPlaylistServlet">Playlist</a></li>
	                                    <li><a href="MostraNewsServlet">News</a></li>
	                                    <li><a href="GestioneNews.jsp">Gestione News</a></li>
	                                    <li><a href="MostraUtentePiuAttivo">Statistiche</a></li>
	                                    <li><a href="contact.jsp">Contattaci</a></li>
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

    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/j-ax.jpg);">
        <div class="bradcumbContent">
           
            <h2>Statistiche</h2>
        </div>
    </section>
    <div class="col-12">
                    <div class="elements-title mb-70">
                       
                    </div>
                </div>

                <div class="col-12">
                    <!-- Loaders Area Start -->
                    
                    <div class="our-skills-area">
                        <div class="row">
								
					
                            <!-- Single Skills Area -->
                            
                            <div class="col-12 col-sm-6 col-lg-4" >
                                <div class="single-skils-area mb-100" >
                                    <div id="circle" class="circle" data-value="${grafico}">
                                        <div class="skills-text" >
                                            <span>${percentuale}%</span>
                                            
                                        </div>
                                        <p>${utente}</p>
                                        <p>UTENTE PIU' ATTIVO</p>
                                    </div>
                                </div>
                                
                            </div>
							
                            <!-- Single Skills Area -->
                            <div class="col-12 col-sm-6 col-lg-4">
                                <div class="single-skils-area mb-100">
                                    <div id="circle2" class="circle" data-value="${graficoRicerca}">
                                        <div class="skills-text">
                                            <span>${percentualeRicerca}%</span>
                                            
                                        </div>
                                        <p>${ricerca} </p>
                                         <p>RICERCA PIU' ESEGUITA</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Single Skills Area -->
                            <div class="col-12 col-sm-6 col-lg-4">
                                <div class="single-skils-area mb-100">
                                    <div id="circle3" class="circle" data-value="${graficoBrano}">
                                        <div class="skills-text">
                                            <span>${percentualeBrano}%</span>
                                           
                                        </div>
                                        <p>${brano}</p>
                                        <p>BRANO PIU' ASCOLTATO</p>
                                    </div>
                                </div>
                            </div>

                            
                        </div>
                    </div>
                </div>
    
    </section>
    <!-- ##### Contact Area End ##### -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
    <!-- ##### Contact Area Start ##### -->
  
    <!-- ##### Contact Area End ##### -->

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
				  <div class="col-12 col-md-6">
                	
					<!-- Icon-only Branded Twitter button -->
					<a class="share-btn share-btn-branded share-btn-twitter"
					   href="https://twitter.com/share?url=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F&text=SoundSIW è il miglior sito di musica del momento!&via=SoundSIW"
					   title="Share on Twitter">
						<span class="share-btn-icon"></span>
						<span class="share-btn-text-sr">Twitter</span>
					</a>
				
					<!-- Icon-only Branded Facebook button -->
					<a class="share-btn share-btn-branded share-btn-facebook"
					   href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F"
					   title="Share on Facebook">
						<span class="share-btn-icon"></span>
						<span class="share-btn-text-sr">Facebook</span>
					</a>
						<!-- Icon-only More/share button -->
					<a class="share-btn share-btn-more"
					   href="https://www.addtoany.com/share_save?linkurl=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F"
					   title="More share options">
						<span class="share-btn-icon"></span>
						<span class="share-btn-text-sr">More</span>
					</a>
                </div>	
                
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area Start ##### -->

    <!-- ##### All Javascript Script ##### -->
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
</body>

