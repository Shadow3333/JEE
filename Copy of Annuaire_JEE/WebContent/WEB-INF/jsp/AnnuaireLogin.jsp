<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="home" value="/goto/Annuaire/list" />
<c:url var="reset" value="/goto/Annuaire/reset" />

<html>
<head>
	<title>Connection :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<button class="btn" onclick="location.href='${ home }'"> Home</button>
    <span class="myTitleList">Connection</span>
    <form:form method="POST" commandName="pers">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Mail :</td>
				<td>
				<form:input path="mail" />
				</td>
				<td><form:errors path="mail" cssClass="error" /></td>
			</tr>
			<tr>
				<td>password :</td>
				<td><form:input path="pwd" type="password"/></td>
				<td><form:errors path="pwd" cssClass="pwd" /></td>
			</tr>
			<tr>
				<td class="tdSubmit" >
					<span class="btn">
						<input class="submit" type="submit" />
					</span>
				</td>
				<td><a href="${ reset }"> Forgotten password? </a></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>