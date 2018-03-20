package com.projetjees3.servlets;


import com.projetjees3.dao.ChercheurDaoImpMark;
import com.projetjees3.beans.RechBean;
import com.projetjees3.beans.ThemeBean;
import com.projetjees3.beans.UserInsert;
import com.projetjees3.dao.DaoException;
import com.projetjees3.dao.DaoFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;


public class AddMarkUser extends HttpServlet 
{

    private static final long serialVersionUID = 1L;
    private ChercheurDaoImpMark rechercheDao;
    
    
    public void init() throws ServletException
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.rechercheDao = daoFactory.getChercheurDao1();
    }
    
    public AddMarkUser()
     {
         super();
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {   
        this.getServletContext().getRequestDispatcher("/WEB-INF/AddMarkUser.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
     //this.getServletContext().getRequestDispatcher("/WEB-INF/AddMarkUser.jsp").forward(request, response);   
    }

}
