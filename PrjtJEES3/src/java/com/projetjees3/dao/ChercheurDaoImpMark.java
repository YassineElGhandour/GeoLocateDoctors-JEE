package com.projetjees3.dao;

import com.projetjees3.beans.BeanException;
import com.projetjees3.beans.RechBean;
import com.projetjees3.beans.ThemeBean;
import com.projetjees3.beans.UserBean;
import java.util.ArrayList;
import java.util.List;
import com.projetjees3.beans.UserInsert;
import com.projetjees3.servlets.ProfileDoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import com.projetjees3.beans.UserBean;
import com.projetjees3.dao.UserDAO;
import com.projetjees3.servlets.AfterInscription;

public class ChercheurDaoImpMark 
{


    private DaoFactory daoFactory;
    private DaoFactory daoFactory2;
    private DaoFactory daoFactory3;
    private DaoFactory daoFactory4;
    private Connection connexion;
    private Connection connexion2;
    private Connection connexion3;
    private Connection connexion4;
    private Connection connexion5;
    //final HttpSessionEvent se;
    //Constructor
    ChercheurDaoImpMark(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }
    
    
        
    public void ajouter(UserInsert chercheur, String idU,int idRech, String msg4) throws DaoException, SQLException
    {
        int bb = idRech ;
        PreparedStatement preparedStatement = null;
        int a;
        a =(int) Math.round(Math.random()*100);
        try
        {
            if("1".equals(msg4))
                {
                    connexion = daoFactory.getConnection();
                    String sqlLine = "INSERT INTO rechercheat(id_rech_at,id_rech, loc_rech_at) VALUES('"+a+"','"+bb+"', ?)";
                    preparedStatement = connexion.prepareStatement(sqlLine);
                    preparedStatement.setString(1, chercheur.getMark());
                    preparedStatement.executeUpdate();   
                    connexion.commit();
            
                    connexion2 = daoFactory2.getConnection();
                    String sqlLine2 = "INSERT INTO cherch_rech_at VALUES('"+UserDAO.idU+"','"+UserDAO.idU+"','"+bb+"','"+a+"')";
                    preparedStatement = connexion2.prepareStatement(sqlLine2);
                    preparedStatement.executeUpdate();
                    connexion2.commit();        
                }
                
             if(AfterInscription.msg4 == null)
             {
                 connexion3 = daoFactory3.getConnection();
                 String sqlLine3 = "INSERT INTO recherchest(id_rech_st,id_rech) VALUES('"+a+"','"+bb+"')";
                 preparedStatement = connexion.prepareStatement(sqlLine3);
                 preparedStatement.executeUpdate();
                 connexion3.commit();
                 
                 connexion4 = daoFactory4.getConnection();
                 String sqlLine4 = "INSERT INTO cherch_rech_st VALUES('"+UserDAO.idU+"','"+UserDAO.idU+"','"+bb+"','"+a+"')";
                 preparedStatement = connexion4.prepareStatement(sqlLine4);
                 preparedStatement.executeUpdate();
                 connexion4.commit();
             } else {
             }
          
        }
        catch(SQLException e)
        {
            try
            {
                if (connexion != null)
                {
                    connexion.rollback();
                }
                if (connexion2 != null)
                {
                    connexion2.rollback();
                }
            }
            
            catch(SQLException e2)
            {
                e2.printStackTrace();
            }
            
            throw new DaoException("Erreur de communication avec la BDD");
        }
        
    }
    
    public void ajouterRech(RechBean recherche, ThemeBean theme, UserInsert chercheur,int idRech, String msg4) throws DaoException, SQLException
    {
        PreparedStatement preparedStatement = null;
        int a, c;
        a =(int) Math.round(Math.random()*100);
        c =(int) Math.round(Math.random()*100);
        System.out.println("I had lost hope:"+AfterInscription.msg4);
        System.out.println("I had lost hope for 5:"+AfterInscription.msg5);
        try
        { 
            int bb = idRech ;           
            connexion = daoFactory.getConnection();
            String sqlLine = "INSERT INTO recherche(id_rech, nom_rech, desc_rech, uni_rech, terr_rech, labo_rech, pays_rech, mots_cle_rech) VALUES('"+bb+"', ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(sqlLine);
            preparedStatement.setString(1, recherche.getNomRech());
            preparedStatement.setString(2, recherche.getDescRech());
            preparedStatement.setString(3, recherche.getUniRech());
            preparedStatement.setString(4, recherche.getTerrainRech());
            preparedStatement.setString(5, recherche.getLaboRech());
            preparedStatement.setString(6, recherche.getPaysRech());
            preparedStatement.setString(7, recherche.getMotsCleRech());
            preparedStatement.executeUpdate();
            connexion.commit();
            
            String uno ="1";
            //if(chercheur.getType_cherch().equals(uno))
            
            /**
                connexion2 = daoFactory.getConnection();
                String sqlLine2 = "INSERT INTO recherchest(id_rech_st,id_rech) VALUES('"+a+"','"+a+"')";
                preparedStatement = connexion2.prepareStatement(sqlLine2);
                preparedStatement.executeUpdate();   
                connexion2.commit();
            
                connexion3 = daoFactory2.getConnection();
                String sqlLine3 = "INSERT INTO cherch_rech_st VALUES('"+id+"', '"+id+"','"+a+"','"+a+"')";
                preparedStatement = connexion3.prepareStatement(sqlLine3);
                preparedStatement.executeUpdate();
                connexion3.commit();
              **/
            
            connexion4= daoFactory.getConnection();
            String sqlLine4 = "INSERT INTO theme(id_theme, nom_theme) VALUES('"+c+"', ?)";
            preparedStatement = connexion4.prepareStatement(sqlLine4);
            preparedStatement.setString(1, theme.getNomTheme());
            preparedStatement.executeUpdate();   
            connexion4.commit();
            
            connexion5 = daoFactory.getConnection();
            String sqlLine5 = "INSERT INTO rech_theme(id_rech, id_theme) VALUES('"+bb+"', '"+c+"')";
            preparedStatement = connexion5.prepareStatement(sqlLine5);
            preparedStatement.executeUpdate();   
            connexion5.commit();
            
        }
        catch(SQLException e)
        {
            try
            {
                if (connexion3 != null)
                {
                    connexion3.rollback();
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
            String sqlLineTwo = "SELECT nom_user, prenom_user FROM utilisateur";
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(sqlLineTwo);
            
            while(resultat.next())
            {
                String nom_cherch = resultat.getString("nom_user");
                String prenom_cherch = resultat.getString("prenom_user");

                UserInsert chercheur = new UserInsert();
                chercheur.setNomCherch(nom_cherch);
                chercheur.setPrenomCherch(prenom_cherch);
                
                users.add(chercheur);
                
            }
        }
        
        catch(SQLException e)
        { 
            e.printStackTrace();
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
    


}
