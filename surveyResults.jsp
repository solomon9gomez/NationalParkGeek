<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1 class="pdpn">Survey Results</h1>

 <body>
 	<div class="srt">
		<table>
			<c:forEach var="survey" items="${surveys}">
				<tr>
					<td>
						<c:url value="/img/parks/${survey.parkCode}.jpg" var="parkImage"/> 
						<img class="srimg" src="${parkImage}"/>
					</td>
					<td class="srpn">${survey.parkName}</td>
					<td class="srv">Total number of VOTES: ${ survey.count}</td>
				</tr>		
			</c:forEach>
		
		
		<%--<c:forEach var="survey" items="${allSurveys}"  varStatus="loopStatus">
	  		<tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
			<tr>
				<td>
					<c:url value="/img/parks/${survey.parkcode}" var="parkImage"/> 
					<img src="${parkImage }"/>
					
				</td>
				
				<td>${survey.parkCode}</td>
			
				<td>${survey.state }</td>
			</tr>
		</c:forEach>  --%>
		</table>
	</div>

</body>