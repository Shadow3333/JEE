<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Liste_pers :: Spring Application</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<div>
		<button class="btn" onclick="location.href='${ home }'"> Home</button>
		<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
		<button class="btn" onclick="location.href='${ edit }'"> edit profile</button>
		<button class="btn" onclick="location.href='#'"> Create group</button>
		<button class="btn" onclick="location.href='${ logout }'"> Logout</button>
		<span class="logged"> you are Logged as <c:out value="${pers.name}"/> </span>
	</div>
	<br/>
    <span class="myTitleList">New Group</span>
    <form action="newgroup" method="POST">
    	<table>
			<tr>
				<td>Name :</td>
				<td>
				<input type="text" name="nameGr" />
				</td>
			</tr>
			<tr>
				<td>Years (example: 2000/2001) :</td>
				<td>
				<input type="text" name="years" />
				</td>
			</tr>
			<tr>
				<td class="tdSubmit" >
					<span class="btn">
						<input class="submit" type="submit" />
					</span>
				</td>
			</tr>
		</table>
    </form>
</body>
</html>