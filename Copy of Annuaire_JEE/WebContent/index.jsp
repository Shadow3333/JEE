<%@ include file="/WEB-INF/jsp/include.jsp"%>

<c:url var="inscription" value="/goto/Annuaire/new" />
<c:url var="login" value="/goto/Annuaire/login" />

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