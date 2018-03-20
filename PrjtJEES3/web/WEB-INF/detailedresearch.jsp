<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<!--<link rel="stylesheet" href="css/smallbody.css" />-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
        <title>DocLoc | Recherche avancée</title>
    </head>

    <body>

    <%@ include file='navbar.jsp'%>
        
    <div class="container" align="center">
        <h2>Recherche Avancée</h2>
    </div>

    <br/>
    
    <div class="container">
        <table class="table table-bordered table-hover table-responsive">
            <thead>
                <tr>
                    <th></th>
                    <th>Nom Complet</th>
                    <th>Université ou Institution</th>
                    <th>Terrain de recherche</th>
                    <th>Laboratoire de recherche</th>
                    <th>Pays de recherche</th>
                    <th>Sujet de recherche</th>
                    <th>Thème</th>
                    <th>Mot-clés</th>
                    <th>Description de recherche</th>
                </tr>
            </thead>
            

            <c:forEach items="${recherches}" var="recherche">

            <tr>
                <th scope="row"></th>
                
                <td><c:out value="${recherche.nomUser}"/> <c:out value="${recherche.prenomUser}"/></td>
                <td><c:out value="${recherche.uniRech}"/> </td>
                <td><c:out value="${recherche.terrainRech}"/> </td>
                <td><c:out value="${recherche.laboRech}"/></td>
                <td><c:out value="${recherche.paysRech}"/></td>
                <td><c:out value="${recherche.nomRech}"/></td>
                <td>Not Done yet</td>
                <td><c:out value="${recherche.motsCleRech}"/></td>
                <td><c:out value="${recherche.descRech}"/></td>
               
            </tr>


            </c:forEach>
        </table>
    </div>
</html>