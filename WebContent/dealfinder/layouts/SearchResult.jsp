<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page import="com.hotelfinder.Deals"%>
<%@ page import="javax.json.JsonObject"%>
<%@ page import="javax.json.JsonArray"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>

body {
    display: inline-block;
    margin: 0px auto;
    text-align: center;
    background: #f5ffe2;
}

table{
text-align: center;
}

.hotelinfo{
	border-radius: 25px;
 	background: #d9f79e;
 	width: 800px;
    height: 120px;
    cursor: pointer !important; 
}

h3 {
	font-size: 2em;
}


.dealInfo {
	background: #f1fcbf;
	margin-top: 5px;
	display: none
}
</style>

<script>
	$(function() {
		$(".hotel").click(function() {
			$(this).next(".dealInfo").slideToggle("slow");
		});
	});
</script>
</head>
<body>

	<h3>Best Hotel Deals!</h3>

	<%
		Deals deals = (Deals) session.getAttribute("deals");
		JsonObject offerInfo = deals.getOfferInfo();

		String language = offerInfo.getString("language");

		if (language.equals("en_US") || language.equals("en_UK")) {
			language = "English";
		} else if (language.equals("fr_FR")) {
			language = "French";
		}
	%>
	<table width=800px>
		<tr>
			<td>
				<%
					out.println("Language: " + language);
				%>
			</td>
			<td>
				<%
					out.println("Prices in " + offerInfo.getString("currency"));
				%>
			</td>
		</tr>
	</table>

	<%
		JsonObject offers = deals.getOffers();
		JsonArray hotels = offers.getJsonArray("Hotel");

		for (int i = 0; i < hotels.size(); i++) {
			JsonObject hotel = hotels.getJsonObject(i);
			JsonObject hotelInfo = hotel.getJsonObject("hotelInfo");
			String hotelName = hotelInfo.getString("hotelName");
	%>
	<br/>
	
	<div class="hotelinfo">
	
		<div class="hotel" id="<%out.print(hotelName);%>">
		<h2><%out.print(hotelName);%></h2>
		<table width=800px>
				<tr>
					<td width=230px>
						
					</td>
					<td width=340px>
						<%out.println(hotel.getJsonObject("hotelPricingInfo").getJsonNumber("totalPriceValue").doubleValue());%>
						<%out.println(" ");%>
						<%out.println(offerInfo.getString("currency"));%>
						<%out.println(" for ");%>
						<%out.println(hotel.getJsonObject("offerDateRange").getInt("lengthOfStay"));%>
						<%out.println(" nights");%>
					</td>
					<td width=230px>
						
					</td>
					
				</tr>
				<tr>
					<td width=230px>
						<%out.println(hotelInfo.getString("hotelStarRating")+ " ");%>
						 <img src="http://pngimg.com/uploads/star/star_PNG1594.png" height="18" width="18"> 
					</td>
					<td width=340px>
						<%out.println("Region: " + hotelInfo.getString("hotelLongDestination"));%>
					</td>
					<td width=230px>
						<%out.print("From: " + hotelInfo.getString("travelStartDate"));%> 
						<%out.print(" to: " + hotelInfo.getString("travelEndDate"));%>
					</td>
					
				</tr>
			</table>
		</div>
		<div class="dealInfo" id="div_<%out.print(hotelName);%>">

			<table width=800px style="text-align:left">
				<tr>
					<td width="150px" style="padding: 10px;">
						<%out.println("Description: ");%>
					</td>
					<td width="650px" style="word-wrap:break-word;">
						<%out.print(hotelInfo.getString("description"));%> 
					</td>
					
				</tr>
				<tr>
					<td width="150px" style="padding: 10px;">
						<%out.println("For more information: ");%>
					</td>
					<td width="650px" style="word-wrap:break-word">
					<a href="<%out.print(hotel.getJsonObject("hotelUrls").getString("hotelInfositeUrl"));%>">Visit Hotel Page</a>
						 
					</td>
					
				</tr>
			</table>
		</div>
		<%}%>

	</div>
</body>
</html>