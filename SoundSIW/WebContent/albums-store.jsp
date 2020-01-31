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
	
	<!-- Script -->
	
	<script src="js/CaricaBrano.js"></script>
	<script src="js/AggiungiBranoPlaylist.js"></script>
	
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
    <!-- ##### Header Area End ##### -->
	
    <!-- ##### Breadcumb Area Start ##### -->
     
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/Ligabue.jpg);">
        <!--  
        <div class="bradcumbContent">
            
        </div>
        -->
        
    </section>
    
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Album Catagory Area Start ##### -->
    <!-- 
    <section class="album-catagory section-padding-100-0">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="browse-by-catagories catagory-menu d-flex flex-wrap align-items-center mb-70">
                        <a href="#" data-filter="*">Browse All</a>
                        <a href="#" data-filter=".a" class="active">A</a>
                        <a href="#" data-filter=".b">B</a>
                        <a href="#" data-filter=".c">C</a>
                        <a href="#" data-filter=".d">D</a>
                        <a href="#" data-filter=".e">E</a>
                        <a href="#" data-filter=".f">F</a>
                        <a href="#" data-filter=".g">G</a>
                        <a href="#" data-filter=".h">H</a>
                        <a href="#" data-filter=".i">I</a>
                        <a href="#" data-filter=".j">J</a>
                        <a href="#" data-filter=".k">K</a>
                        <a href="#" data-filter=".l">L</a>
                        <a href="#" data-filter=".m">M</a>
                        <a href="#" data-filter=".n">N</a>
                        <a href="#" data-filter=".o">O</a>
                        <a href="#" data-filter=".p">P</a>
                        <a href="#" data-filter=".q">Q</a>
                        <a href="#" data-filter=".r">R</a>
                        <a href="#" data-filter=".s">S</a>
                        <a href="#" data-filter=".t">T</a>
                        <a href="#" data-filter=".u">U</a>
                        <a href="#" data-filter=".v">V</a>
                        <a href="#" data-filter=".w">W</a>
                        <a href="#" data-filter=".x">X</a>
                        <a href="#" data-filter=".y">Y</a>
                        <a href="#" data-filter=".z">Z</a>
                        <a href="#" data-filter=".number">0-9</a>
                    </div>
                </div>
            </div>

            <div class="row oneMusic-albums">
		-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/bg-img/a1.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>The Cure</h5>
                            </a>
                            <p>Second Song</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item s e q">
                    <div class="single-album">
                        <img src="img/bg-img/a2.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>Sam Smith</h5>
                            </a>
                            <p>Underground</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item w f r">
                    <div class="single-album">
                        <img src="img/bg-img/a3.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>Will I am</h5>
                            </a>
                            <p>First</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!-- 
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t g u">
                    <div class="single-album">
                        <img src="img/bg-img/a4.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>The Cure</h5>
                            </a>
                            <p>Second Song</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!-- 
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item d h v">
                    <div class="single-album">
                        <img src="img/bg-img/a5.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>DJ SMITH</h5>
                            </a>
                            <p>The Album</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t i x">
                    <div class="single-album">
                        <img src="img/bg-img/a6.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>The Ustopable</h5>
                            </a>
                            <p>Unplugged</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item b j y">
                    <div class="single-album">
                        <img src="img/bg-img/a7.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>Beyonce</h5>
                            </a>
                            <p>Songs</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item a k z">
                    <div class="single-album">
                        <img src="img/bg-img/a8.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>Aam Smith</h5>
                            </a>
                            <p>Underground</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item w l number">
                    <div class="single-album">
                        <img src="img/bg-img/a9.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>Will I am</h5>
                            </a>
                            <p>First</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item d m">
                    <div class="single-album">
                        <img src="img/bg-img/a10.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>DJ SMITH</h5>
                            </a>
                            <p>The Album</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t n">
                    <div class="single-album">
                        <img src="img/bg-img/a11.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>The Ustopable</h5>
                            </a>
                            <p>Unplugged</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album -->
                <!--  
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item b o">
                    <div class="single-album">
                        <img src="img/bg-img/a12.jpg" alt="">
                        <div class="album-info">
                            <a href="#">
                                <h5>Beyonce</h5>
                            </a>
                            <p>Songs</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    -->
    <!-- ##### Album Catagory Area End ##### -->

    <!-- ##### Buy Now Area Start ##### -->
      
    <div class="oneMusic-buy-now-area mb-100">
        <div class="container">
            <div class="row">

                <!-- Single Album Area -->
                <!--    
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-album-area">
                        <div class="album-thumb">
                            <img src="img/bg-img/b1.jpg" alt="">
                            -->
                            <!-- Album Price -->
                            <!--  
                            <div class="album-price">
                                <p>$0.90</p>
                            </div>
                            -->
                            <!-- Play Icon -->
                            <!--  
                            <div class="play-icon">
                                <a href="#" class="video--play--btn"><span class="icon-play-button"></span></a>
                            </div>
                        </div>
                        <div class="album-info">
                            <a href="#">
                                <h5>Garage Band</h5>
                            </a>
                            <p>Radio Station</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album Area -->
                <!--  
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-album-area">
                        <div class="album-thumb">
                            <img src="img/bg-img/b2.jpg" alt="">
                        </div>
                        <div class="album-info">
                            <a href="#">
                                <h5>Noises</h5>
                            </a>
                            <p>Buble Gum</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album Area -->
                <!--  
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-album-area">
                        <div class="album-thumb">
                            <img src="img/bg-img/b3.jpg" alt="">
                        </div>
                        <div class="album-info">
                            <a href="#">
                                <h5>Jess Parker</h5>
                            </a>
                            <p>The Album</p>
                        </div>
                    </div>
                </div>
				-->
                <!-- Single Album Area -->
                <!--  
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-album-area">
                        <div class="album-thumb">
                            <img src="img/bg-img/b4.jpg" alt="">
                        </div>
                        <div class="album-info">
                            <a href="#">
                                <h5>Noises</h5>
                            </a>
                            <p>Buble Gum</p>
                        </div>
                    </div>
                </div>

            </div>
-->
            <div class="row">
                <div class="col-12">
                    <div class="load-more-btn text-center">
                       <!--   <a href="#" class="btn oneMusic-btn">Load More <i class="fa fa-angle-double-right"></i></a> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- ##### Buy Now Area End ##### -->

    <!-- ##### Add Area Start ##### -->
    <!--  
    <div class="add-area mb-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="adds">
                        <a href="#"><img src="img/bg-img/add3.gif" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    -->
    <!-- ##### Add Area End ##### -->
    
    
    
    <!-- ##### Song Area Start ##### -->
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
                			<button class="btn oneMusic-btn mt-15" type="submit" name="caricaPlaylist" onclick="AggiungiBranoPlaylist('${item.titolo}', '${item.id}')">Aggiungi alla playlist </button>
                		</div>
                   		
                    </div>
                </div>
                
               
                </div>
               
                <!-- End Single Song Area -->
                </c:forEach>
     
           
        </div>
    </div>
    
    
    <!--  
    <div class="one-music-songs-area mb-70">
        <div class="container">
        	
            <c:forEach items="${songs}" var="item" varStatus="loop">
                <div class="row">
                
                <button style="background-color:black; width:300px;" class="btn single-song-area mb-30 d-flex flex-wrap align-items-end" type="submit" name="carica" onclick="CaricaBrano('${item.titolo}', '${item.id}')">   
                <div class="col-12">    
                		
                        <div class="song-thumbnail">
                            <img id="thumbnail-${loop.index}" src="${item.thumbnail}" alt="">
                        </div>
                        
                            <div class="song-name">
                                <p id="titolo-${loop.index}" value="${item.titolo}">${item.titolo}</p>
                            
                            </div>
                        
                </div>
                </button>
              
                <button style="left:120px" class="btn oneMusic-btn mt-30" type="submit" name="caricaPlaylist" onclick="AggiungiBranoPlaylist('${item.titolo}', '${item.id}')">Aggiungi alla playlist </button>
               
               
                </div>
               
                </c:forEach>
           
        </div>
    </div>
    -->
    <!-- ##### Song Area End ##### -->
						<!-- ##### Player Area Start ##### -->
			
						<div class="song-play-area" style="position:fixed; right:200px; left: 200px; bottom:40px; z-index:3;">
                        	  
                        	<div id="player" >
                            	<!--  
                            	<div class="song-name" var="playerItem">
                                	<p>${playerItem.titolo}</p>
                            	</div>
                            	<audio preload="auto" controls>
	    							<source src="audio/hcVU07nOhw4.mp3">
	    						</audio>
	    						  -->
                        	</div>
                        	  
    					</div>
   	 					<!-- ##### Player Area End ##### -->
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