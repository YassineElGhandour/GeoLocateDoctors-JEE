<%@page import="java.lang.String"%>
<%@ page import= "java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@page import="com.projetjees3.beans.UserBean" %>
<% UserBean s = (UserBean) session.getAttribute("currentMark"); %>

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
        <title>DocLoc | Consulter des recherches</title>
    </head>


        
    <body>
        
    <%@ include file='navbar.jsp'%>
        
    <div class="container" >
        <h1>Bienvenue sur DocLoc</h1>

    </div>
    <br/>
    <div class="container" align ="center">
        <div id="map" style="width:900px;height:500px"></div> 

    <div id="map"></div>    
    <script>

      var map;
      var po;
      var marker1;
      function initMap() {
        var haightAshbury = {lat: 51.5, lng: -0.12 };
        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 3,
          center: haightAshbury,
          mapTypeId: 'terrain'
        });
        

        // This event listener will call addMarker() when the map is clicked.
 <%  
     
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");
    }
    catch(ClassNotFoundException e) 
    {
        System.err.print("ClassNotFoundException: ");
        System.err.println(e.getMessage());
    }    
    try 
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "");
        Statement st = con.createStatement();
        Statement st3 = con.createStatement();
        String query = "SELECT loc_rech_at FROM rechercheat";
        System.out.println("query : " +query); 
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
            String position1  =rs.getString("loc_rech_at");
      
            Statement st2 = con.createStatement();
            String query2 = "Select id_user from cherch_rech_at where id_rech in(select id_rech from rechercheat where loc_rech_at='"+position1+"')";
            ResultSet rs2 = st2.executeQuery(query2);
            while(rs2.next())
            { 
                int idd= rs2.getInt("id_user");
                //iddU = idd;
                System.out.println("OO: "+idd);
            }
      
            char ss1 = position1.charAt(0);
            String foo1 = position1.replace(ss1 ,' ');
            char ss2 = foo1.charAt(foo1.length()-1);
            String foo2 = foo1.replace(ss2 ,' ');
            String[] loc = foo2.split(",");
%>          
        var myLatlng = new google.maps.LatLng(<%=loc[0]%>,<%=loc[1]%>);
        addMarker(myLatlng);
 <%     }

        rs.close();
        //rs2.close();  
        con.close(); }
        catch(SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }   
 %>   
    }
        function addMarker(location) 
        {
        var marker = new google.maps.Marker({
          position: location,
          map: map,
          title :"hello"
          
        }); 

        
      <%  char ss1 = s.getLoc().charAt(0);
            String foo1 = s.getLoc().replace(ss1 ,' ');
            char ss2 = foo1.charAt(foo1.length()-1);
            String foo2 = foo1.replace(ss2 ,' ');
            String[] loc = foo2.split(",");
       %> 
          var myLatlng1 = new google.maps.LatLng(<%=loc[0]%>,<%=loc[1]%>);
          marker1 = new google.maps.Marker({
          position: myLatlng1,
          map: map,
          
          
        }); 
         <c:forEach items="${ids}" var="user">    
             
        var infoWindow = new google.maps.InfoWindow({
                    
        content: '<c:if test="${user.visibUser == '1'}"><a href="profildoc2?idd=<c:out value="${user.idUserBean}"/>">  Voir profile :<c:out value="${user.lastName}"/> <c:out value="${user.visibUser}"/></a><br/></c:if><c:if test="${user.visibUser == '0'}"> Voir profile :<c:out value="${user.lastName}"/> <c:out value="${user.visibUser}"/><br/></c:if>'
            
         
            
        });
        </c:forEach>
        
        infoWindow.open(map, marker1);
        marker.addListener('click', function()
        {   
           po = marker.getPosition();
           window.location = "http://localhost:8080/ProjetJEES3/simpleresearch2?pos="+po;


        });
    
        
}

        //markers.push(marker);
        
        
        
    </script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDnC9oPvCGKXXbGYG5JSO0efpoPRYP2S7A&callback=initMap">
     </script>
   </div>
  </body>


</html>



