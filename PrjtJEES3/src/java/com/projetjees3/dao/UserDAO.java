
package com.projetjees3.dao;
import com.projetjees3.beans.UserBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO 	
{
   static Connection currentCon = null;
   static ResultSet rs = null;  
   static ResultSet rs2 = null;  
   static ResultSet rs3 = null;  
   public static int idU;
   public static int typeCherchU;
   public static UserBean login(UserBean bean) 
   {
	
      //preparing some objects for connection 
      Statement stmt = null;    
      Statement stmt2 = null;    

      String email = bean.getEmail();    
      String password = bean.getPsw();   
	  // requete pour chercher l'utilisateur dans la base de données ( la table users)
      String searchQuery = "select * from utilisateur where email_user='"+ email+ "' AND psw_user='"+ password+ "'";

     // "System.out.println" prints in the console; Normally used to trace the process
    System.out.println("Your user name is " + email);          
    System.out.println("Your password is " + password);
    System.out.println("Query1: "+searchQuery);

   try 
   {
      //connect to DB 
      currentCon = DaoFactory.getConnection();
      stmt=currentCon.createStatement();
      stmt2=currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);	        
      boolean more = rs.next();
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
         bean.setValid(false);
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         String firstName = rs.getString("prenom_user");
         String lastName = rs.getString("nom_user");
         String desc = rs.getString("desc_user");
         String niveau = rs.getString("niv_user");
         String dateN = rs.getString("date_naiss_user");
         String pays = rs.getString("pays_org_user");
         int typeCherch = rs.getInt("type_cherch");
         System.out.println("type cherch: "+typeCherch);
         int id = rs.getInt("id_user");
       String searchQuery2 = "select nom_rech,desc_rech from recherche where id_rech in(select id_rech from cherch_rech_at where id_user ='"+ id+"')";
         rs2 = stmt2.executeQuery(searchQuery2);
         int i=0;
         int count = 0;
         while (rs2.next()) {
                count++;
         }
         rs2 = stmt2.executeQuery(searchQuery2);
         String[][] listRech = new String[count][2];
         while(rs2.next()){
             listRech[i][0] = rs2.getString("nom_rech");
             listRech[i][1] = rs2.getString("desc_rech");
             i++;
         }
         System.out.println("Welcome " + firstName + lastName);
         System.out.println("Welcome id =" + id);
         idU = id;
         typeCherchU = typeCherch;
         bean.setFirstName(firstName);
         bean.setLastName(lastName);
         bean.setDesc(desc);
         bean.setNiveau(niveau);
         bean.setDateN(dateN);
         bean.setPays(pays);
         bean.setId(id);
         bean.setListe(listRech);
         bean.setTypeCherch(typeCherch);
         bean.setValid(true);
      }
      
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (SQLException e) {}
            rs = null;
         }
      if (rs2 != null)	{
         try {
            rs2.close();
         } catch (SQLException e) {}
            rs2 = null;
         }
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {}
            stmt = null;
         }
      if (stmt2 != null) {
         try {
            stmt2.close();
         } catch (SQLException e) {}
            stmt2 = null;
         }
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (SQLException e) {
         }

         currentCon = null;
      }
   }

return bean;
	
   }
public static ArrayList<UserBean> location(String loc) 
   {
	
      //preparing some objects for connection 
      Statement stmt4 = null;    
      String searchQuery ="select id_user,nom_user,visib_user from utilisateur where id_user in(Select id_user from cherch_rech_at where id_rech in(select id_rech from rechercheat where loc_rech_at='"+loc+"'))";
     // "System.out.println" prints in the console; Normally used to trace the process
    ArrayList<UserBean> list=new ArrayList<UserBean>();
    UserBean user = new UserBean();
     
    // Integer idss =new Integer();
     
    System.out.println("Query ids: "+searchQuery);

   try 
   {  int i=0;
      //connect to DB 
      currentCon = DaoFactory.getConnection();
      stmt4=currentCon.createStatement();

      rs = stmt4.executeQuery(searchQuery);
      
      while(rs.next()) 
      {
          int id = rs.getInt("id_user");
          String nom = rs.getString("nom_user");
          String visib = rs.getString("visib_user");          
          user.setIdUserBean(id);
          user.setLastName(nom);
          user.setVisibUser(visib);
          list.add(user);
          
           //list.add(new Integer(rs.getInt("id_user")));
         
         
      }
      
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (SQLException e) {}
            rs = null;
         }

      if (stmt4 != null) {
         try {
            stmt4.close();
         } catch (SQLException e) {}
            stmt4 = null;
         }

      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (SQLException e) {
         }

         currentCon = null;
      }
   }

return list;
	
   }
   
   
}


