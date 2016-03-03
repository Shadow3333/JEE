<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Reset :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<div>
	<button class="btn" onclick="location.href='${ home }'"> Home</button>
	<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
	</div>
	<br/>
    <span class="myTitleList">Password recovery</span>
    <form action="reset" method="POST">
    	<table>
			<tr>
				<td>Mail :</td>
				<td>
				<input type="text" name="mail" />
				</td>
			</tr>
			<tr>
				<td class="tdSubmit" ><span class="btn"><input class="submit" type="submit" /></span></td>
			</tr>
		</table>
    </form>
    
</body>
</html>