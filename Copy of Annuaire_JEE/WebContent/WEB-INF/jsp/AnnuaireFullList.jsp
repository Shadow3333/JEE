<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
	<title>List :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<div style="display:${logged};">  
		<button class="btn" onclick="location.href='${ home }'"> Home</button>
		<button class="btn" onclick="location.href='#'"> Full List</button>
		<button class="btn" onclick="location.href='${ edit }'"> edit profile</button>
		<button class="btn" onclick="location.href='${ newGroup }'"> Create group</button>
		<button class="btn" onclick="location.href='${ logout }'"> Logout</button>
		<span class="logged"> you are Logged as <c:out value="${pers.name}"/> </span>
	</div>
	
	<div style="display:${unlogged};">
		<button class="btn" onclick="location.href='${ home }'"> Home</button>
		<button class="btn" onclick="location.href='#'"> Full List</button>
		<button class="btn" onclick="location.href='${ login }'"> Login</button>
		<button class="btn" onclick="location.href='${ inscription }'"> Inscription</button>
	</div>
	<br/>
    <span class="myTitleList">people List</span>
    <c:forEach items="${list}" var="gp">
    	<h1><c:out value="${gp.key}" /></h1>
	    <c:forEach items="${gp.value}" var="pers">
	    	<c:url var="current" value="/goto/Annuaire/details?idP=${pers.idP}" />
	        <a href="${current}">${pers.name} </a>
	        <br/>
	    </c:forEach>
    </c:forEach>
</body>
</html>