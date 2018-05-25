<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>musteriList</h1>
	
	<c:if test="${empty musteriList }">
		Henüz Kayıt yok
	 </c:if>
	
	<c:if test="${not empty musteriList}">
			
			<form action="searchMusteri">
			
				<label for="musteriAdi">MusteriAdi : </label>
				<input type="text" id="musteriAdi" name="musteriAdi"   />
				<br/>
				<input type="submit" value="Ara" />
				
			</form>
		
		
		<table>
			<thead>
				<th>Ad</th>
				<th>Soyad</th>
				<th>No</th>
				<th>Duzenle</th>
				<th>Sil</th>
					
			 </thead>
			<tbody>
			
			<c:forEach items="${musteriList}" var="musteri" >
			<tr>
				<th><c:out value="${musteri.musteriId}" /></th>
				<th><c:out value="${musteri.musteriAdi }" /></th>
				<th> <c:out value="${musteri.musteriSoyadi }" /> </th>
				<th> <c:out value="${musteri.musteriNo }"  /> </th>
				<th> <a href="editMusteri?musteriId= <c:out value='${musteri.musteriId }' />"> Duzenle </a></th>
				<th> <a href="deleteMusteri?musteriId= <c:out value='${musteri.musteriId }' />">Sil</a></th>
			</tr>
			</c:forEach>
			</tbody>
			
		</table>
	</c:if>
	<!-- 
	${musteri.musteriNo }
	<br>
	${musteri.musteriAdi }
	<br/>
	${musteri.musteriSoyadi }
	
	-->
	<!-- 
	${w}
	<br>
	${w1 }
	<br>
	${w2 }
	
	-->
</body>
</html>