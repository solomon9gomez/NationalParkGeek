<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />



<header class="pdpn">${park.parkName}</header>
<div class="pdimg">
	<c:url value="/img/parks/${park.parkCode}.jpg" var="parkImage"/> 
		<img src="${parkImage}"/>
</div>
<div class="pdh3">
	<h3> ${park.inspirationalQuote}</h3>
	<p class="iqauthor">-${park.inspirationalQuoteSource}</p>

</div>
<div class="pdlist1">
	<ul>
	<li> State: ${park.state}</li>
	<li>Acreage:  ${park.acreage}</li>
	<li>Elevation: ${park.elevationInFeet}ft.</li>
	<li> Miles of Trail: ${park.milesOfTrail}</li>
	<li> Campsites: ${park.numberOfCampsites}</li>
	</ul>
</div>

<div class="pdlist2">
	<ul>
	<li>Climate: ${park.climate}</li>
	<li>Number of Animal Species: ${park.numberOfAnimalSpecies}</li>
	<li>Established: ${park.yearFounded}</li>
	<li>Annual Visitors: ${park.annualVisitorCount}</li>
	</ul>
</div>
<div class="pdpd">${park.parkDescription}</div>
<div class="pdef">Entry Fee: $${park.entryFee}</div>
<div>
<c:url value="/weather?parkCode=${park.parkCode}&tempCOrF=${cOrF}" var="weatherURL"/>
	        <a href="${weatherURL}"><button type="text" class="navButton3">Weather Forecast</button> </a>
</div>