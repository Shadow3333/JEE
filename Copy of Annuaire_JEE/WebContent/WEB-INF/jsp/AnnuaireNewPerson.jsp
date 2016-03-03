<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
	<title>New Person :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<div>
		<button class="btn" onclick="location.href='${ home }'"> Home</button>
		<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
		<button class="btn" onclick="location.href='#'"> Login</button>
		<button class="btn" onclick="location.href='${ inscription }'"> Inscription</button>
	</div>
	<br/>
    <span class="myTitleList">Inscription</span>
    <form:form method="POST" commandName="pers">
		<form:errors path="*" cssClass="errorblock" element="div" />
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
				<td>Group :</td>
				<td>
					<form:select path="Gr">
						<c:forEach items="${ gr_list }" var="gr">
							<form:option value="${ gr.getNameGr() }">${ gr.getNameGr() }</form:option>						   
						</c:forEach>
					</form:select>
				</td>
				<td><form:errors path="Gr" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td class="tdSubmit" ><span class="btn"><input class="submit" type="submit" /></span></td>
			</tr>
		</table>
	</form:form>
</body>
</html>