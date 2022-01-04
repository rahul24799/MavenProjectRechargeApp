<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>
<style>
 label{
width:120px;
display:inline-block;
}

</style>
</head>
<body>
<form action="UserController" style="text-align: center" method="get" >
<div style="text-align:center">
    <h1 style="color: rgb(102, 153, 7); font-style: italic;">Register Login </h1>
    
   <div>
    <label for="Username"><strong>UserName:</strong></label>
    <input type="text" name="username" id="Username" ><br><br> 
  </div>
  <div>
    <label for="Email"><strong>Email-id:</strong></label>
    <input type="email" name="email" id="Email" autofocus required placeholder="abcd22@gmail.com" pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br><br>
</div>
<div>
     <label for="Mobilenumber"><strong>MobileNumber:</strong></label>
     <input type="number" name="phonenumber" id="Mobilenumber"  required><br><br>
</div>
<div>
     <label for="PASSWORD"><strong>Password:</strong></label>
     <input type="password" name="password" id="Password" required><br><br>
 </div> 
 <div>
     <label for="Operatorname"><strong>OperatorName</strong></label>
     <input type=""text" name="operatorName" id="Operatorname"  required><br><br>
  </div> 
  <div> 
      <label for="wallet"><strong>Wallet</strong></label>
      <input type="number" name="wallet" id="wallet"  required><br><br>
   </div>  
      <input type="submit" value="SignIn"> 
               
</div>
    
   
    
</form>  
       
</body>
</html>