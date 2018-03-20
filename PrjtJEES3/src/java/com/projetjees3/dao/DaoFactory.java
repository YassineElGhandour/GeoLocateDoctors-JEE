package com.projetjees3.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory 
{
    private static Connection connexion;
    private static String url;
    private static String username;
    private static String password;
    
    DaoFactory(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    
    public static DaoFactory getInstance()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        
        String urlJdbc = "jdbc:mysql://localhost:3306/projet";
        String userJdbc = "root";
        String mdpJdbc = "";
        DaoFactory instance = new DaoFactory(urlJdbc, userJdbc, mdpJdbc);
        
        return instance;
    }
    
    public static Connection getConnection() throws SQLException
    {
        connexion =  DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion;
        
    }
    //Récupération du DAO : Data Access Objet
    public ChercheurDaoImpl getChercheurDao()
    {
        return new ChercheurDaoImpl(this);
    }
    
    public ChercheurDaoImpMark getChercheurDao1()
    {
        return new ChercheurDaoImpMark(this);
    }   
}


