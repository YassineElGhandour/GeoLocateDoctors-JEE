<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="css/smallbody.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>DocLoc | <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></title>
    </head>

    <body>

    <%@ include file='navbar.jsp'%>
    <div class="container-fluid">
        <div class="row">
            <div class="fb-profile">
                <img align="left" class="fb-image-lg" src="images/pic.jpg" alt="Profile image example"/>
                <img align="left" class="fb-image-profile thumbnail" src="images/img.jpg" alt="Profile image example"/>
                <div class="fb-profile-text">
                    <h1> 
                        <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/>
                    </h1>
                </div>
            </div>
        </div>
    </div> 
    
    <!-- /container fluid-->  
    <div class="container">
        <div class="col-sm-8">
            <div data-spy="scroll" class="tabbable-panel">
                <div class="tabbable-line">
                    <ul class="nav nav-tabs ">
                        <li class="active">
                            <a href="#tab_default_1" data-toggle="tab">À propos </a>
                        </li>
                        <li>
                            <a href="#tab_default_2" data-toggle="tab">Education et carrière</a>
                        </li>
                        <li>
                            <a href="#tab_default_3" data-toggle="tab">Recherches</a>
                        </li>
                        <li>
                    </ul>
                    
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab_default_1">
                          <c:if test="${(user.desc !=null)}">
                            <c:out value="${user.desc}"/> 
                          </c:if>
                        </div>
                        
                        <div class="tab-pane" id="tab_default_2">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="text">Doctorat:</label>
                                            <p> <c:out value="${user.nivUser}"/> </p>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="text">Place of Birth:</label>
                                    <c:out value="${user.dateN}"/>
                                    </div>        
                                </div>
                            </div>           
                        </div>
                        <div class="tab-pane" id="tab_default_3">
                            <p>Recherches</p>
                            <% //for(int i=0;i<s.getListe().length;i++) { %>
                            <div id="container">
                                <% //out.println("<b>"+s.getListe()[i][0]+"</b>"); %> 
                                <div id="container">
                                <% //out.println(s.getListe()[i][1]); %> 
                                </div>
                            </div>
                            <% //} %> 
                    </div>
                </div>
            </div>
        </div>
        </div> 
        <div class="col-sm-4">
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                        
                        <div class="form-group">
                            <label for="date">Date de naissance:</label>
                            <c:out value="${user.dateN}"/>
                        </div>

                        <div class="form-group">
                            <label for="text">Pays d'origine:</label>
                            <p> <c:out value="${user.pays}" /> </p>
                        </div>
                        
                        <div class="form-group">
                            <label for="text">Position actuelle:</label>
                            <p> <c:out value="${user.postAct}" /></p>
                        </div>
                        
                        <div class="form-group">
                            <label for="email">Niveau universitaire:</label>
                            <p> <c:out value="${user.nivUser}" /></p>
                        </div>
                        
                        <div class="form-group">
                            <label for="email">Recherche récente</label>
                               <% //out.println("<p>"+s.getListe()[s.getListe().length-1][0]+"</p>"); %> 
                        </div>

                        <button type="submit" class="btn btn-danger btn-block">Modifier mes infos</button>
                    </div>
                </div>
            </div>
        </div>
    </div> 
                        <form>
                            <script>
                                //var idd = <%//= s.getId()%>;
                                //var idR = <%//= request.getAttribute("idRech") %>;
                                //var typeCherch =<%//= request.getAttribute("typeCherch") %>;
                            </script>
                            
                                <input type="hidden" id="idd" name="idd"/>
                                <input type="hidden" id="idR" name="idR"/>
                               <input type="hidden" id="typeCherch" name="typeCherch"/>


                        </form>
  
    </body>

</html>

