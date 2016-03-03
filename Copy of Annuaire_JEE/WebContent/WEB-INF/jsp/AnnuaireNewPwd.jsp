<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>New password :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<button class="btn" onclick="location.href='${ home }'"> Home</button>
	<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
    <span class="myTitleList">New Password</span>
    <span class="myTitleList"><c:out value="${pers.getMail()}" /></span>
    <form action="newPassword?mail=${ pers.getMail() }" method="POST">
    	<table>
			<tr>
				<td>Password :</td>
				<td>
				<input type="password" name="pwd" />
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