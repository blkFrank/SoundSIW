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
                            <!-- Nav End -->

                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/Fabri-Fibra2.jpg);">
        <div class="bradcumbContent">
            
            <h2>NEWS</h2>
        </div>
        		
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### News Area Start ##### -->
    <section class="login-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="login-content">
                        <h3>Aggiungi News</h3>
                        <!-- Login Form -->
                        <div class="login-form">
                            <form action="NewsS" method="post">
                                <div class="form-group">
                                    <label for="exampleInputTitolo">Titolo</label>
                                    <input type="text" class="form-control" name="titolo" id="titolo" aria-describedby="titoloHelp" placeholder="Inserisci titolo news">
                                </div>
                                <div class="form-group">
                                    <label for="date">Data</label>
                                    <input type="date" class="form-control"  name="data" id="data" placeholder="Inserisci data news">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputContenuto">
                                    Contenuto
                                    <textarea class="form-control" name="contenuto" id="contenuto" cols="120" placeholder="Inserisci contenuto news"></textarea>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputLinkImg">Link Immagine</label>
                                    <input type="text" class="form-control" name="linkImg" id="linkImg" aria-describedby="linkImgHelp" placeholder="Inserisci link immagine">
                                </div>
                                <button type="submit" class="btn oneMusic-btn mt-30">Aggiungi</button>
                                	
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Login Area End ##### -->

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