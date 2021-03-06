<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
	<title>List :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<div style="display:${logged};">  
		<button class="btn" onclick="location.href='${ home }'"> Home</button>
		<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
		<button class="btn" onclick="location.href='${ edit }'"> edit profile</button>
		<button class="btn" onclick="location.href='${ newGroup }'"> Create group</button>
		<button class="btn" onclick="location.href='${ logout }'"> Logout</button>
		<span class="logged"> you are Logged as <c:out value="${pers.name}"/> </span>
	</div>
	
	<div style="display:${unlogged};">
		<button class="btn" onclick="location.href='${ login }'"> Login</button>
		<button class="btn" onclick="location.href='${ inscription }'"> Inscription</button>
	</div>
	<br/>
    <span class="myTitleList">people List</span>
    <c:forEach items="${Pers_list}" var="pers">
    	<div>
	    	<c:url var="current" value="/goto/Annuaire/details?idP=${pers.idP}" />
		    <a href="${current}">${pers.name} </a>
	    </div>
    </c:forEach>
</body>
</html>