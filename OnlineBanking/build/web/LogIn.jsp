<%-- 
    Document   : Home
    Created on : Dec 17, 2018, 11:24:54 PM
    Author     : gohnem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>BuyStep</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-aller.js"></script>
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script type="text/javascript" src="js/coin-slider.min.js"></script>
    </head>
    <body>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="logo">
                        <h1><a href="index.html">Buy<span>Step</span> <small>Company Slogan Here</small></a></h1>
                    </div>
                    <div class="menu_nav">
                        <ul>
                            <li class="active"><a href="#"><span>Home Page</span></a></li>
                            <li><a href="LogIn.jsp#con"><span>About Us</span></a></li>
                            <li><a href="LogIn.jsp#con"><span>Contact Us</span></a></li>
                        </ul>
                    </div>
                    <div class="clr"></div>
                    <div class="slider">
                        <div id="coin-slider"> <a href="#"><img src="images/slide1.jpg" width="960" height="320" alt="" /> </a> <a href="#"><img src="images/slide2.jpg" width="960" height="320" alt="" /> </a> <a href="#"><img src="images/slide3.jpg" width="960" height="320" alt="" /> </a> </div>
                        <div class="clr"></div>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="content" style="background-image: url(images/wood_pattern.jpg) ;" >


                <div class="content_resize">

                    <div class="mainbar">
                        <div class="header">
                            <div class="header_resize">

                                <div class="menu_nav" style="margin-right: 700px ;" >
                                    <ul>
                                        <li class="active1"><a href="#"><span>Sign In</span></a></li>
                                        <li><a href="Register.jsp"><span>Sign UP</span></a></li>

                                    </ul>
                                </div>
                                <div class="clr"></div>


                            </div>
                        </div> 



                        <section class="main">

                            <form class="form-4" action="LogIn" method="post">
                                <input type="hidden" value="log" name="type"/> 
                                <p>
                                    <label for="login " style="color: #ffffff">Username or email</label>
                                    <input type="text" name="email" placeholder="Username or email" required />
                                </p>
                                <p>
                                    <label for="password">Password</label>
                                    <input type="password" name='pass' placeholder="Password" required/> 
                                </p>

                                <p>
                                    <input type="submit" name="Sign In" value="Sign In"/>
                                </p>

                            </form>​
                            <%
                                String massage = (String) request.getAttribute("message");
                                if (massage == null) {

                                } else {
                            %>

                            <label  class="button_search"style="color: #840000 ;font-size: 24px"><%= massage%></label>
                            <%
                                }
                            %>


                        </section>

                        <div class="clr"></div>
                    </div>

                </div>
                <div class="sidebar">

                </div>
                <div class="clr"></div>


            </div>
            <div class="clr"></div>
        </div>
        </div>
        <div class="fbg">
            <div class="fbg_resize">
                <div class="col c1">
                    <h2><span>Image</span> Gallery</h2>
                    <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> </div>
                <div class="col c2">
                    <h2><span>About Us</span></h2>
                    <p>Curabitur sed urna id nunc pulvinar semper. Nunc sit amet tortor sit amet lacus sagittis posuere cursus vitae nunc.Etiam venenatis, turpis at eleifend porta, nisl nulla bibendum justo.</p>
                    <ul class="fbg_ul">
                        <li><a href="#">Lorem ipsum dolor labore et dolore.</a></li>
                        <li><a href="#">Excepteur officia deserunt.</a></li>
                        <li><a href="#">Integer tellus ipsum tempor sed.</a></li>
                    </ul>
                </div>
                <div class="col c3" id="con">
                    <h2><span>Contact</span> Us</h2>
                    <p>Nullam quam lorem, tristique non vestibulum nec, consectetur in risus. Aliquam a quam vel leo gravida gravida eu porttitor dui.</p>
                    <p class="contact_info"> <span>Address:</span> 1458 TemplateAccess, USA<br />
                        <span>Telephone:</span> +123-1234-5678<br />
                        <span>FAX:</span> +458-4578<br />
                        <span>Others:</span> +301 - 0125 - 01258<br />
                        <span>E-mail:</span> <a href="#">mail@yoursitename.com</a> </p>
                </div>
                <div class="clr"></div>
            </div>
        </div>
        <div class="footer">
            <div class="footer_resize">
                <p class="lf">&copy; Copyright <a href="#">MyWebSite</a>.</p>
                <p class="rf">Design by Dream <a href="http://www.dreamtemplate.com/">Web Templates</a></p>
                <div style="clear:both;"></div>
            </div>
        </div>

        <div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>