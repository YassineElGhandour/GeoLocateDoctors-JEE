package com.projetjees3.servlets;


import com.projetjees3.beans.BeanException;
import com.projetjees3.beans.UserBean;
import com.projetjees3.dao.ChercheurDaoImpl;
import com.projetjees3.dao.DaoException;
import com.projetjees3.dao.DaoFactory;
import static com.projetjees3.servlets.ProfileDoc.idRech;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileDoc extends HttpServlet 
{

    private static final long serialVersionUID = 1L;
    public static int idRech = (int) Math.round(Math.random()*1000) ;
    public static String idU;
    private ChercheurDaoImpl chercheurDao;
    
    public void init() throws ServletException
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chercheurDao = daoFactory.getChercheurDao();
    }
    
    public ProfileDoc()
     {
         super();
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {   
        HttpSession session = request.getSession();
        idRech ++;
        request.setAttribute("idRech",idRech);
        idU = request.getParameter("idd");
        /*
        UserBean user = new UserBean();
        String id = request.getParameter("utilsa");
        if(id == null || id.equals(""))
        {
            if(session.getAttribute("id")==null)
            {
                response.sendRedirect("/ProjetJEES3/home#login");
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
                request.setAttribute("recherches", chercheurDao.lister7(id));
            } 
            catch (BeanException | DaoException ex) 
            {
                
            }
        }
        //userBean =(new UserBean()).getIdUser(id);
        request.setAttribute("user", user); */
        this.getServletContext().getRequestDispatcher("/WEB-INF/profiledoc.jsp").forward(request, response);
        //response.sendRedirect("/ProjetJEES3/profiledoc");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {      

    }
    
}
