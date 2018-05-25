<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>

<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" 
integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

<h1>Müþteri Formu</h1>
			
	
		<form:form  method="POST" modelAttribute="musteri" action="saveMusteri">
		<form:hidden  path="musteriId" value="${musteriObject.musteriId }" />
		    <form:label for="musteriNo"  path="musteriNo" >Müþteri No</form:label>
		    <form:input type="text" name="musteriNo" path="musteriNo" value="${musteriObject.musteriNo }" /> 
		 
		    <form:label for="musteriAdi" path="musteriAdi">Müþteri Adý</form:label>
		    <form:input type="text" name="musteriAdi" path="musteriAdi" value="${musteriObject.musteriAdi }"/> 
		
		    <form:label for="musteriSoyadi" path="musteriSoyadi">Müþteri Soyadi</form:label>
		    <form:input type="text" name="musteriSoyadi" path="musteriSoyadi"  value="${musteriObject.musteriSoyadi }" /> 
		 	  
		  <form:button type="submit" id="saveMusteri" class="btn btn-success" value="Kaydet">Kaydet</form:button>
					
		</form:form>
	
			
</body>
</html>