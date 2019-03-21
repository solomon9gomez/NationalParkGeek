<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1 class="pdpn">${park.parkName} Forecast</h1>
<div>
	
	
			<a class="fah" href="/m3-java-capstone/weather?parkCode=${park.parkCode}&tempCOrF=false"> Fahrenheit</a>
			<a class="cel" href="/m3-java-capstone/weather?parkCode=${park.parkCode}&tempCOrF=true">Celsius</a>
	
	</div>
<div class="wt">
	<c:forEach var="weather" items="${weather}">
		<div class="wdiv">
			<c:url value="/img/weather/${weather.forecast}.png" var="forecastImage"/> 
			<img class="wimg" src="${forecastImage}"/>
			<p>Expect: ${weather.forecast}</p>	
			<p>High: ${weather.high}		Low: ${weather.low}</p>
			<p>${weather.advice}	${weather.tempAdvice}</p>
		</div>
	</c:forEach>
</div>