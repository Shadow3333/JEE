<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
	<title>Details :: Annuaire</title>
</head>
<body>
	<div>
		<button class="btn" onclick="location.href='${ home }'"> Home</button>
		<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
	    <span class="myTitle" style="align:center"><c:out value="${pers.name}" /> details</span>
    </div>
    <br/><br/>
    <p>First name : <c:out value="${pers.getFirstname()}" /></p>
	<p>Web : <c:out value="${pers.getWeb()}" /></p>
	<div style="display:${ logged }">
		<p>Birth : <c:out value="${pers.getBirth()}" /></p>
		<p>Mail : <c:out value="${pers.getMail()}" /></p>
		<p>Group : <c:out value="${pers.getGr().getNameGr()}" /></p>
	</div>
	
</body>
</html>