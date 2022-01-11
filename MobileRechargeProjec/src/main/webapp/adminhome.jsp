<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ModifyOperator</title>
<style>

body{
background: linear-gradient(to right, #3f56fb, #fc466b);
}
.header a {
    padding: 12px 28px;
    text-decoration: none;
    font-weight: bold;
    color: white;
}

.header {
    background: linear-gradient(to right, #3f56fb, #fc466b);
    padding: 0px;
    display: flex;
    justify-content: flex-end;
   
}
.singleCard a {
    margin: -7px 15px;
    text-decoration: none;
}
.singleCard img {
    width: 15%;
}
.singleCard {
    width: 33%;
    display: flex;
    background: white;
    justify-content: space-between;
    padding: 10px;
    align-items: center;
    box-shadow: 0px 0px 6px 0px #d7d7d7;
    margin-top: 13px;
    border-radius: 4px;
}
.header a:hover {
    background: white;
    color: black;
}
li {
    list-style: none;
}
li.dropdown ul {
    display: none;
}
li.dropdown:hover .dropdownlist {
    display: block;
    position: absolute;
    top: 24px;
    right: 13px;
}
ul.dropdownlist li {
    display: block;
    background: aliceblue;
    padding: 10px 19px;
}
.header ul li {
    display: inline-block;
    position: relative;
}
</style>

</head>
<body>
<!-- <div class="header">
<ul>
	<li class="dropdown">
	  <a href="adminhome.jsp">Admin</a>
	  <ul class="dropdownlist">
	  
	  </ul>
	 </li>
	 <li class="dropdown">
	  <a href="addjio.jsp">ADD JIO </a>
	  <ul class="dropdownlist">
	  	<li><a href="addairtel.jsp">ADD</a></li>
	  	<li><a href="addVodafone.jsp">ADD</a></li>
	  	<li><a href="addbsnl.jsp">ADD</a></li>
	  </ul>
	 </li>
    <a href="index.jsp">LOGOUT</a>  
    </li>
</ul>
</div> -->
<div class="header">
<a href="adminhome.jsp">Admin</a>
<a href="addjio.jsp">ADD JIO </a>
<a href="addairtel.jsp">ADD</a>
<a href="addVodafone.jsp">ADD</a>
<a href="addbsnl.jsp">ADD</a>
<a href="index.jsp">LOGOUT</a>
</div>
	<div align="center">
		<!-- <h1>SELECT OPERATOR</h1> -->

		<div class="singleCard">
			<a href="jio.jsp">JIO</a> <img src="images/jiologo.jpg">
		</div>
		<div class="singleCard">
			<a href="airtel.jsp">AIRTEL</a> <img src="images/airtel logo.png">
		</div>
		<div class="singleCard">
			<a href="vodafone.jsp">VODAFONE</a> <img src="images/VI-Logo-PNG.jpg">
		</div>
		<div class="singleCard">
			<a href="bsnl.jsp">BSNL</a> <img src="images/BSNL logo.png">
		</div>
	</div>
</body>
</html>