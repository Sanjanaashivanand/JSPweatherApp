<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.weather.time.DateAndTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WEATHER APP</title>
<link rel="stylesheet" href="./index.css"/>
<style>
*{
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body{
	max-height:100vh;
	background: linear-gradient(to right, #00d2ff 0%,#3a7bd5); 
}

#dateAndTime{
	display: flex;
	justify-content: center;
	align-items: end;
	margin-top: 100px;
}

#time, #date{
	width: 360px;
	overflow: hidden;
	margin: 5px 0;
	padding:5px 0;
	color: white;
}

#time{
	font-size: 50px;
	
}

#date{
	border-bottom:3px solid  #ff6768;
	font-size: 20px;
}

#day{
	font-size: 30px;
}



main{
	padding:20px;
	margin-top:10px;
	border-radius: 20px;
	background-color: rgba(107, 119, 141, 0.5);
	width: 360px;
	height: 360px;
	display: block;
	margin-left:auto;
	margin-right:auto;
	box-shadow: 10px 10px 20px 10px rgba(112,102,102,0.2)
}

#location{
	font-size: 2rem;
	color: #ffffff;
	text-align: center;
}

#temp{
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
}

#temp #temp-unit{
	font-size: 1.5rem;
	color: #ffffff;
}


#temp #temp-value{
	font-size: 2rem;
	color: #ffffff;
}

#climate{
	font-size: 2rem;
	color: #ffffff;
	text-align: center;
}



#temp-icon{
	margin: 1rem;
	width:40%;
	height: auto;
}
</style>
<meta name="viewport" content="width=device-width, intial-scale=1.0"> 
</head>
<body>

	<div id="dateAndTime">
		<div id="time">
			<%=DateAndTime.getTime() %>
		</div>
		<br>
		<div id="date">
			<%=DateAndTime.getDate() %>
			<div id="day">
				<%=DateAndTime.getDay() %>
			</div>
				
		</div>
	</div>
	
	<main id="app-container">
		<div id="location">
			<p><c:out value='${weatherdata.location}'/></p>
		</div>
		<div id="temp">
			<img id="temp-icon" src="<c:out value='${weatherdata.srcicon}'/>" alt="icon"/>
			<p><span id="temp-value"><c:out value='${weatherdata.temp}'/></span> 
			<span id="temp-unit">&#176c</span></p>
		</div>
		
		<div id="climate">
			<p><c:out value='${weatherdata.description}'/></p>
		</div>
	</main>

	
</body>
</html>