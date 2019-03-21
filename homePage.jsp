<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="tabody">

		<table>
			<c:forEach var="park" items="${parks}">
				<tr>
					<td id="pimg">
						<c:url value="/img/parks/${park.parkCode}.jpg" var="parkImage"/> 
						<img class="hpimg" src="${parkImage}"/>
					</td>
					<td class="pn"><c:url value="/parkDetail?parkCode=${park.parkCode}" var="parkDetail"/>
						<a href="${parkDetail}">
						<c:url value=""/>${park.parkName}</a> <p>${park.parkDescription}</p></td>	
				</tr>	
			</c:forEach>
		</table>
	</div>
	
</body>   <%--add to footer --%>