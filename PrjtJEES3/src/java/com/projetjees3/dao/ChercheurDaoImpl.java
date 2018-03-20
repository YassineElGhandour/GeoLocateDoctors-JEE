package com.projetjees3.dao;

import com.projetjees3.beans.BeanException;
import com.projetjees3.beans.RechBean;
import com.projetjees3.beans.UserBean;
import java.util.ArrayList;
import java.util.List;
import com.projetjees3.beans.UserInsert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChercheurDaoImpl 
{
    private DaoFactory daoFactory;
    private DaoFactory daoFactory2;
    private Connection connexion;
    private Connection connexion2;
    private Connection connexion3;  
    //Constructor
    ChercheurDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public static int b;

    public ChercheurDaoImpl() {
        super();
    }


    public void ajouter(UserInsert chercheur) throws DaoException, SQLException
    {   b =(int) Math.round(Math.random()*100);
        PreparedStatement preparedStatement = null;
        try
        {
            connexion = daoFactory.getConnection();
            String sqlLine = "INSERT INTO utilisateur(id_user,nom_user, prenom_user, email_user, num_tel_user, desc_user,"
                    + " date_naiss_user, niv_user, pays_org_user, pos_act_user, psw_user,type_cherch,visib_user) VALUES('"+(b)+"',?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            preparedStatement = connexion.prepareStatement(sqlLine);
            preparedStatement.setString(1, chercheur.getNomCherch());
            preparedStatement.setString(2, chercheur.getPrenomCherch());
            preparedStatement.setString(3, chercheur.getEmailCherch());
            preparedStatement.setString(4, chercheur.getNumTelCherch());
            preparedStatement.setString(5, chercheur.getDescCherch());
            preparedStatement.setString(6, chercheur.getDateNaissCherch());
            preparedStatement.setString(7, chercheur.getNivCherch());
            preparedStatement.setString(8, chercheur.getPaysOrgCherch());
            preparedStatement.setString(9, chercheur.getPostActCherch());
            preparedStatement.setString(10, chercheur.getPswCherch());
            preparedStatement.setString(11, chercheur.getType_cherch());
            preparedStatement.setString(12, chercheur.getVisibCherch());
           
            preparedStatement.executeUpdate();
            
            connexion.commit();
            
            connexion3 = daoFactory2.getConnection();
            
            String zero = "0";
            if(chercheur.getType_cherch().equals("1"))
            { 
            
                String sqlLine2 = "INSERT INTO chercheur_at VALUES('"+ChercheurDaoImpl.b+"','"+(ChercheurDaoImpl.b)+"')";
                preparedStatement = connexion3.prepareStatement(sqlLine2);
                preparedStatement.executeUpdate();}
            
            else
            {
                String sqlLine2 = "INSERT INTO chercheur_st VALUES('"+ChercheurDaoImpl.b+"','"+(ChercheurDaoImpl.b)+"')";
                preparedStatement = connexion3.prepareStatement(sqlLine2);
                preparedStatement.executeUpdate();         
            }
            connexion3.commit();
            
        }
        catch(SQLException e)
        {
            try
            {
                if (connexion != null)
                {
                    connexion.rollback();
                }
            }
            
            catch(SQLException e2)
            {
                e2.printStackTrace();
            }
            
            throw new DaoException("Erreur de communication avec la BDD");
        }
        
    }

    
    public List<UserInsert> lister() throws BeanException, DaoException
    {
        List<UserInsert> users = new ArrayList<UserInsert>();
        Statement statement = null;
        ResultSet resultat = null;
        
        try
        {
            String sqlLineTwo = "SELECT id_user, nom_user, prenom_user FROM utilisateur";
            
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(sqlLineTwo);
            
            
            while(resultat.next())
            {
                int id_user = resultat.getInt("id_user");
                System.out.println("Id User is:" +id_user);
                String nom_cherch = resultat.getString("nom_user");
                String prenom_cherch = resultat.getString("prenom_user");
                
                UserInsert chercheur = new UserInsert();
                
                chercheur.setIdUser(id_user);
                chercheur.setNomCherch(nom_cherch);
                chercheur.setNomCherch(prenom_cherch);
                
                users.add(chercheur);
                
            }
        }
        
        catch(SQLException e)
        { 
        }
        
        finally
        {
            try
            {
                if(connexion != null)
                {
                    connexion.close();
                }
            }
            catch(SQLException e)
            {
                throw new DaoException("Erreur dans la connexion avec la BDD");
            }
        }
        
        return users;
    }
    
     public List<RechBean> lister5() throws BeanException, DaoException
    {
        List<RechBean> users5 = new ArrayList<RechBean>();
        Statement statement = null;
        ResultSet resultat = null;
        ResultSet resultat2 = null;
        ResultSet resultat3 = null;
        
        try
        {
            String sqlLineTwo = "SELECT loc_rech_at FROM rechercheat";
            
            
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(sqlLineTwo);
            
            String position1;
            
            while(resultat.next())
            {
                position1  =resultat.getString("loc_rech_at");
                
                String query2 = "Select id_rech_at from rechercheat where loc_rech_at='"+position1+"'";
                
                connexion = daoFactory.getConnection();
                statement = connexion.createStatement();
            
                resultat2 = statement.executeQuery(query2);
                String nom, prenom;
                
                while(resultat2.next())
                {
                    int id = resultat2.getInt("id_rech_at");
                    
                    RechBean user = new RechBean();
                    user.setIdRech(id);
                    
                    users5.add(user);
                    
                }
                
                
            }
        }
        
        catch(SQLException e)
        { 
        }
        
        finally
        {
            try
            {
                if(connexion != null)
                {
                    connexion.close();
                }
            }
            catch(SQLException e)
            {
                throw new DaoException("Erreur dans la connexion avec la BDD");
            }
        }
        
        return users5;
    }
     
    public List<RechBean> lister2() throws BeanException, DaoException
    {

        List<RechBean> recherches = new ArrayList<RechBean>();
        Statement statement = null;
        ResultSet resultat2 = null;
        
        try
        {
            String sqlLineTwo = "SELECT id_user, nom_user, prenom_user FROM utilisateur";
            connexion2 = daoFactory2.getConnection();
            statement = connexion2.createStatement();
            ResultSet resultat = statement.executeQuery(sqlLineTwo);
            int id;
            String nom, prenom;
            while(resultat.next())
            {
                id = resultat.getInt("id_user");
                nom = resultat.getString("nom_user");
                prenom = resultat.getString("prenom_user");
                String sqlLineThree = "SELECT nom_rech, desc_rech, uni_rech, terr_rech, labo_rech, pays_rech, mots_cle_rech FROM recherche where id_rech in(SELECT id_rech from cherch_rech_at where id_user='"+id+"')";
                connexion = daoFactory.getConnection();
                statement = connexion.createStatement();
            
                resultat2 = statement.executeQuery(sqlLineThree);
            
                while(resultat2.next())
                {
                    String nom_rech = resultat2.getString("nom_rech");
                    String desc_rech = resultat2.getString("desc_rech");
                    String uni_rech = resultat2.getString("uni_rech");
                    String terr_rech = resultat2.getString("terr_rech");
                    String labo_rech = resultat2.getString("labo_rech");
                    String pays_rech = resultat2.getString("pays_rech");
                    String mots_cle_rech = resultat2.getString("mots_cle_rech");
                
                

                    RechBean recherche = new RechBean();

                    
                    recherche.setNomRech(nom_rech);
                    recherche.setDescRech(desc_rech);
                    recherche.setUniRech(uni_rech);
                    recherche.setTerrainRech(terr_rech);
                    recherche.setLaboRech(labo_rech);
                    recherche.setPaysRech(pays_rech);
                    recherche.setMotsCleRech(mots_cle_rech);
                    recherche.setNomUser(nom);
                    recherche.setPrenomUser(prenom);

                    recherches.add(recherche);
                
            }}
        }
        
        catch(SQLException e)
        { 
           
        }
        
        
        finally
        {
            try
            {
                if(connexion != null)
                {
                    connexion.close();
                }
            }
            catch(SQLException e)
            {
                throw new DaoException("Erreur dans la connexion avec la BDD");
            }
        }
        
        return recherches;
    }
      
    public UserBean lister7(int idUserBean) throws BeanException, DaoException
    {
        
        Statement statement = null;
        ResultSet resultat = null;
        UserBean chercheur = null;
        
        try
        {
            String sqlLineTwo = "SELECT * FROM utilisateur where id_user = '"+idUserBean+"'";
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(sqlLineTwo);
            
            
            while(resultat.next())
            {
                chercheur = new UserBean();
                int id = resultat.getInt("id_user");
                String nom = resultat.getString("nom_user");
                String prenom = resultat.getString("prenom_user");
                String desc = resultat.getString("desc_user");
                String pays = resultat.getString("pays_org_user");
                String date = resultat.getString("date_naiss_user");
                String nivUser = resultat.getString("niv_user");
                String posUser = resultat.getString("pos_act_user");
                chercheur.setIdUserBean(id);
                chercheur.setFirstName(nom);
                chercheur.setLastName(prenom);
                chercheur.setDesc(desc);
                chercheur.setPays(pays);
                chercheur.setDateN(date);
                chercheur.setNivUser(nivUser);
                chercheur.setPostAct(posUser);
                
                //chercheur.set(date);
                return chercheur;
            }
        }
        
        catch(SQLException e)
        { 
        }
        
        finally
        {
            try
            {
                if(connexion != null)
                {
                    connexion.close();
                }
            }
            catch(SQLException e)
            {
                throw new DaoException("Erreur dans la connexion avec la BDD");
            }
        }
        
        return chercheur;
    }   
    //pour chercher une recherche par mot clé   
    public List<RechBean> lister10(String s) throws BeanException, DaoException
    {

        List<RechBean> recherches = new ArrayList<RechBean>();
        Statement statement = null;
        ResultSet resultat2 = null;
        
        try
        {
            String sqlLineTwo = "SELECT id_user, nom_user, prenom_user FROM utilisateur where id_user in(select id_user from cherch_rech_at where id_rech in(select id_rech from recherche where mots_cle_rech like '%"+s+"%'))";
            connexion2 = daoFactory2.getConnection();
            statement = connexion2.createStatement();
            ResultSet resultat = statement.executeQuery(sqlLineTwo);
            int id;
            String nom, prenom;
            while(resultat.next())
            {
                id = resultat.getInt("id_user");
                nom = resultat.getString("nom_user");
                prenom = resultat.getString("prenom_user");
                String sqlLineThree = "SELECT nom_rech, desc_rech, uni_rech, terr_rech, labo_rech, pays_rech, mots_cle_rech FROM recherche where id_rech in(SELECT id_rech from cherch_rech_at where id_user='"+id+"')";
                connexion = daoFactory.getConnection();
                statement = connexion.createStatement();
            
                resultat2 = statement.executeQuery(sqlLineThree);
            
                while(resultat2.next())
                {
                    String nom_rech = resultat2.getString("nom_rech");
                    String desc_rech = resultat2.getString("desc_rech");
                    String uni_rech = resultat2.getString("uni_rech");
                    String terr_rech = resultat2.getString("terr_rech");
                    String labo_rech = resultat2.getString("labo_rech");
                    String pays_rech = resultat2.getString("pays_rech");
                    String mots_cle_rech = resultat2.getString("mots_cle_rech");
                
                

                    RechBean recherche = new RechBean();

                    
                    recherche.setNomRech(nom_rech);
                    recherche.setDescRech(desc_rech);
                    recherche.setUniRech(uni_rech);
                    recherche.setTerrainRech(terr_rech);
                    recherche.setLaboRech(labo_rech);
                    recherche.setPaysRech(pays_rech);
                    recherche.setMotsCleRech(mots_cle_rech);
                    recherche.setNomUser(nom);
                    recherche.setPrenomUser(prenom);

                    recherches.add(recherche);
                
            }}
        }
        
        catch(SQLException e)
        { 
           
        }
        
        
        finally
        {
            try
            {
                if(connexion != null)
                {
                    connexion.close();
                }
            }
            catch(SQLException e)
            {
                throw new DaoException("Erreur dans la connexion avec la BDD");
            }
        }
        
        return recherches;
    } 
    
     public int lister9(String email1) throws BeanException, DaoException
    {
        List<UserBean> emails = new ArrayList<UserBean>();
        Statement statement = null;
        ResultSet resultat = null;
        UserBean email = new UserBean();
        
        try
        {
            String sqlLine = "SELECT email_user FROM utilisateur where email_user = '"+email1+"'";

            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(sqlLine);
            
            boolean v = resultat.next();
            if(v)
            {
                email = new UserBean();
                String email_user = resultat.getString("email_user");
                email.setEmail(email_user);
                System.out.println("Emails: "+email_user);
                emails.add(email);
                return 1;
                
            }
            else{
                    return 0;
                }    
        }
        
        catch(SQLException e)
        { 
        }
        
        finally
        {
            try
            {
                if(connexion != null)
                {
                    connexion.close();
                }
            }
            catch(SQLException e)
            {
                throw new DaoException("Erreur dans la connexion avec la BDD");
            }
        }
        
        return 0;
    }
    

}