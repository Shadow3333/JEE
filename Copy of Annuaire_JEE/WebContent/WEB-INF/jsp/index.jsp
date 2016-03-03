<%@ include file="/WEB-INF/jsp/include.jsp"%>

<c:url var="inscription" value="/goto/Annuaire/new" />
<c:url var="logout" value="/goto/Annuaire/logout" />
<c:url var="login" value="/goto/Annuaire/login" />
<c:url var="edit" value="/goto/Annuaire/edit" />
<c:url var="newGroup" value="/goto/Annuaire/newgroup" />

<html>
<head>
	<title>Welcome :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<button class="btn" onclick="location.href='${ login }'"> Login</button>
	<button class="btn" onclick="location.href='${ inscription }'"> Inscription</button>
	<h1>WELCOME</h1>
</body>
</html>