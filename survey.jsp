<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


	<div class="survey">
	<span class="center">
		<h4 class="pdpn">National Park Survey</h4>
	</span>
	<form action="newSurveyResponse" method="POST">
		<div class="sfav">
			<label for="parkCode">What's your favorite National Park</label>
			<select name="parkCode">
				<option value="CVNP">Cuyahoga Valley National Park</option>
				<option value=ENP">Everglades National Park</option>
				<option value="GCNP">Grand Canyon National park</option>
				<option value="GNP">Glacier National Park</option>
				<option value="GSMNP">Great Smokey Mountains National Park</option>
				<option value="GTNP">Grand Teton National Park</option>
				<option value="MRNP">Mount Rainier National Park</option>
				<option value="RMNP">Rocky Mountain National Park</option>
				<option value="YNP">Yellowstone National Park</option>
				<option value="YNP2">Yosemite National Park</option>
			</select>
		</div>
		<div class="sea">
			<label for="emailAddress">Email Address</label>
			<input type="email" name="emailAddress"/>
		</div>
		<div class="ss">
			<label for="state">State of Residence</label>
			<input type="text" name="state"/>
		</div>
		<div class="sm">
			<label for="activityLevel">Activity Level</label>
			<select name="activityLevel">
				<option value="inactive">Inactive</option>
				<option value="sedentary">Sedentary</option>
				<option value="active">Active</option>
				<option value="extremelyActive">Extremely Active</option>
			</select>
		</div>
		<button class="ssub" type="submit">Submit!</button>
	</form>
	</div>
			
