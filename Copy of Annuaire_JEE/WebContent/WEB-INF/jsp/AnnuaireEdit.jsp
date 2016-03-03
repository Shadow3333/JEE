<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="home" value="/goto/Annuaire/list" />

<html>
<head>
	<title>Edit :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<button class="btn" onclick="location.href='${ home }'"> Home</button>
    <span class="myTitleList">Personals informations</span>
    <form:form method="POST" commandName="pers">
		<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
		<table>
			<tr>
				<td>Name :</td>
				<td>
				<form:input path="name" />
				</td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>First name :</td>
				<td>
				<form:input path="firstname" />
				</td>
				<td><form:errors path="firstname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Birth day :</td>
				<td>
				<form:input path="birth" />
				</td>
				<td><form:errors path="birth" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mail :</td>
				<td>
				<form:input path="mail" />
				</td>
				<td><form:errors path="mail" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Website :</td>
				<td>
				<form:input path="web" />
				</td>
				<td><form:errors path="web" cssClass="error" /></td>
			</tr>
			<tr>
				<td>password :</td>
				<td><form:input type="password" path="pwd" /></td>
				<td><form:errors path="pwd" cssClass="error" /></td>
			</tr>
			<tr>
				<td>
					<form:select path="Gr">
						<form:option value="${pers.getGr().getNameGr()}"></form:option>
						<c:forEach items="${ gr_list }" var="gr">
							<c:if test="${gr.getNameGr()!= pers.getGr().getNameGr()}">
								<form:option value="${ gr.getNameGr() }">${ gr.getNameGr() }</form:option>						   						
							</c:if>
						</c:forEach>
					</form:select>
				</td>
				<td><form:errors path="Gr" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="tdSubmit" >
					<span class="btn">
						<input class="submit" type="submit" />
					</span>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>