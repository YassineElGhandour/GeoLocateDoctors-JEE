package com.projetjees3.servlets;

import com.projetjees3.beans.BeanException;
import com.projetjees3.dao.ChercheurDaoImpl;
import com.projetjees3.dao.DaoFactory;
import com.projetjees3.beans.UserBean;
import com.projetjees3.dao.DaoException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class profildoc2 extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;
    
    public profildoc2()
     {
         super();
     }
    
    private ChercheurDaoImpl chercheurDao;
    
    public void init() throws ServletException
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chercheurDao = daoFactory.getChercheurDao();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {   
        HttpSession session = request.getSession();
        UserBean user = new UserBean();
        int id = 0;
        try
        {
        id = Integer.parseInt(request.getParameter("idd"));
        }
        catch(Exception e){}
        
        if(id == 0)
        {
            if(session.getAttribute("id")==null)
            {
                //response.sendRedirect("/ProjetJEES3/home#login");
            }
            else
            {
                user = (UserBean) session.getAttribute("currentSessionUser");
            }
            
        }
        else
        {
            try 
            {
                user =(new ChercheurDaoImpl()).lister7(id);
            } 
            catch (BeanException | DaoException ex) 
            {
                
            }
        }
        //userBean =(new UserBean()).getIdUser(id);
        request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/profildoc2.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }

}
