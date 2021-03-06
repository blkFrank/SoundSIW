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
	<script src="js/AggiungiRecensione.js"></script>
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
				<c:forEach items="${songs}" var="item" varStatus="status">
                <!-- START ITEM AREA -->
                <div class="row" id="review" value="${reviews[status.index]}">
                	<!-- START SONGS AREA -->
	                <div class="col-sm-5">  
	                	<div id="loading" class="loader" style="display: none;" ></div>  
	                	<div class="single-song-area d-flex flex-wrap align-items-end">
	                        <button style="background-color:black;" class="btn single-song-area mb-10 d-flex flex-wrap align-items-end" type="submit" name="carica" onclick="CaricaBrano('${item.titolo}', '${item.id}')">
	                            <img src="${item.thumbnail}" alt="">
	                        </button>
	                        <div class="song-play-area">
	                            <div class="song-name">
	                                <p size="25" value="${item.titolo}">
	                                	<b>
	                                		${item.titolo}
	                                	</b>
	                                </p>
	                            </div>
	                        </div>
	                        <div>
	                			<button class="btn oneMusic-btn mt-15" type="button" name="rimuoviPlaylist" onclick="RimuoviBranoPlaylist('${item.titolo}', '${item.id}')"> Rimuovi </button>
	                		</div>
	                   		
	                    </div>
	                </div>
	                <!-- END SONGS AREA -->
	           		<!-- START REVIEWS AREA -->               		
					<div class="col-sm-3">
						<div class="rating-block">
							<h4>Average user rating</h4>
							<h2 class="bold padding-bottom-7">${reviews[status.index].rating} <small>on ${reviews[status.index].reviewTot} total</small></h2>
							<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" type="submit" name="oneStar" onclick="AggiungiRecensione('${item.id}', 1)">
							  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</button>
							<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" type="submit" name="twoStars" onclick="AggiungiRecensione('${item.id}', 2)">
							  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</button>
							<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" type="submit" name="threeStars" onclick="AggiungiRecensione('${item.id}', 3)">
							  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</button>
							<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" type="submit" name="fourStars" onclick="AggiungiRecensione('${item.id}', 4)">
							  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</button>
							<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" type="submit" name="fiveStars" onclick="AggiungiRecensione('${item.id}', 5)">
							  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</button>
						</div>
					</div>
					<div class="col-sm-4">
						<h4>Rating breakdown</h4>
						<div class="pull-left">
							<div class="pull-left" style="width:35px; line-height:1;">
								<div style="height:9px; margin:5px 0;">5 <span class="glyphicon glyphicon-star"></span></div>
							</div>
							<div class="pull-left" style="width:180px;">
								<div class="progress" style="height:9px; margin:8px 0;">
								  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="3" aria-valuemin="0" aria-valuemax="5" style="width: ${(reviews[status.index].fiveStars*100)/reviews[status.index].reviewTot}%">
									<span class="sr-only">80% Complete (danger)</span>
								  </div>
								</div>
							</div>
							<div class="pull-right" style="margin-left:10px;">${reviews[status.index].fiveStars}</div>
						</div>
						<div class="pull-left">
							<div class="pull-left" style="width:35px; line-height:1;">
								<div style="height:9px; margin:5px 0;">4 <span class="glyphicon glyphicon-star"></span></div>
							</div>
							<div class="pull-left" style="width:180px;">
								<div class="progress" style="height:9px; margin:8px 0;">
								  <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="4" aria-valuemin="0" aria-valuemax="5" style="width: ${(reviews[status.index].fourStars*100)/reviews[status.index].reviewTot}%">
									<span class="sr-only">80% Complete (danger)</span>
								  </div>
								</div>
							</div>
							<div class="pull-right" style="margin-left:10px;">${reviews[status.index].fourStars}</div>
						</div>
						<div class="pull-left">
							<div class="pull-left" style="width:35px; line-height:1;">
								<div style="height:9px; margin:5px 0;">3 <span class="glyphicon glyphicon-star"></span></div>
							</div>
							<div class="pull-left" style="width:180px;">
								<div class="progress" style="height:9px; margin:8px 0;">
								  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="3" aria-valuemin="0" aria-valuemax="5" style="width: ${(reviews[status.index].threeStars*100)/reviews[status.index].reviewTot}%">
									<span class="sr-only">80% Complete (danger)</span>
								  </div>
								</div>
							</div>
							<div class="pull-right" style="margin-left:10px;">${reviews[status.index].threeStars}</div>
						</div>
						<div class="pull-left">
							<div class="pull-left" style="width:35px; line-height:1;">
								<div style="height:9px; margin:5px 0;">2 <span class="glyphicon glyphicon-star"></span></div>
							</div>
							<div class="pull-left" style="width:180px;">
								<div class="progress" style="height:9px; margin:8px 0;">
								  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="5" style="width: ${(reviews[status.index].twoStars*100)/reviews[status.index].reviewTot}%">
									<span class="sr-only">80% Complete (danger)</span>
								  </div>
								</div>
							</div>
							<div class="pull-right" style="margin-left:10px;">${reviews[status.index].twoStars}</div>
						</div>
						<div class="pull-left">
							<div class="pull-left" style="width:35px; line-height:1;">
								<div style="height:9px; margin:5px 0;">1 <span class="glyphicon glyphicon-star"></span></div>
							</div>
							<div class="pull-left" style="width:180px;">
								<div class="progress" style="height:9px; margin:8px 0;">
								  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="5" style="width: ${(reviews[status.index].oneStar*100)/reviews[status.index].reviewTot}%">
									<span class="sr-only">80% Complete (danger)</span>
								  </div>
								</div>
							</div>
							<div class="pull-right" style="margin-left:10px;">${reviews[status.index].oneStar}</div>
						</div>
					</div>
               		<!-- END REVIEWS AREA --> 
                </div>
                <!-- END ITEMS AREA -->
                <br>
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