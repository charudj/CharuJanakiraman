<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Offer</title>
</head>
<body>
<form action="http://localhost:8080/OfferManagement/offer/OfferService/offers" method="delete">
	<p>
				
			User Id : <input type ="number" name = "id"/>
			
		</p>
		<input type="submit" value="Submit"/>
		</form>
</body>
</html>