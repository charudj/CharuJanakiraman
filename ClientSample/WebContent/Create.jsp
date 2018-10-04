<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Offer</title>
</head>
<body>
<form action="http://localhost:8080/OfferManagement/offer/OfferService/offers" method="post">
	
		<p>	
			Enter Offer Id : <input type ="number" name = "id"/>
		</p>
		<p>
			Enter Offer Name : <input type= "text" name= "name"/>
		</p>
				<p>
			Enter Offer Price(GBP) : <input type= "text" name= "price"/>
		</p>
		<p>	
			Enter Expiry Date : <input type ="date" name = "expirydate"/>
		</p>
		
		<input type="submit" value="Create"/>
		
</form>		
</body>
</html>