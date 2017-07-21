<!DOCTYPE html>
<html>

<head>
<style type="text/css">
input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #c4ed74 ;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #cef77e;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    width: 450px;
}

</style>
</head>

<body>

<form action="${pageContext.request.contextPath}/Deals" method="post">

<div>
  Destination:<br>
  <input type="text" name="destinationName">
  <br>
  The earliest date to start the trip (e.g: 2017-05-03):<br>
  <input type="text" name="minTripStartDate" >
  The latest date to start the trip (e.g: 2017-05-03):<br>
  <input type="text" name="maxTripStartDate" >
  <br>
  Star Rating:<br>
  <input type="text" style="width:48%" name="minStarRating" >
   - 
  <input type="text" style="width:48%" name="maxStarRating" >
  <br>
  Total Rate:<br>
  <input type="text" style="width:48%" name="minTotalRate" >
   - 
  <input type="text" style="width:48%" name="maxTotalRate" >
  <br>
  Guest Rating:<br>
  <input type="text" style="width:48%" name="minGuestRating" > 
   - 
  <input type="text" style="width:48%" name="maxGuestRating" >
  
  <br><br>
  <input type="submit" value="Find Deals!">
  </div>
</form> 

</body>
</html>
