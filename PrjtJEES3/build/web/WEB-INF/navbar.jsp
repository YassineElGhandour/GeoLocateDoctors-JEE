

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<!--<link rel="stylesheet" href="css/smallbody.css" />-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
       
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">DocLoc</a>
                </div>
                
                <ul class="nav navbar-nav">
                    <li><a href="home">Acceuil</a></li>
                    <li><a href="simpleresearch">Recherche par carte</a></li>
                    <li><a href="detailedresearch">Recherche avancée</a></li>
                    <c:if test="${sessionScope.currentSessionUser != null}" > 
                        <li><a href="ajouterMarker">Ajouter une recherche</a></li>
                    </c:if>
                </ul>
                <form class="navbar-form navbar-left" action="#">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${sessionScope.currentSessionUser == null}" > 
                    <li><a href="home#sinscrire"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
                    <li><a href="home#login"><span class="glyphicon glyphicon-log-in"></span> S'authentifier</a></li>
                    </c:if>
                    <c:if test="${sessionScope.currentSessionUser != null}" > 
                    <li><a href="home"><span class="glyphicon glyphicon-user"></span> Déconnecter</a></li>
                    
                    

                    </c:if>
                </ul>
            </div>
        </nav>
     
    </body>
        
</html>
