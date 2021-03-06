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
           
            <h2>Contattaci</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Contact Area Start ##### -->
    <section class="contact-area section-padding-100-0">
        <div class="container">
            <div class="row">

                <div class="col-12 col-lg-3">
                    <div class="contact-content mb-100">
                        <!-- Title -->
                        <div class="contact-title mb-50">
                            <h5>Informazioni per contattarci</h5>
                        </div>

                        <!-- Single Contact Info -->
                        <div class="single-contact-info d-flex align-items-center">
                            <div class="icon mr-30">
                                <span class="icon-placeholder"></span>
                            </div>
                            <p>Via Pietro Bucci, 87036 Arcavacata, Rende CS</p>
                        </div>

                        <!-- Single Contact Info -->
                        <div class="single-contact-info d-flex align-items-center">
                            <div class="icon mr-30">
                                <span class="icon-smartphone"></span>
                            </div>
                            <p>+53 345 7953 32453</p>
                        </div>

                        <!-- Single Contact Info -->
                        <div class="single-contact-info d-flex align-items-center">
                            <div class="icon mr-30">
                                <span class="icon-mail"></span>
                            </div>
                            <p>soundsiw2020@gmail.com</p>
                        </div>

                        <!-- Contact Social Info -->
                        <div class="contact-social-info mt-50">
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Pinterest"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Behance"><i class="fa fa-behance" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Linkedin"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                        </div>

                    </div>
                </div>

                <div class="col-12 col-lg-9">
                    <!-- ##### Google Maps ##### -->
                    <div class="map-area mb-100">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3028.635005467549!2d16.224458965323258!3d39.35918932950217!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f99a2cb39a49b%3A0x1a529d60540e6425!2sUnical!5e1!3m2!1sit!2sit!4v1575912750818!5m2!1sit!2sit" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen></iframe></iframe>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- ##### Contact Area End ##### -->

    <!-- ##### Contact Area Start ##### -->
    <section class="contact-area section-padding-0-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading">
                       
                        <h2>Aiutaci con suggerimenti a migliorare il sito</h2>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <!-- Contact Form Area -->
                    <div class="contact-form-area">
                        <form action="contattiServlet" method="GET">
                            <div class="row">
                                <div class="col-md-6 col-lg-4">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="nome" placeholder="Nome">
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="form-group">
                                        <input type="email" class="form-control" name="email" placeholder="E-mail">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="oggetto" placeholder="Oggetto">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control" name="messaggio" cols="30" rows="10" placeholder="Messaggio"></textarea>
                                    </div>
                                </div>
                                <div class="col-12 text-center">
                                    <button class="btn oneMusic-btn mt-30" type="submit">Invia <i class="fa fa-angle-double-right"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
					   href="https://twitter.com/share?url=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F&text=SoundSIW � il miglior sito di musica del momento!&via=SoundSIW"
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