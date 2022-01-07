
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
<style>

body{
    margin: 0%;
    padding: 0%;
    font-family: sans-serif;
    background: linear-gradient(120deg,#2980b9,#8eaaad);
    height: 100vh;
    overflow: hidden;
  }
 .center{
position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%,-50%);
width: 400px;
background: white;
border-radius: 10px;
 }
 
.center h1{
    text-align: center;
    padding: 0 0 20px 0 ;
    border-bottom: 1px solid silver;
}
.center form{
    padding:0 40px;
   box-sizing: border-box;
}
form.txt-field{
position: relative;
border-bottom: 2px solid #adadad;
margin: 30px 0;
}
.txt-field input{
    width: 100%;
    padding: 0 5px;
    height: 40px;
    font-size: 16px;
    border:windowframe;
    background: none;
    outline:auto;

}
.txt_field label{
    position: absolute;
    top: 50px;
    left: 5px;
    color: #adadad;
    transform: translate(-50%);
    font-size: 16px;
    pointer-events: none;
    transition: .5s;
}
.txt-field span::before{
    content: '';
    position: absolute;
    top: 40px;
    left: 0;
    width: 100%;
    height: 2px;
    
}
.txt-field input:focus ~label,
.txt-field input:valid ~label{
    top: -5px;
    color: #2691d9;
}
.txt-field input:focus ~span::before,
.txt-field input:valid ~span::before{
    width: 100%;
}
input[type="submit"]{
    width: 100%;
    height: 50%;
    border: 1px solid;
    background: #2691d9;
    border-radius: 25px;
    font-size: 18px;
    color: #e9f4fb;
    font-weight: 700;
    cursor: pointer;
    outline: none;
}
input[type="submit"]:hover{
    border-color: #2691d9;
    transition: .5s;
}
.signup_link{
    margin: 30px 0;
    text-align: center;
    font-size: 16px;
    color: #666666;
}
.signup_link a{
color: #2691d9;
text-decoration: none;
}
.signup_link a:hover{
    text-decoration: underline;
}

</style>

</head>
<body>
    <div class="center">
    <h1 style=" font-style: italic;" > Login </h1>
<Form action="AdminController" method="get">
<div class="txt-field">
  
  
<label for="Email">Email-id</label>
<span></span>
<input type="email" name="email" id="Email" autofocus required  pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br>
</div>
<div class="txt-field" >
    <label for="PASSWORD">Password</label>
    <span></span>
<input type="password" name="password" id="PASSWORD" required><br>
</div>
<input type="submit" value="login">
<div class="signup_link">
<a href="register.jsp">SignUp?</a>



 </Form>
</div>
</body>
</html>