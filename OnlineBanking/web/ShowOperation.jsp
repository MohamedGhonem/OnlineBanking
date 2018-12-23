<%-- 
    Document   : MassageForEmployee
    Created on : Dec 18, 2018, 5:04:52 AM
    Author     : gohnem
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Client"%>
<%@page import="Entity.Employee"%>
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
                            <li class="active"><a href="Home.jsp"><span>Home Page</span></a></li>
                            <li><a href="Home.jsp#con"><span>About</span></a></li>
                            <li><a href="Home.jsp#con"><span>About Us</span></a></li>
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
            <div class="content"style="background-image: url(images/wood_pattern.jpg)">
                <div class="content_resize">
                    <div class="mainbar">
                        <div class="article" >

                            <h2><span>Register client</span></h2>
                        </div>
                        <div class="clr"></div>

                        <%
                            String message = (String) request.getAttribute("message");
                            Client client = (Client) session.getAttribute("client");
                            ArrayList<Entity.Process> ps = (ArrayList<Entity.Process>) session.getAttribute("processs");
                            System.out.print(" ");
                            if (client == null) {


                        %>
                        <section class="main">
                            <form class="form-4" action="GetData" method="post">
                                <input type="hidden" value="getC" name="type"/> 
                                <p> <input type="text" name="email" placeholder="Username or email" required /> </p>
                                <p><input type="text" name='nationalId' placeholder="National ID" required/></p>
                                <p><input type="submit" name="Sign In" value="Sign In"/></p>
                            </form>​
                        </section>
                        <%                            System.out.print(" ");
                            if (message != null) {
                                System.out.print(" ");
                        %>

                        <label  class="button_search"style="color: #840000 ;font-size: 24px"><%= message%></label>
                        <%
                            }
                        } else {

                            System.out.print(" ");
                        %>




                        <div id="me"> </div>
                        <section class="main">
                            <div class="table"  action="GetData" method="post">

                                <input type="hidden" value="show" name="type"/> 
                                <input  type="text" style="width: 80%"value="Client name : <%= client.getClientName()%> " name="email"readonly/>
                                <input  type="text"style="width: 80%"  value="National Id : <%= client.getClientNationalId()%> " name="email"readonly/>
                                <input  type="text"style="width: 40%"  value="Client Balance " name="email"readonly/>
                                <input  type="text"style="width: 40%"  value="<%= client.getBalance()%> " name="email"readonly/>
                                <table border="0">
                                    <thead>
                                        <tr>
                                            <th><input  type="text" value="Operation " name="email"readonly/></th>
                                            <th><input  type="text"  value="Data " name="email" readonly /></th>
                                            <th><input  type="text"  value="Employee  " name="email" readonly /></th>
                                            <th><input  type="text"  value="Amount  " name="email" readonly /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%

                                            System.out.print(" ");
                                            for (int i = 0; i < ps.size(); i++) {
                                        %>
                                        <tr>
                                            <td><input type="text" value="<%=ps.get(i).getProType()%> " name="email"readonly/></td>
                                            <td><input  type="text"  value="<%=ps.get(i).getProDate()%> " name="email" readonly /></td>
                                            <td><input  type="text"  value="<%=ps.get(i).getEmployee().getEmployeeName()%>"readonly </td>
                                            <td> <input  type="text"  value="<%=ps.get(i).getAmount()%>" name="email" readonly /></td>
                                        </tr>

                                        <%
                                                System.out.print(" ");
                                            }

                                            System.out.print(" ");
                                        %>
                                    </tbody>
                                </table>

                            </div>>​
                        </section>
                        <% }%>
                        <div class="clr"></div>
                        <div class="clr"></div>
                    </div>

                </div>
                <div class="sidebar">

                    <div class="clr"></div>
                    <div class="gadget">
                        <h2 class="star"><span>Sidebar</span> Menu</h2>
                        <div class="clr"></div>
                        <ul class="sb_menu">
                            <li><a href="ClientHome.jsp">Home</a></li>
                            <li><a href="AddClient.jsp">Add Client </a></li>
                            <li><a href="Operation.jsp">Operation of client</a></li>
                            <li><a href="ShowOperation.jsp">Show Operation of client</a></li>
                            <li><a href="LogOut.jsp">Log out </a></li>
                        </ul>
                    </div>

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
                    <h2><span>Services</span> Overview</h2>
                    <p>Curabitur sed urna id nunc pulvinar semper. Nunc sit amet tortor sit amet lacus sagittis posuere cursus vitae nunc.Etiam venenatis, turpis at eleifend porta, nisl nulla bibendum justo.</p>
                    <ul class="fbg_ul">
                        <li><a href="#">Lorem ipsum dolor labore et dolore.</a></li>
                        <li><a href="#">Excepteur officia deserunt.</a></li>
                        <li><a href="#">Integer tellus ipsum tempor sed.</a></li>
                    </ul>
                </div>
                <div class="col c3">
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
        </div>
        <div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>
