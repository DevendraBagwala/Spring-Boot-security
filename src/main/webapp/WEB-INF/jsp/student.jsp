<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>

<script src="static/js/bootstrap.min.js"></script>
<link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="student"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Student Add</legend>
								
							

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" placeholder=""
											class="form-control input-md">

									</div>
								

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="surname">Surname</label>
									<div class="col-md-4">
										<input id="surname" name="surname" type="text" placeholder=""
											class="form-control input-md">

									</div>
								
								
								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="address">Address</label>
									<div class="col-md-4">
										<input id="address" name="address" type="text" placeholder=""
											class="form-control input-md">

									</div>
						

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info"
											value="Add Student">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
					<legend>Student List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">							
							<thead>
								<tr>
									<th>Name</th>
									<th>Surname</th>
									<th>Address</th>
									<th>Action</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${student}" var="student">
									<tr>	
										<td><c:out value="${student.name}" /></td>
										<td><c:out value="${student.surname}" /></td>	
										<td><c:out value="${student.address}" /></td>							
										<td><a href="student/remove?id=${student.id}"
											class="btn btn-danger" type="button">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>