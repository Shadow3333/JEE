<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
	<title>List :: Annuaire</title>
	<link href="<c:url value="/ressources/css/annuaireDetails.css" />" rel="stylesheet">
</head>
<body>
	<div style="display:${logged};">  
		<button class="btn" onclick="location.href='#'"> Home</button>
		<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
		<button class="btn" onclick="location.href='${ edit }'"> edit profile</button>
		<button class="btn" onclick="location.href='${ newGroup }'"> Create group</button>
		<button class="btn" onclick="location.href='${ logout }'"> Logout</button>
		<span class="logged"> you are Logged as <c:out value="${pers.name}"/> </span>
	</div>
	
	<div style="display:${unlogged};">
		<button class="btn" onclick="location.href='#'"> Home</button>
		<button class="btn" onclick="location.href='${ fullList }'"> Full List</button>
		<button class="btn" onclick="location.href='${ login }'"> Login</button>
		<button class="btn" onclick="location.href='${ inscription }'"> Inscription</button>
	</div>
	<br/>
    <span class="myTitleList">people List</span>
   <c:forEach items="${gr_list}" var="gp">
	   <div>
	   	<c:url var="current" value="/goto/Annuaire/personsList?nameGr=${gp.nameGr}" />
	    <a href="${current}">${gp.nameGr} </a>
	    </div>
   </c:forEach>
</body>
</html>