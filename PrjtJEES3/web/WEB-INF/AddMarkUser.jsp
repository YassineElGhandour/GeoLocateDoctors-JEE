<%@page import="com.projetjees3.servlets.ProfileDoc" %>
    <% UserBean s = (UserBean) session.getAttribute("currentSessionUser"); %>

<!DOCTYPE html>
<html>
    <c:if test="${sessionScope.currentSessionUser == null}" > 
            <%   response.sendRedirect("/ProjetJEES3/home#login");  %>
    </c:if>
    <c:if test="${sessionScope.currentSessionUser != null}" > 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<!--<link rel="stylesheet" href="css/smallbody.css" />-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
        <title>DocLoc | Ajouter vos recherches</title>
    </head>

    <body>
    <%@ include file='navbar.jsp'%>
     <form method="POST" action="Test">
    
    <div class="container" >
        <h1>Ajouter une recherche</h1>
        <br/><br/>
    
            <div class="form-group row">
                <label for="nomrech" class="col-sm-2 col-form-label">Nom de la recherche :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nomrech" name="nomrech" placeholder="nom de la recherche" required>
                </div>
            </div>
            
            <div class="form-group row">
                <label for="descrech" class="col-sm-2 col-form-label">Description sur la recherche :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="descrech" name="descrech" placeholder="description" required>
                </div>
            </div>
            
            <div class="form-group row">
                <label for="nomtheme" class="col-sm-2 col-form-label">Thème :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nomtheme" name="nomtheme" placeholder="theme" required>
                </div>
            </div>
        
            <div class="form-group row">
                <label for="unirech" class="col-sm-2 col-form-label">Université ou Institution:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="unirech" name="unirech" placeholder="où avez vou effectuer votre recherche?" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="terrainrech" class="col-sm-2 col-form-label">Terrain de recherche :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="terrainrech" name="terrainrech" placeholder="sur quel terrain avez vou effectuer votre recherche?" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="laborech" class="col-sm-2 col-form-label">Laboratoire de recherche :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="laborech" name="laborech" placeholder="dans quel labo avez vou effectuer votre recherche?" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="paysrech" class="col-sm-2 col-form-label">Pays de recherche :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="paysrech" name="paysrech" placeholder="dans quel pays avez vou effectuer votre recherche?" required>
                </div>
            </div>
   
            <div class="form-group row">
                <label for="motsclesrech" class="col-sm-2 col-form-label">Mots Clés :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="motsclesrech" name="motsclesrech" placeholder="pour faciliter la compréhension du ujet en général" required>
                </div>
            </div>
        
     </div>
     
    <br/>
    
    <script>

    </script>
<% if(s.getTypeCherch() ==1) {%>

    <div class="container" align ="center">
        <div id="map" style="width:1000px;height:1000px"></div> 
<div id="floating-panel">
      <input onclick="clearMarkers();" type=button value="Hide Markers">
      <input onclick="showMarkers();" type=button value="Show All Markers">
      <input onclick="deleteMarkers();" type=button value="Delete Markers">
    </div>
    <div id="map"></div>
    <p>pour confirmer votre les emplacements de votre marqueur(s) : </p>
    </br>
    <p>Veuillez cliquer(forcément) sur le button "Show All Markers" (le nombre de markers que vous avez choisir)fois </p>
  
    <script>

      // In the following example, markers appear when the user clicks on the map.
      // The markers are stored in an array.
      // The user can then click an option to hide, show or delete the markers.
      var map;
      var markers = [];
      var pos = [];

      function initMap() {
        var haightAshbury = {lat: 51.5, lng: -0.12 };

        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 3,
          center: haightAshbury,
          mapTypeId: 'terrain'
        });
        // This event listener will call addMarker() when the map is clicked.
        map.addListener('click', function(event) {
          addMarker(event.latLng);
		  var ps = event.latLng; 
		  //alert(ps);
		  //alert(ps.lat()); alert(ps.getA
        });

        // Adds a marker at the center of the map.
        //addMarker(haightAshbury);

	    
      }

		//alert(mLatLang);
      // Adds a marker to the map and push to the array.
      function addMarker(location) {
        var marker = new google.maps.Marker({
          position: location,
          map: map
        });
        markers.push(marker);
		
      }
            
         
      // Sets the map on all markers in the array.
      function setMapOnAll(map) {
        for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(map);
		  //var lat1[i] = markers[i].getPosition().lat();
		  //var lng1[i] = markers[i].getPosition().lng();
		  //alert(lat1[i]);
		  //alert(lng1[i]);
                  if(i!= (markers.length -1)){
		  pos[i] = markers[i].getPosition()+"#";
                  }
                  else{pos[i] = markers[i].getPosition();}
          alert(pos[i]);

        }//###
        document.getElementById('urlPop').value = pos;
        document.getElementById('urlPop2').value = pos.length;
        document.getElementById('h').value = <%= s.getTypeCherch()%>;
      }

      // Removes the markers from the map, but keeps them in the array.
      function clearMarkers() {
        setMapOnAll(null);
      }

      // Shows any markers currently in the array.
      function showMarkers() {
        setMapOnAll(map);
      }

      // Deletes all markers in the array by removing references to them.
      function deleteMarkers() {
        clearMarkers();
        markers = [];
        
      }


    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDnC9oPvCGKXXbGYG5JSO0efpoPRYP2S7A&callback=initMap">
    </script>
    </div>
    
    <br/>
   
    
    <input type="hidden" id="urlPop" name="urlPop"/>
    <input type="hidden" id="urlPop2" name="urlPop2"/>
     
       <input type="hidden" id="h" name="h"/>
   
     
     <% }
    if (s.getTypeCherch() ==0){%>
<script> document.getElementById('m').value = "0"%>;</script>
<input type="hidden" id="m" name="m"/>
    <%}%>
  


    <input type="submit" value="valider" />
   
 
     </form>
    </body>
    </c:if>
</html>
