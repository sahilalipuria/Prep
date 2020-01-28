<html ng-app="app">
	<head>
		<title>Show Actors</title>
		<link href="include/styles.css" rel="stylesheet">
		<!-- Use Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>		
		
		<script type="text/javascript" src="include/app.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body ng-controller="HttpCtrl as app">
  	<div class="container">
		<div class="header">
			<h1 class="custom">Actor Management Interface</h1>
		</div>

		<div class="leftPanel">
			<div class="LeftPanelHeader">{{navTitle}}</div>
			<table class="side">
			  <tr ng-repeat="a in actors" ng-click="getActor(a.id)" >
			    <td class="side">{{a.name}}</td>
			  </tr>
			</table>
		</div>

		<div class="RightPanel">
			<image src="{{actor.image}}" width="220">
		</div>
		
		<div class="MainBody">
		    <form>
		    	<table>
					<tr>
						<td><input type="text" ng-model="searchName" size="30"></td>
						<td><button type="button" ng-click="searchActor(searchName)" class="btn btn-primary btn-sm">
      					<span class="glyphicon glyphicon-search"></span> Search </button></td>
						<td><button ng-click="addNew()" class="btn btn-primary btn-sm">
						<span class="glyphicon glyphicon-plus"></span> Add New </button></td>
						<td><button ng-click="resetSearch()"  class="btn btn-info btn-sm">
						<span class="glyphicon glyphicon-refresh"></span> Reset Search </button></td>
					</tr>
				</table>
		    </form>
		    
			<form id="main">
				<table>
					<tr>
						<td class="display_bold"><label for="actor.name">ID:</label></td>
					</tr>
					<tr>
						<td class="display"><input id="id" type="text" ng-model="actor.id" size="4"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Name:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="actor.name" size="30"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Birth Name:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="actor.birthName" size="40"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Birth Date:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="actor.birthDate" size="20"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Email:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="actor.email" size="30"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Image:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="actor.image" size="80"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">IsActive:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="actor.active" size="10"></td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
						  <table>						  	
						  	<tr>
						  	  <td><button ng-click="saveActor(actor.id)" class="btn btn-success btn-sm" title="Save actor's details..." ng-disabled="isSaveDisabled">
						  	  <span class="glyphicon glyphicon-plus"></span> Save </button></td>
							  <td><button ng-click="deleteActor(actor.id)" class="btn btn-danger btn-sm" ng-disabled="isDeleteDisabled">
							  <span class="glyphicon glyphicon-trash"></span> Delete </button></td>  	  
						  	</tr>
						  </table>
						</td>
					</tr>
					
				</table>
			</form>
		</div>

		<div class="footer">AngularJS Demo   - Copyright © avaldes.com</div>
	</div>
	</body>
</html>